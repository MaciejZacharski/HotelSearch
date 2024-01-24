package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage {


    private WebDriver driver;
    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(name = "lastname")
    private WebElement lastNameInput;
    @FindBy(name = "phone")
    private WebElement phoneNumberInput;
    @FindBy(name = "email")
    private WebElement eMailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[text()=' Sign Up']")
    private WebElement signUpBtn;

    @FindBy(xpath = "//div[contains(@class, 'alert')]//p")
    private List<WebElement> errors;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public SignUpPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;

    }

    public SignUpPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public SignUpPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public SignUpPage setMailInput(String eMail) {
        eMailInput.sendKeys(eMail);
        return this;

    }

    public SignUpPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;

    }

    public SignUpPage setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;

    }

    public LoggedUserPage clickSignUp() {
        signUpBtn.click();
        return new LoggedUserPage(driver);

    }

    public List<String> getErrors() {

        return errors.stream()
                .map(WebElement::getText)
                .toList();
    }

    public void fillSignUpForm(String firstName, String lastName, String phone, String email, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneNumberInput.sendKeys(phone);
        eMailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        clickSignUp();
    }






 /*   String name = "Test1";
    String lastName = "Tester1";
    int random = (int) (Math.random() * 1000);
    String email = "test" + random + "@gmail.com";*/


//    WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));


}
