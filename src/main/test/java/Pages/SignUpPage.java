package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage {



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
    private  WebElement signUpBtn;

    @FindBy(xpath = "//div[contains(@class, 'alert')]//p")
    private List<WebElement> errors;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);

    }
    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);

    }
    public void setPhoneNumber( String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);

    }
        public void setMailInput( String eMail) {
        eMailInput.sendKeys(eMail);

    }
    public void setPassword(String password) {
        passwordInput.sendKeys(password);

    }
    public void setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);

    }
    public void clickSignUp() {
       signUpBtn.click();

    }
    public List<String> getErrors() {

        return  errors.stream()
                .map(WebElement::getText)
                .toList();
    }




 /*   String name = "Test1";
    String lastName = "Tester1";
    int random = (int) (Math.random() * 1000);
    String email = "test" + random + "@gmail.com";*/




//    WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));


}
