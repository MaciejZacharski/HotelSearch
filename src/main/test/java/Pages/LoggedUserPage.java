package Pages;

import Util.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoggedUserPage {

    private WebDriver driver;

    @FindBy(xpath = "//h3[@class='RTL']")
    private WebElement userHeading;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getHeadingText() {
        SeleniumHelper.waitForClickable(userHeading,driver);
        return userHeading.getText();
    }


}
