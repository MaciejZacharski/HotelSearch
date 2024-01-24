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

        List<String> hotelNames = hotelSearchPage.setCityName("Dubai")
                .setDates("22/02/2024", "29/02/2024")
                .SetTravellers(1, 2)
                .clickOnSearchButton().getHotelNames();

        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");

    }

    @Test
    public void searchEmptyHotel() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);

        ResultsPage resultsPage = hotelSearchPage.setDates("22/02/2024", "29/02/2024")
                .SetTravellers(0, 1)
                .clickOnSearchButton();

        Assert.assertTrue(resultsPage.noResultsFound.isDisplayed());
        Assert.assertEquals(resultsPage.getEmptyResult(), "No Results Found");


    }
}
