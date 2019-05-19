package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitialPage {

    @FindBy(css = "div[id='navbarSupportedContent']") private WebElement navigation_bar;
    @FindBy(xpath = "//ul[@class='navbar-nav mr-right']//li") private List<WebElement> navigation_sections;

    WebDriver driver;
    LoginPage loginPage;
    RegisterPage registerPage;


    public InitialPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    public void navigationPresenceChecking() {
        Assert.assertEquals(navigation_bar.isDisplayed(), true); // case #6
        ArrayList<String> obtainedList = new ArrayList<>();
        for (WebElement we : navigation_sections) {
            obtainedList.add(we.getText());
        }
        Collections.sort(obtainedList);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("LOGIN");
        expectedList.add("REGISTER");
        Assert.assertTrue(obtainedList.equals(expectedList)); //case #7
    }

    public void navigationActivityChecking()  {
        if (navigation_sections.get(0).getText().equals("LOGIN")) {
            navigation_sections.get(0).click();
            Assert.assertEquals(loginPage.returnHeader(), "Welcome back!");
            navigation_sections.get(1).click();
            Assert.assertEquals(registerPage.returnHeader(), "Registration");
        }
        else{
            navigation_sections.get(0).click();
            Assert.assertEquals(registerPage.returnHeader(), "Registration");
            navigation_sections.get(1).click();
            Assert.assertEquals(loginPage.returnHeader(), "Welcome back!");
        }
    }

    public void toRegisterPage(){
        if (navigation_sections.get(0).getText().equals("LOGIN")) {
            navigation_sections.get(0).click();
        }
        else navigation_sections.get(1).click();
    }

    public void toLoginPage(){
        if (navigation_sections.get(0).getText().equals("REGISTER")) {
            navigation_sections.get(0).click();
        }
        else navigation_sections.get(1).click();
    }
}
