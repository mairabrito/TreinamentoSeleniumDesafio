package automacao.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    public WebElement campoTXT_email;

    @FindBy(id = "passwd")
    public WebElement campoTXT_password;

    @FindBy(id = "SubmitLogin")
    public WebElement BTN_Login;

    @FindBy(xpath = "//h3[@data-test='error']")
    public String erroLogin;


    public void RealizarLogin(String username, String password){
        campoTXT_email.sendKeys(username);
        campoTXT_password.sendKeys(password);
        BTN_Login.click();
    }



    public LoginPage(WebDriver driver){
        super(driver);
    }

    public String LBL_ErroLogin(){
        String mensagem = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        return mensagem;
    }
}
