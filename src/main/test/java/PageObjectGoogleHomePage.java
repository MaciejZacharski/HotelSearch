import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectGoogleHomePage {

    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(name = "btnK")
    private WebElement searchButton;


    public void searchInGoogle(String phrase) {


        searchInput.sendKeys("phrase");
        searchInput.click();
    }

}
