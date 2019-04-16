package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InitialPage {

    @FindBy(css="[class='preview-title']") private WebElement page_title;

    WebDriver driver;
    HelpMethods helpMethods;


    public InitialPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        helpMethods = new HelpMethods();
    }

    public void infoPresenceChecking(){
       Assert.assertEquals(page_title.isDisplayed(), true);
       Assert.assertEquals(page_title.getText(), "IRM Studio");

    }
}
