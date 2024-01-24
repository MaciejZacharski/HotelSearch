package Pages.Tests;

import Pages.LoggedUserPage;
import Pages.SignUpMainPage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SignUpTest extends BaseTest {


    @Test
    public void signUp() {

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();

        int random = (int) (Math.random() * 1000);


        LoggedUserPage loggedUserPage = new SignUpPage(driver)
                .setFirstName("Maciej")
                .setLastName("Test")
                .setPhoneNumber("12344321")
                .setMailInput("test" + random + "@gmail.com")
                .setPassword("qwerty")
                .setConfirmPassword("qwerty")
                .clickSignUp();

        Assert.assertTrue(loggedUserPage.getHeadingText().contains("Maciej"));
        Assert.assertTrue(loggedUserPage.getHeadingText().contains("Test"));


    }

    @Test
    public void EmptySignUp() {

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignUp();


        List<String> errorMessages = signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMessages.size(), 5);
        softAssert.assertEquals(errorMessages.get(0), "The Email field is required.");
        softAssert.assertEquals(errorMessages.get(1), "The Password field is required.");
        softAssert.assertEquals(errorMessages.get(2), "The Password field is required.");
        softAssert.assertEquals(errorMessages.get(3), "The First name field is required.");
        softAssert.assertEquals(errorMessages.get(4), "The Last Name field is required.");


        softAssert.assertAll();

    }

    @Test
    public void wrongEmailFormat() {

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver)
                .setFirstName("Maciej")
                .setLastName("Test")
                .setPhoneNumber("12344321")
                .setMailInput("test")
                .setPassword("qwerty")
                .setConfirmPassword("qwerty");
        signUpPage.clickSignUp();

        Assert.assertTrue(signUpPage.getErrors().contains("The Email field must contain a valid email address."));

    }


}
