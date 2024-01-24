import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HotelSearchTest extends BaseTest {


    @Test
    public void searchHotel() {


        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");

        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
        driver.findElement(By.name("checkin")).sendKeys("21/02/2024");
        driver.findElement(By.name("checkout")).sendKeys("25/02/2024");
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();
    List<String> hotelNames =    driver.findElements(By.xpath("//h4[contains(@class,'list_title')]//b")).stream()
                .map(el ->el.getAttribute("textContent"))
                .toList();

        Assert.assertEquals(hotelNames.get(0),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3),"Hyatt Regency Perth");



      /*  driver.findElements(By.xpath("//td[@class='day' and text()='25']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);*/







    }
}
