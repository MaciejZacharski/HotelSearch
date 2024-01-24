import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SignUpTest extends BaseTest {




    @Test
    public void signUp() {

        driver.findElements(By.id("li_myaccount")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);

        String name = "Test1";
        String lastName = "Tester1";
        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "@gmail.com";

        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("654456654");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("confirmpassword")).sendKeys("qwerty");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

      WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

      Assert.assertTrue(heading.getText().contains(lastName));
      Assert.assertTrue(heading.getText().contains(name));


    }
    @Test
    public void EmptySignUp() {

        driver.findElements(By.id("li_myaccount")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        List<String> errorMessages =    driver.findElements(By.xpath("//div[contains(@class, 'alert')]//p")).stream()
                .map(el ->el.getAttribute("textContent"))
                .toList();

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


        driver.findElements(By.id("li_myaccount")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);

        String name = "Test1";
        String lastName = "Tester1";
        int random = (int) (Math.random() * 1000);
        String email = "test" + random + "gmail.com";

        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("654456654");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("confirmpassword")).sendKeys("qwerty");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

       String emailFormatMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert')]//p")).getText();

       Assert.assertEquals(emailFormatMessage, "The Email field must contain a valid email address.");






    }




}
