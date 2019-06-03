package by.it.romanova.cucumber;

import by.it.romanova.pages.HomePage;
import by.it.romanova.pages.SearchResultPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskA {

    private WebDriver driver;

    private HomePage homePage;

    @Before
    public void setUpDriver(){
        driver = new ChromeDriver();
    }

    @Given("^Home Page Is Loaded$")
    public void home_Page_Is_Loaded() {
        driver.get("https://www.expedia.com/");
        homePage = new HomePage(driver);
        homePage.assertMainPageLoaded();
    }

    @When("^User clicks Flight Search$")
    public void user_clicks_Flight_Search() {
        homePage.clickFlightSearch();
    }

    @When("^User Types Departure \"([^\"]*)\" Airport$")
    public void user_Types_Departure_Airport(String arg1) {
        homePage.typeDepartureAirport(arg1);
    }

    @When("^User Type Destination \"([^\"]*)\" Airport$")
    public void user_Type_Destination_Airport(String arg1) {
        homePage.typeDestinationAirport(arg1);
    }

    @When("^Select Departing Date$")
    public void select_Departing_Date() throws Throwable {
        homePage.selectDepartingDate();
    }

    @When("^Select Returning \"([^\"]*)\" Date$")
    public void select_Returning_Date(String arg1) throws Throwable {
        homePage.selectReturningDate(Integer.parseInt(arg1));
    }

    @When("^SubmitForm$")
    public void submitform() throws Throwable {
        homePage.submitForm();
    }

    @Then("^More Than One result is Given$")
    public void more_Than_One_result_is_Given() throws Throwable {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkMoreThanOneResult();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
