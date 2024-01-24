import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyHotelSearchTest extends BaseTest {

    @Test
    public void searchEmptyHotel() {


        driver.findElement(By.name("checkin")).sendKeys("21/02/2024");
        driver.findElement(By.name("checkout")).sendKeys("25/02/2024");
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();
       WebElement noResult = driver.findElement(By.xpath("//h2[text()='No Results Found']"));

        Assert.assertTrue(noResult.isDisplayed());
        Assert.assertEquals(noResult.getText(), "No Results Found");


    }
}
