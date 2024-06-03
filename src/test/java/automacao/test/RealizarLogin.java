package automacao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import automacao.Pages.CadastroPage;
import automacao.Pages.HomePage;
import automacao.Pages.LoginPage;

public class RealizarLogin extends BaseTest {

    protected static LoginPage loginPage;
    protected static CadastroPage cadastroPage;
    protected static HomePage homePage;


    @Before
    public void instanciarPages() {
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void T001_RealizarLoginComSucesso() throws InterruptedException {
       //mairabrito@teste.com
       // teste@123
       cadastroPage.telaCadastroLogin();
       loginPage.RealizarLogin("mairabrito@teste.com", "teste@123");
       Thread.sleep(3000);
       assertTrue(homePage.LBL_Home.isDisplayed());


    }

    @Test
    public void T002_RealizarLoginInvalido() throws InterruptedException {

        cadastroPage.telaCadastroLogin();
        loginPage.RealizarLogin("mairabrito@teste.com", "XXXXX");
        Thread.sleep(3000);

        // Texto esperado
        String expectedText = "There is 1 error Authentication failed.";
        // Texto real da página
        String actualText = loginPage.LBL_ErroLogin().trim().replaceAll("\\s+", " ");
        assertEquals(expectedText, actualText);

    }
}
