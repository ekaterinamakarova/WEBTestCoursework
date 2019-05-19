package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RegisterPage {

    @FindBy(css = "div[class='card-header'] h4") public WebElement header;
    @FindBy(css = "input") public List<WebElement> fields;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]") private WebElement sign_in_button;


    WebDriver driver;
    HelpMethods helpMethods;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helpMethods = new HelpMethods(driver);
    }

    public String returnHeader(){
        return header.getText();
    }

    public void fieldsChecking(){
        Assert.assertEquals(fields.get(0).getAttribute("placeholder"), "First name");
        Assert.assertEquals(fields.get(1).getAttribute("placeholder"), "Second name");
        Assert.assertEquals(fields.get(2).getAttribute("placeholder"), "Login");
        Assert.assertEquals(fields.get(3).getAttribute("placeholder"), "Email");
        Assert.assertEquals(fields.get(4).getAttribute("placeholder"), "Password");
        Assert.assertEquals(fields.get(5).getAttribute("placeholder"), "Repeat password");
        Assert.assertEquals(sign_in_button.isDisplayed(),true);
    }

    public void fields_validation(){
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        fields.get(0).sendKeys("a");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "First name");
        fields.get(0).clear();
        fields.get(0).sendKeys("aa");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        fields.get(0).clear();
        fields.get(0).sendKeys("123456789123456789123456"); //23
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        fields.get(0).clear();
        fields.get(0).sendKeys("1234567891234567891234567"); //24
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        fields.get(0).clear();
        fields.get(0).sendKeys("12345678912345678912345678"); //25
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");



    }


}
