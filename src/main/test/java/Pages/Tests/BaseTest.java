package Pages.Tests;

import Util.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        driver = DriverFactory.getDriver();

        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
