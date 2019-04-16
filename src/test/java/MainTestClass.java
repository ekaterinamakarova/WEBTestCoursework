/**
 *Главный тестовый класс, через который запускается процесс автоматизации.
 */

import Pages.FileReaderClass;

import Pages.InitialPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class MainTestClass {

    private WebDriver driver;

    FileReaderClass readerClass = new FileReaderClass();
    private InitialPage initialPage;


    @BeforeClass

    /** Метод с уставновкой драйвера браузера и пути к нему */
    public void setUp() throws IOException {

        System.setProperty("webdriver.chrome.driver", "/home/acciosky/Documents/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); /** Полноэкранный режим */
        driver.get(readerClass.readFromFile(0));
        initialPage = new InitialPage(driver);
    }

    @Test
    public void test(){
        initialPage.infoPresenceChecking();

    }

}
