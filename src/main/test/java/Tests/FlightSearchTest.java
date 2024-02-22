package Tests;

import Model.FlightClass;
import Pages.FlightSearchPage;
import Pages.HotelSearchPage;
import Util.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class FlightSearchTest extends BaseTest{

    @Test
    public void searchFlightFirstClass() {
        ExtentTest test = extentReports.createTest("SearchFlightTest");
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










    }

}
