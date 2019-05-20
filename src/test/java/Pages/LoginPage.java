package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage {

    @FindBy(css = "h4[class='card-header']") private WebElement header;
    @FindBy(css = "input[id='inputLogin']") private WebElement loginField;
    @FindBy(css = "input[id='inputPassword']") private WebElement passwordField;
    @FindBy(css = "button[class='btn btn-primary btn-lg btn-block']") private WebElement logInButton;
    @FindBy(css = "div[class='alert alert-warning error']") private WebElement error_alert;
    @FindBy(css = "a[id='accountDropDown']") private WebElement userName;


    WebDriver driver;
    FileReaderClass fileReaderClass;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        fileReaderClass = new FileReaderClass();
    }

    public String returnHeader(){
        return header.getText();
    }

    public void fieldsPresence(){
        System.out.println("-----LOGIN PAGE TEST-----");
        Assert.assertEquals(loginField.isDisplayed(),true);
        Assert.assertEquals(passwordField.isDisplayed(),true);
        Assert.assertEquals(logInButton.isDisplayed(),true);
        System.out.println("FIELDS PRESENCE TEST PASSED");
    }

    public void loginField_validation() throws IOException, InterruptedException {
        logInButton.click();
        loginField.sendKeys("altttr");
        passwordField.sendKeys(fileReaderClass.readFromFile(8));
        logInButton.click();
        Thread.sleep(200);
        Assert.assertTrue(error_alert.isDisplayed());
        loginField.clear();
        passwordField.clear();
        loginField.sendKeys(fileReaderClass.readFromFile(8));
        passwordField.sendKeys("qwerty");
        logInButton.click();
        Assert.assertTrue(error_alert.isDisplayed());
        System.out.println("LOGIN VALIDATION TEST PASSED");
    }

    public void validLogin() throws IOException, InterruptedException {
        driver.navigate().refresh();
        loginField.sendKeys(fileReaderClass.readFromFile(8));
        passwordField.sendKeys(fileReaderClass.readFromFile(9));
        logInButton.click();
        Thread.sleep(500);
        Assert.assertTrue(userName.isDisplayed());
        System.out.println("VALID LOGIN TEST PASSED");

    }


}
