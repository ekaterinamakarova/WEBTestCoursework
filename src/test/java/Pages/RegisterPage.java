package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class RegisterPage {

    @FindBy(css = "div[class='card-header'] h4") public WebElement header;
    @FindBy(css = "input") public List<WebElement> fields;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]") private WebElement sign_in_button;


    WebDriver driver;
    HelpMethods helpMethods;
    FileReaderClass fileReaderClass;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helpMethods = new HelpMethods(driver);
        fileReaderClass = new FileReaderClass();
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

    public void firstNameField_validation(){
        WebElement firstName = fields.get(0);
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        firstName.sendKeys("a");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "First name");
        firstName.clear();
        firstName.sendKeys("aa");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        firstName.clear();
        firstName.sendKeys("123456789123456789123456"); //23
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        firstName.clear();
        firstName.sendKeys("1234567891234567891234567"); //24
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        firstName.clear();
        firstName.sendKeys("12345678912345678912345678"); //25
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        String[] checking = firstName.getAttribute("value").split("");
        Assert.assertEquals(checking.length, 24);
        firstName.clear();
        firstName.sendKeys("    "); //spaces
        sign_in_button.click();
        //Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "First name");
        firstName.clear();
        firstName.sendKeys("*/@*/--"); //spaces
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        firstName.clear();
    }

    public void secondNameField_validation(){
        WebElement secondName = fields.get(1);
        secondName.sendKeys("a");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Second name");
        secondName.clear();
        secondName.sendKeys("aa");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        secondName.clear();
        secondName.sendKeys("123456789123456789123456"); //23
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        secondName.clear();
        secondName.sendKeys("1234567891234567891234567"); //24
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        secondName.clear();
        secondName.sendKeys("12345678912345678912345678"); //25
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        String[] checking = secondName.getAttribute("value").split("");
        Assert.assertEquals(checking.length, 24);
        secondName.clear();
        secondName.sendKeys("    "); //spaces
        sign_in_button.click();
        //Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Second name");
        secondName.clear();
        secondName.sendKeys("*/@*/--"); //spaces
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        secondName.clear();
    }

    public void loginField_validation(){
        WebElement login = fields.get(2);
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        login.sendKeys("aaa"); //3
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Login");
        login.clear();
        login.sendKeys("aaab"); //4
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        login.clear();
        login.sendKeys("qwertyuiopasdfghjklzxcv"); //23
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        login.clear();
        login.sendKeys("qwertyuiopasdfghаjklzxcv"); //24
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        login.clear();
        login.sendKeys("12345678912345678912345678"); //25
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        String[] checking = login.getAttribute("value").split("");
        Assert.assertEquals(checking.length, 24);
        login.clear();
        login.sendKeys("//*@@*");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
    }

    public void emailField_validation(){
        WebElement email = fields.get(3);
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        email.sendKeys("ekaterina.makarova.1999mail.ru");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        email.clear();
        email.sendKeys("ekaterina.makarova.1999@@mail.ru");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        email.clear();
        email.sendKeys("ekaterina.makarova.1999@");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        email.clear();
        email.sendKeys("@mail.ru");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        email.clear();
        email.sendKeys("  ");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Email");
        email.clear();
        email.sendKeys("ekaterina.makarova.1999@mail.ru");
    }

    public void passwordFields_validation(){
        WebElement password = fields.get(4);
        WebElement repeatPassword = fields.get(5);
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Password");
        password.sendKeys("12345");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Password");
        password.sendKeys("6");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Repeat password");
        password.sendKeys("7");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Repeat password");
        password.clear();
        password.sendKeys("123456789qwertyuiokjhgf");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Repeat password");
        password.sendKeys("f");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Repeat password");
        password.sendKeys("fq");
        sign_in_button.click();
        Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Repeat password");
        String[] checking = password.getAttribute("value").split("");
        Assert.assertEquals(checking.length, 24);
        password.clear();
        repeatPassword.sendKeys("123456");
        sign_in_button.click();
        repeatPassword.clear();
        password.sendKeys("1345678");
        repeatPassword.sendKeys("8765431");
        sign_in_button.click();
        //Assert.assertEquals(helpMethods.currentElements().getAttribute("placeholder"), "Password");
    }

    public void validRegistration() throws IOException {
        for (int i = 0; i <fields.size(); i++){
            fields.get(i).clear();
            fields.get(i).sendKeys(fileReaderClass.readFromFile(i+1));
        }
        sign_in_button.click();
    }


}
