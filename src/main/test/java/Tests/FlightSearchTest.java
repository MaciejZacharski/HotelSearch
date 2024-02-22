package Tests;

import Model.FlightClass;
import Pages.FlightResultPage;
import Pages.FlightSearchPage;
import Pages.HotelSearchPage;
import Util.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightSearchTest extends BaseTest{

    @Test
    public void searchFlightFirstClass() {
        ExtentTest test = extentReports.createTest("Search Flight First Class Test");
        FlightSearchPage flightSearch = new FlightSearchPage(driver);
        flightSearch.getToFlightTab();

        flightSearch.clickOnRoundTripButton();
        flightSearch.selectFlightClass(FlightClass.FIRST);
        flightSearch.setDepartureAirportName("Warsaw");
        flightSearch.setArrivalAirportName("Dublin");
        flightSearch.setDepartureDate("2024-04-10");
        flightSearch.setReturnDate("2024-04-17");
        flightSearch.GotoPassengerSelect();
        flightSearch.setNumberOfAdultPassengers(2);
        flightSearch.setNumberOfChildrenPassengers(1);
        flightSearch.ConfirmNumberOfPassengers();
      FlightResultPage flightResultPage = flightSearch.clickOnSearchButton();

        Assert.assertEquals(flightResultPage.getNoResultsErrorText(), "No Results Found");

    }
    @Test
    public void searchFlightEconomyClass() {
        ExtentTest test = extentReports.createTest("Search Flight Economy Class");
        FlightSearchPage flightSearch = new FlightSearchPage(driver);
        flightSearch.getToFlightTab();

        flightSearch.clickOnRoundTripButton();
        flightSearch.selectFlightClass(FlightClass.ECONOMY);
        flightSearch.setDepartureAirportName("Miami");
        flightSearch.setArrivalAirportName("Dubai");
        flightSearch.setDepartureDate("2024-03-10");
        flightSearch.setReturnDate("2024-03-21");
        flightSearch.GotoPassengerSelect();
        flightSearch.setNumberOfAdultPassengers(2);
        flightSearch.ConfirmNumberOfPassengers();
        FlightResultPage flightResultPage = flightSearch.clickOnSearchButton();

        Assert.assertTrue(flightResultPage.getResultsListSize() > 0);

    }

    @Test
    public void searchFlightBusinessClass() {
        ExtentTest test = extentReports.createTest("Search Flight Business Class Test");
        FlightSearchPage flightSearch = new FlightSearchPage(driver);
        flightSearch.getToFlightTab();

        flightSearch.clickOnRoundTripButton();
        flightSearch.selectFlightClass(FlightClass.BUSINESS);
        flightSearch.setDepartureAirportName("London");
        flightSearch.setArrivalAirportName("Hurghada");
        flightSearch.setDepartureDate("2024-03-14");
        flightSearch.setReturnDate("2024-03-21");
        flightSearch.GotoPassengerSelect();
        flightSearch.setNumberOfAdultPassengers(2);
        flightSearch.setNumberOfInfantsPassengers(1);
        flightSearch.ConfirmNumberOfPassengers();
        FlightResultPage flightResultPage = flightSearch.clickOnSearchButton();

        Assert.assertTrue(flightResultPage.getResultsListSize() > 0);

    }

}
