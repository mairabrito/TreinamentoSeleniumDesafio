package automacao.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;

public class CadastroPage extends BasePage{

    

    @FindBy(xpath = "//a[@class='login']")
    public WebElement LBLSingIN;

   @FindBy (className = "page-heading")
   public WebElement LBLAuthe;

   @FindBy (className = "page-subheading")
   public WebElement LBLCreateAccount;

   @FindBy (id = "id_gender1")
   public WebElement campoMr;

   @FindBy (id = "id_gender2")
   public WebElement campoMrs;

   @FindBy (id = "customer_firstname")
   public WebElement campoFirstName;

   @FindBy (id = "customer_lastname")
   public WebElement campoLastName;

   @FindBy (id = "email_create")
   public WebElement campoTXTEmail;

   @FindBy (id = "email")
   public WebElement campoEmailTelaCadastro;

   @FindBy (id = "SubmitCreate")
   public WebElement BTNCreate;

   @FindBy (id = "submitAccount")
   public WebElement BTNRegister;

   @FindBy (id = "passwd")
   public WebElement password;

   @FindBy (id = "newsletter")
   public WebElement campoNewsletter;


    public CadastroPage(WebDriver driver){
        super(driver);
    }

    public void telaCadastroLogin(){
      LBLSingIN.click();
    }

    public void telaCadastro (String email){
        campoTXTEmail.sendKeys(email);
        BTNCreate.click();
        
    }

    public void preecherCadastro (int mrMrs,String firstName, String lastName, String email, String passwordX, int diaX, int mesX, int anoX) {

        
        if (mrMrs == 1){
            campoMr.click();
        } else if (mrMrs == 2){
            campoMrs.click();
        } else{
            return;
        }

        campoFirstName.sendKeys(firstName);
        campoLastName.sendKeys(lastName);

        String diaXPath = String.format("//*[@id='days']/option[@value='%d']", diaX);
        WebElement dia = driver.findElement(By.xpath(diaXPath));

        String mesXPath = String.format("//*[@id='months']/option[@value='%d']", mesX);
        WebElement mes = driver.findElement(By.xpath(mesXPath));

        String anoXPath = String.format("//*[@id='years']/option[@value='%d']", anoX);
        WebElement ano = driver.findElement(By.xpath(anoXPath));

        password.sendKeys(passwordX);

        dia.click();
        mes.click();
        ano.click();
        campoNewsletter.click();
        BTNRegister.click();
        
    }

    public String LBL_RegisterSucesso(){
        String mensagem = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
        return mensagem;
    }

    public String LBL_ErroCadastro(){
        String mensagem = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        return mensagem;
    }

}
