package automacao.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação de novas Pages.
 */
public abstract class BasePage {
    
    protected WebDriver driver;
    
      /*
     * Construtor para iniciar nossa página
     * @param driver (driver que está aberto no momento)
    */
    protected BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}