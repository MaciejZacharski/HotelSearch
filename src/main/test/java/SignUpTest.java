import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SignUpTest {


    @Test
    public void signUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");

        driver.findElements(By.id("li_myaccount")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);

        String name = "Test1";
        String lastName = "Tester1";

        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("654456654");
        driver.findElement(By.name("email")).sendKeys("test2@gmail.com");
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("confirmpassword")).sendKeys("qwerty");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

      WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

      Assert.assertTrue(heading.getText().contains(lastName));
      Assert.assertTrue(heading.getText().contains(name));


    }
}
