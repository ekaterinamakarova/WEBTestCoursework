package Pages;

import org.openqa.selenium.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HelpMethods {

    WebDriver driver;

    public HelpMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(7,SECONDS);
    }

    public WebElement currentElements(){
        WebElement activeElement = driver.switchTo().activeElement();
        return activeElement;
    }
}
