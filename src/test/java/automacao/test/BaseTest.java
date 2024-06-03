package automacao.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    
    protected static WebDriver driver;
    protected static String URL_BASE = "http://www.automationpractice.pl/index.php";
    protected static String CAMINHO_DRIVER = "src/test/java/automacao/resource/chromedriver.exe";

    //Iniciar o driver

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    // Finaliza o driver
    @After
    public void finalizar(){
        driver.quit();
    }
}
