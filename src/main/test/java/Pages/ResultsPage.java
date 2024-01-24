package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage {


    @FindBy(xpath = "//h4[contains(@class,'list_title')]//b")
    private List<WebElement> hotelNames;

    @FindBy(xpath = "//h2[text()='No Results Found']")
    public WebElement noResultsFound;

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getHotelNames() {
      return   hotelNames.stream()
              .map(el ->el.getAttribute("textContent"))
              .toList();

    }

    public String getEmptyResult() {
       return noResultsFound.getText();
    }
}
