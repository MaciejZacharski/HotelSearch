package Pages.Tests;

import Model.User;
import Pages.LoggedUserPage;
import Pages.SignUpMainPage;
import Pages.SignUpPage;
import Pages.Tests.BaseTest;
import Util.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class SignUpTest extends BaseTest {


    @Test
    public void signUp() throws IOException {
        ExtentTest test = extentReports.createTest("SignUpTest");

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();
        test.log(Status.PASS, "Sign up form Page Open", SeleniumHelper.getScreenshot(driver));

        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Maciej");
        signUpPage.setLastName("Test");
        signUpPage.setPhoneNumber("12344321");
        signUpPage.setMailInput(email);
        signUpPage.setPassword("qwerty");
        signUpPage.setConfirmPassword("qwerty");
        test.log(Status.PASS, "Sign up form filled", SeleniumHelper.getScreenshot(driver));
        signUpPage.clickSignUp();
        test.log(Status.PASS, "Sign up form done and sent", SeleniumHelper.getScreenshot(driver));

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);


        Assert.assertTrue(loggedUserPage.getHeadingText().contains("Maciej"));
        Assert.assertTrue(loggedUserPage.getHeadingText().contains("Test"));
        test.log(Status.PASS, "Assertion passed", SeleniumHelper.getScreenshot(driver));

    }

    @Test
    public void EmptySignUp() throws IOException {
        ExtentTest test = extentReports.createTest("EmptySignUpTest");

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();
        test.log(Status.PASS, "Sign up form Page Open", SeleniumHelper.getScreenshot(driver));

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignUp();
        test.log(Status.PASS, "Empty Sign up form clicked", SeleniumHelper.getScreenshot(driver));

        List<String> errorMessages = signUpPage.getErrors();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMessages.size(), 5);
        softAssert.assertEquals(errorMessages.get(0), "The Email field is required.");
        softAssert.assertEquals(errorMessages.get(1), "The Password field is required.");
        softAssert.assertEquals(errorMessages.get(2), "The Password field is required.");
        softAssert.assertEquals(errorMessages.get(3), "The First name field is required.");
        softAssert.assertEquals(errorMessages.get(4), "The Last Name field is required.");


        softAssert.assertAll();
        test.log(Status.PASS, "Assertion passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void wrongEmailFormat() throws IOException {
        ExtentTest test = extentReports.createTest("WrongEmailFormatTest");

        String email = "test";

        SignUpMainPage signUp = new SignUpMainPage(driver);
        signUp.openSignUpForm();
        test.log(Status.PASS, "Sign up form Page Open", SeleniumHelper.getScreenshot(driver));

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Maciej");
        signUpPage.setLastName("Test");
        signUpPage.setPhoneNumber("12344321");
        signUpPage.setMailInput(email);
        signUpPage.setPassword("qwerty");
        signUpPage.setConfirmPassword("qwerty");
        test.log(Status.PASS, "Sign up form filled", SeleniumHelper.getScreenshot(driver));
        signUpPage.clickSignUp();
        test.log(Status.PASS, "Sign up form clicked but not sent", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(signUpPage.getErrors().contains("The Email field must contain a valid email address."));
        test.log(Status.PASS, "Assertion passed", SeleniumHelper.getScreenshot(driver));
    }


}
