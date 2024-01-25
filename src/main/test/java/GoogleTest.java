import Pages.Tests.BaseTest;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {


    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com/");
        PageObjectGoogleHomePage googleHomePage = new PageObjectGoogleHomePage();


        googleHomePage.searchInGoogle("Selenium");
    }

    @Test
    public void googleSearchTest2() {
        driver.get("https://www.google.com/");
        PageObjectGoogleHomePage googleHomePage = new PageObjectGoogleHomePage();
        googleHomePage.searchInGoogle("Legia");
    }

    @Test
    public void googleSearchTest3() {
        driver.get("https://www.google.com/");
        PageObjectGoogleHomePage googleHomePage = new PageObjectGoogleHomePage();
        googleHomePage.searchInGoogle("Arsenal");
    }
}
