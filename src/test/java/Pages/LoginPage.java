package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    @FindBy(css = "h4[class='card-header']") private WebElement header;
    @FindBy(css = "input[id='inputLogin']") private WebElement loginField;
    @FindBy(css = "input[id='inputPassword']") private WebElement passwordField;
    @FindBy(css = "button[class='btn btn-primary btn-lg btn-block']") private WebElement logInButton;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void loginField_validation(){

    }


}
