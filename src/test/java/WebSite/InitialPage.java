package WebSite;

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
    @FindBy(css = "a[id]") private List<WebElement> socialLinks_icons;
    @FindBy(css = "span section main section div:nth-of-type(1) h1") private WebElement instagramTitle;
    @FindBy(css = "h2[class='page_name']") private WebElement vkTitle;

    WebDriver driver;
    LoginPage loginPage;
    RegisterPage registerPage;
    HelpMethods helpMethods;

    public InitialPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        helpMethods = new HelpMethods(driver);
    }

    public void navigationPresenceChecking() {
        System.out.println("------INITIAL PAGE ------");
        helpMethods.implicitWait(driver);
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
        Assert.assertEquals(socialLinks_icons.size(),3);
        System.out.println("NAVIGATION PRESENCE TEST PASSED");
    }

    public void navigationActivityChecking()  {
        socialLinks_icons.get(0).click();
        socialLinks_icons.get(1).click();
        Assert.assertEquals(instagramTitle.getText(), "irmwork");
        driver.navigate().back();
        socialLinks_icons.get(2).click();
        Assert.assertEquals(vkTitle.getText(), "IRM Studio");
        driver.navigate().back();
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
        System.out.println("NAVIGATION ACTIVITY TEST PASSED");
    }

    public void toRegisterPage(){
        if (navigation_sections.get(0).getText().equals("LOGIN")) {
            navigation_sections.get(1).click();
        }
        else navigation_sections.get(0).click();
        System.out.println("TO REGISTER PAGE TEST PASSED");
    }

    public void toLoginPage(){
        if (navigation_sections.get(1).getText().equals("REGISTER")) {
            navigation_sections.get(0).click();
        }
        else navigation_sections.get(1).click();
        System.out.println("TO LOGIN PAGE TEST PASSED");
    }
}
