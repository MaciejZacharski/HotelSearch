package Pages;

import Model.FlightClass;
import Util.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;

public class FlightSearchPage {

    @FindBy(xpath = "//span[contains(text(),'Flights')]")
    private WebElement flightTab;
    @FindBy(id = "s2id_autogen12")
    private WebElement flightLocationFrom;
    @FindBy(id = "s2id_autogen13")
    private WebElement flightLocationTo;
    @FindBy(id = "round")
    private WebElement roundTripButton;
    @FindBy(css = "[value='oneway']")
    private WebElement oneWayTripButton;
    @FindBy(name = "cabinclass")
    private WebElement flightClassSelect;
    @FindBy(name = "departure")
    private WebElement departureDate;
    @FindBy(name = "arrival")
    private WebElement returnDate;
    @FindBy(name = "totalManualPassenger")
    private WebElement numberOfPassengers;
    @FindBy(name = "madult")
    private WebElement numberOfAdults;
    @FindBy(name = "mchildren")
    private WebElement numberOfChildren;
    @FindBy(name = "minfant")
    private WebElement numberOfInfants;
    @FindBy(id = "sumManualPassenger")
    private WebElement confirmButton;
    @FindBy(xpath = "//button[@class='btn-primary btn btn-lg btn-block pfb0']")
    private WebElement searchButton;
    @FindBy(xpath = "//ul[@class='select2-results']//li[1]")
    private WebElement firstAirportFound;

    private WebDriver driver;

    public FlightSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FlightSearchPage getToFlightTab() {
        SeleniumHelper.waitForClickable(flightTab, driver);
        flightTab.click();
        return new FlightSearchPage(driver);
    }

    public FlightSearchPage setDepartureAirportName(String cityName) {

        flightLocationFrom.sendKeys(cityName);
        By airportLocator = By.xpath("//div[@class='select2-result-label']");
        SeleniumHelper.waitForIsPresent(airportLocator, driver);

        driver.findElement(airportLocator).click();
        return new FlightSearchPage(driver);
    }
    public FlightSearchPage setArrivalAirportName(String cityName) {

        flightLocationTo.sendKeys(cityName);
        By airportLocator = By.xpath("//div[@class='select2-result-label']");
        SeleniumHelper.waitForIsPresent(airportLocator, driver);
        driver.findElement(airportLocator).click();
        return new FlightSearchPage(driver);
    }
    public FlightSearchPage clickOnRoundTripButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(roundTripButton).click().perform();

        return new FlightSearchPage(driver);
    }
    public FlightSearchPage clickOnOneWayTripButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(oneWayTripButton).click().perform();

        return new FlightSearchPage(driver);
    }

    public FlightSearchPage selectFlightClass(FlightClass flightClass) {
        Actions actions = new Actions(driver);
        actions.moveToElement(flightClassSelect).perform();
      Select flightClassChoice = new Select(flightClassSelect);
      flightClassChoice.selectByValue(flightClass.getName());
        return new FlightSearchPage(driver);
    }

    public FlightSearchPage setDepartureDate(String dateOfDeparture) {

        departureDate.sendKeys(dateOfDeparture);

        return new FlightSearchPage(driver);
    }
    public FlightSearchPage setReturnDate(String dateOfReturn) {
        SeleniumHelper.waitForClickable(returnDate, driver);
        returnDate.sendKeys(dateOfReturn);

        return new FlightSearchPage(driver);
    }
    public FlightSearchPage setNumberOfPassengers(int numberOfAdultPassengers , int numberOfChildrenPassengers, int numberOfInfantsPassengers) {

        numberOfPassengers.click();
        setNumberOfAdultPassengers(numberOfAdultPassengers);
        setNumberOfChildrenPassengers(numberOfChildrenPassengers);
        setNumberOfInfantsPassengers(numberOfInfantsPassengers);
        confirmButton.click();


        return new FlightSearchPage(driver);
    }

    public FlightSearchPage GotoPassengerSelect() {
        numberOfPassengers.click();

        return new FlightSearchPage(driver);
    }
    
    public FlightSearchPage setNumberOfAdultPassengers(int numberOfAdultPassengers) {
        Select selectAdults = new Select(numberOfAdults);
   selectAdults.selectByValue(String.valueOf(numberOfAdultPassengers));


        return new FlightSearchPage(driver);
    }
    public FlightSearchPage setNumberOfChildrenPassengers(int numberOfChildrenPassengers) {
        Select selectChildren = new Select(numberOfChildren);
        selectChildren.selectByValue(String.valueOf(numberOfChildrenPassengers));

        return new FlightSearchPage(driver);
    }
    public FlightSearchPage setNumberOfInfantsPassengers(int numberOfInfantsPassengers) {
        Select selectInfants = new Select(numberOfInfants);
        selectInfants.selectByValue(String.valueOf(numberOfInfantsPassengers));

        return new FlightSearchPage(driver);
    }





}


