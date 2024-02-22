package Pages;

import Util.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightResultPage {

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement NoResultsError;
    @FindBy(xpath = "//table[@id='load_data']//tr")
    private List<WebElement> resultsList;
    private WebDriver driver;

    public FlightResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getNoResultsErrorText() {
        SeleniumHelper.waitForIsPresentSpecial(By.xpath("//div[@class='alert alert-danger']"), driver);
       return NoResultsError.getText();
    }
    public int getResultsListSize() {
      return   resultsList.size();
    }
}
