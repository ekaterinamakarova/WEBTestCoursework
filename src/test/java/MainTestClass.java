/**
 *Главный тестовый класс, через который запускается процесс автоматизации.
 */

import Pages.FileReaderClass;

import Pages.InitialPage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class MainTestClass {

    private WebDriver driver;

    FileReaderClass readerClass = new FileReaderClass();
    private InitialPage initialPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;


    @BeforeClass

    /** Метод с уставновкой драйвера браузера и пути к нему */
    public void setUp() throws IOException {

        System.setProperty("webdriver.chrome.driver", "/home/acciosky/Documents/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); /** Полноэкранный режим */
        driver.get(readerClass.readFromFile(0));
        initialPage = new InitialPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Test cases 6-9")
    public void testInitialPage() {
        initialPage.navigationPresenceChecking();
        initialPage.navigationActivityChecking();
    }

    @Test(description = "Test cases _______", dependsOnMethods = "testInitialPage")
    public void testRegisterPage() throws IOException, InterruptedException {
        initialPage.toRegisterPage();
        registerPage.fieldsChecking();
        registerPage.firstNameField_validation();
        registerPage.secondNameField_validation();
        registerPage.loginField_validation();
        registerPage.emailField_validation();
        registerPage.passwordFields_validation();
        registerPage.inputOgExistindData();
        registerPage.validRegistration();
    }

    @Test(description = "Test cases _______", dependsOnMethods = "testRegisterPage")
    public void testLoginPage() throws IOException, InterruptedException {
        initialPage.toLoginPage();
        loginPage.fieldsPresence();
        loginPage.loginField_validation();
        loginPage.validLogin();


    }
}

