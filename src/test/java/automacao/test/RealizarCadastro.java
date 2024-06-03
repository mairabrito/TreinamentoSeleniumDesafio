package automacao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import automacao.Pages.CadastroPage;

public class RealizarCadastro  extends BaseTest{

    
    protected static CadastroPage cadastroPage;

    @Before
    public void instanciarPages() {
        cadastroPage = new CadastroPage(driver);
    }

    @Test
    public void T001_AcessarTelaDeAutenticacaoComSucesso() throws InterruptedException {
        cadastroPage.telaCadastroLogin();
        assertTrue(cadastroPage.LBLAuthe.isDisplayed());
    }

    @Test
    public void T002_AcessarFormularioDeCadastroComSucesso() throws InterruptedException {

        int complemento = (int)(Math.random() * 1000); 
        cadastroPage.telaCadastroLogin();
        //Thread.sleep(2000);
        cadastroPage.telaCadastro("maira"+complemento+"@teste.com");
       // Thread.sleep(2000);
        
    }

    @Test
    public void T003_CadastroComSucesso() throws InterruptedException {

        int complemento = (int)(Math.random() * 1000); 
        cadastroPage.telaCadastroLogin();
        cadastroPage.telaCadastro("maira"+complemento+"@teste.com");
        Thread.sleep(3000);
        cadastroPage.preecherCadastro(1, "Maira", "Brito", "teste@123", "maira"+complemento+"@teste.com", 1, 6, 1997);
        Thread.sleep(3000);
        assertEquals("Your account has been created.", cadastroPage.LBL_RegisterSucesso());

    }    

    @Test
    public void T004_CadastroCamposEmBrancos() throws InterruptedException {

        int complemento = (int)(Math.random() * 1000); 
        cadastroPage.telaCadastroLogin();
        cadastroPage.telaCadastro("maira"+complemento+"@teste.com");
        Thread.sleep(3000);
        cadastroPage.BTNRegister.click();
        Thread.sleep(3000);
       
        
        // Texto esperado
        String textoEsperado = "There are 3 errors lastname is required. firstname is required. passwd is required.";
        // Texto real da página
        String textoAtual = cadastroPage.LBL_ErroCadastro().trim().replaceAll("\\s+", " ");

        assertEquals(textoEsperado, textoAtual);

    }    
}
