package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(css = "div[class='card-header'] h4") public WebElement header;


    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String returnHeader(){
        return header.getText();
    }


}
