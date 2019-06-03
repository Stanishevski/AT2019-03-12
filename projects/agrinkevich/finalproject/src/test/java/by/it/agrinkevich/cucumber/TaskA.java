package by.it.agrinkevich.cucumber;

import by.it.agrinkevich.pages.ResultPage;
import by.it.agrinkevich.pages.StartPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class TaskA {

    private WebDriver driver;
    private StartPage startPage;
    private ResultPage resultPage;
    private int countTickets;

    @Before
    public void initTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^Home Page Airline Is Loaded From \"([^\"]*)\"$")
    public void homePageAirlineIsLoadedFrom(String url) throws Throwable {
        driver.get(url);
        startPage = new StartPage(driver);
        assertNotNull(startPage);
    }

    @When("^User Set Flight Mode$")
    public void userSetFlightMode() throws Throwable {
        startPage.selectSearchFlightMode();
        assertNotNull(startPage);
    }

    @When("^User Set One Way Ticket$")
    public void userSetOneWayTicket() throws Throwable {
        startPage.selectOneWay();
        assertNotNull(startPage);
    }

    @When("^Set Origin \"([^\"]*)\"$")
    public void setOrigin(String city) throws Throwable {
        startPage.setOrigin(city);
        assertNotNull(startPage);
    }

    @When("^Set Destination \"([^\"]*)\"$")
    public void setDestination(String city) throws Throwable {
        startPage.setDestination(city);
        assertNotNull(startPage);
    }

    @When("^Set Date Current Plus (\\d+) Days$")
    public void setDateCurrentDays(int num) throws Throwable {
        startPage.setDepartingDate(num);
        assertNotNull(startPage);
    }

    @When("^Click Search$")
    public void clickSearch() throws Throwable {
        resultPage = startPage.getSearch();
        assertNotNull(startPage);
    }

    @When("^User see List With Result$")
    public void userSeeListWithResult() throws Throwable {
        countTickets = resultPage.getResultSearchCount();
        assertTrue(countTickets >= 0);
    }

    @Then("^Count If Result More (\\d+)$")
    public void countIfResultMore(int count) throws Throwable {
        assertTrue(countTickets > count);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
