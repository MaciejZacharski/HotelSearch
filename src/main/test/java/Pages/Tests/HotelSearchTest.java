package Pages.Tests;

import Pages.HotelSearchPage;
import Pages.ResultsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HotelSearchTest extends BaseTest {


    @Test
    public void searchHotel() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);

        hotelSearchPage.setCityName("Dubai");
        hotelSearchPage.setDates("22/02/2024", "29/02/2024");
        hotelSearchPage.SetTravellers(1,2);
        hotelSearchPage.clickOnSearchButton();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();



        Assert.assertEquals(hotelNames.get(0),"Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2),"Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3),"Hyatt Regency Perth");



      /*  driver.findElements(By.xpath("//td[@class='day' and text()='25']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);*/







    }
}
