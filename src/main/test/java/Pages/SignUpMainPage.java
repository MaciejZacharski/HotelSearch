package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpMainPage {

    @FindBy(id = "li_myaccount")
    private List<WebElement> myAccountBtn;

    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> signUpBtn;

    public SignUpMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void openSignUpForm() {
        myAccountBtn.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        signUpBtn.get(1).click();
    }
}
