package by.it.romanova;


import by.it.romanova.pages.FactoryHomePage;
import by.it.romanova.pages.FactorySearchResultPage;
import by.it.romanova.pages.HomePage;
import by.it.romanova.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"at28"})
public class ExpediaTest{

    private WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = new ChromeDriver();
    }

    @Test(groups = {"at28"})
    public void TaskA() throws Exception{
        driver.get("https://www.expedia.com/");
        driver.manage().deleteAllCookies();
        HomePage homePage = new HomePage(driver);
        homePage.assertMainPageLoaded();
        homePage.clickFlightSearch();
        homePage.typeDepartureAirport("Minsk, Belarus (MSQ-All Airports)");
        homePage.typeDestinationAirport("Moscow, Russia (MOW-All Airports)");
        homePage.selectDepartingDate();
        homePage.selectReturningDate(30);
        Thread.sleep(3000);
        homePage.submitForm();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkMoreThanOneResult();
        Thread.sleep(10000);
    }

    @Test(groups = {"at28"})
    public void TaskB() throws Exception{
        driver.get("https://www.expedia.com/");
        FactoryHomePage factoryHomePage = new FactoryHomePage(driver);
        FactorySearchResultPage factorySearchResultPage = factoryHomePage
                .clickFlightSearch()
                .typeDepartureAirport("Minsk, Belarus (MSQ-All Airports)")
                .typeDestinationAirport("Moscow, Russia (MOW-All Airports)")
                .selectDepartingDate(30)
                .selectReturningDate(45)
                .selectTwoAdults()
                .submitForm()
                .checkMoreThanOneResult()
                .assertPricesHigher(100);
    }


    @AfterMethod
    public void tearDownDriver(){
        driver.quit();
    }
}
