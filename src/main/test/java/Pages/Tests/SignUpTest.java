package Pages.Tests;

import Pages.LoggedUserPage;
import Pages.SignUpMainPage;
import Pages.SignUpPage;
import Pages.Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        String email = "test" + random + "@gmail.com";

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Maciej");
        signUpPage.setLastName("Test");
        signUpPage.setPhoneNumber("12344321");
        signUpPage.setMailInput(email);
        signUpPage.setPassword("qwerty");
        signUpPage.setConfirmPassword("qwerty");
        signUpPage.clickSignUp();


        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);


      Assert.assertTrue(loggedUserPage.getHeadingText().contains("Maciej"));
      Assert.assertTrue(loggedUserPage.getHeadingText().contains("Test"));


    }
    @Test
    public void EmptySignUp() {

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignUp();


        List<String> errorMessages =    signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMessages.size(), 5);
        softAssert.assertEquals(errorMessages.get(0),"The Email field is required.");
        softAssert.assertEquals(errorMessages.get(1), "The Password field is required.");
        softAssert.assertEquals(errorMessages.get(2),"The Password field is required.");
        softAssert.assertEquals(errorMessages.get(3),"The First name field is required.");
        softAssert.assertEquals(errorMessages.get(4),"The Last Name field is required.");


        softAssert.assertAll();

    }
    @Test
    public void wrongEmailFormat() {



        String email = "test";

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Maciej");
        signUpPage.setLastName("Test");
        signUpPage.setPhoneNumber("12344321");
        signUpPage.setMailInput(email);
        signUpPage.setPassword("qwerty");
        signUpPage.setConfirmPassword("qwerty");
        signUpPage.clickSignUp();




       Assert.assertTrue(signUpPage.getErrors().contains("The Email field must contain a valid email address."));

    }




}
