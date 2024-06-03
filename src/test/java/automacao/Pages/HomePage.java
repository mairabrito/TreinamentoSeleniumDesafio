package automacao.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

   @FindBy(xpath = "//h1[@class='page-heading']")
   public WebElement LBL_Home;

    public HomePage(WebDriver driver){
       super(driver);
    }

}
