package Pages.Tests;

import Pages.HotelSearchPage;
import Pages.ResultsPage;
import Util.ExcelReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HotelSearchTest extends BaseTest {


    @Test
    public void searchHotel() throws IOException {
        ExtentTest test = extentReports.createTest("SearchHotelTest");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);

        hotelSearchPage.setCityName("Dubai");
        test.log(Status.PASS, "Setting City done");
        hotelSearchPage.setDates("22/02/2024", "29/02/2024");
        test.log(Status.PASS, "Setting Dates done");
        hotelSearchPage.SetTravellers(1, 2);
        test.log(Status.PASS, "Setting Travellers done");
        hotelSearchPage.clickOnSearchButton();
        test.log(Status.PASS, "Performing search done");
        test.log(Status.PASS, "Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath("src\\main\\test\\resources\\screenshots\\screenshot.png").build());
        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();


        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
        test.log(Status.PASS, "Assertion passed");
    }


      /*  driver.findElements(By.xpath("//td[@class='day' and text()='25']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);*/

    @Test
    public void searchEmptyHotel() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);


        hotelSearchPage.setDates("22/02/2024", "29/02/2024");
        hotelSearchPage.SetTravellers(0, 1);
        hotelSearchPage.clickOnSearchButton();

        ResultsPage resultsPage = new ResultsPage(driver);
        String noResultMessage = resultsPage.getEmptyResult();

        Assert.assertTrue(resultsPage.noResultsFound.isDisplayed());
        Assert.assertEquals(noResultMessage, "No Results Found");


    }

    @Test(dataProvider = "data")
    public void searchHotelTestDataProvider(String city, String hotelName) {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);

        hotelSearchPage.setCityName(city);
        hotelSearchPage.setDates("22/02/2024", "29/02/2024");
        hotelSearchPage.SetTravellers(1, 2);
        hotelSearchPage.clickOnSearchButton();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();


        Assert.assertEquals(hotelNames.get(0), hotelName);

    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testdata.xlsx");
    }


}
