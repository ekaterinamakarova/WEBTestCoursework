import WebSite.FileReaderClass;

import WebSite.InitialPage;
import WebSite.LoginPage;
import WebSite.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebTestClass {

    private WebDriver driver;
    FileReaderClass readerClass = new FileReaderClass();
    private InitialPage initialPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/acciosky/Documents/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(readerClass.readFromFile(0));
        initialPage = new InitialPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Test cases 2-9")
    public void testInitialPage() {
        initialPage.navigationPresenceChecking();
        initialPage.navigationActivityChecking();
    }

    @Test(description = "Test cases 10-43", dependsOnMethods = "testInitialPage")
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

    @Test(description = "Test cases 44-50", dependsOnMethods = "testRegisterPage")
    public void testLoginPage() throws IOException, InterruptedException {
        initialPage.toLoginPage();
        loginPage.fieldsPresence();
        loginPage.loginField_validation();
        loginPage.validLogin();
    }
}

