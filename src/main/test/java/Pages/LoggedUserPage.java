package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoggedUserPage {

    @FindBy(xpath = "//h3[@class='RTL']")
    private WebElement userHeading;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getHeadingText() {

      return userHeading.getText();
    }


}
