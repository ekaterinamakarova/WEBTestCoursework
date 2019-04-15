import Pages.FileReaderClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class MainTestClass {
    private WebDriver driver;

    FileReaderClass readerClass = new FileReaderClass();

    @BeforeClass
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/acciosky/Documents/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(readerClass.readFromFile(0));
    }


    @Test
    public void test(){

    }

}
