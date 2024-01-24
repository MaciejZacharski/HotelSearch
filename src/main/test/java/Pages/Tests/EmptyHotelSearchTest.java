package Pages.Tests;

import Pages.HotelSearchPage;
import Pages.ResultsPage;
import Pages.Tests.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EmptyHotelSearchTest extends BaseTest {

    @Test
    public void searchEmptyHotel() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);


        hotelSearchPage.setDates("22/02/2024", "29/02/2024");
        hotelSearchPage.SetTravellers(0,1);
        hotelSearchPage.clickOnSearchButton();

        ResultsPage resultsPage = new ResultsPage(driver);
        String noResultMessage = resultsPage.getEmptyResult();

        Assert.assertTrue(resultsPage.noResultsFound.isDisplayed());
        Assert.assertEquals(noResultMessage, "No Results Found");


    }
}
