package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HotelSearchPage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;
    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchHotelInput;

    @FindBy(name = "checkin")
    private WebElement checkInInput;
    @FindBy(name = "checkout")
    private WebElement checkoutInput;
    @FindBy(id = "travellersInput")
    private WebElement travellersInput;
    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;
    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    private WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HotelSearchPage setCityName(String cityName) {
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xPath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xPath)).click();
        return this;


    }

    public HotelSearchPage setDates(String checkin, String checkout) {
        checkInInput.sendKeys(checkin);
        checkoutInput.sendKeys(checkout);
        return this;
    }

    public HotelSearchPage SetTravellers(int adultsToAdd, int childToAdd) {

        travellersInput.click();
        addTraveler(adultPlusBtn, adultsToAdd);
        addTraveler(childPlusBtn, childToAdd);
        return this;
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravelers) {
        for (int i = 0; i < numberOfTravelers; i++) {
            travelerBtn.click();
        }
    }


    public ResultsPage clickOnSearchButton() {
        searchButton.click();
        return new ResultsPage(driver);
    }


}
