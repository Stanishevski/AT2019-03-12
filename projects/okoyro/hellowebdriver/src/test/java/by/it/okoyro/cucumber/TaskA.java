package by.it.okoyro.cucumber;

import by.it.okoyro.pages.HomePage;
import by.it.okoyro.pages.SearchResultPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

// simply copy/paste log with scenario (from When to Then) when BddAviaTest is run
@Test (invocationCount = 5)
public class TaskA {

	private WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private int offersCount;

	@Before
	public void initTest() {
		driver = new ChromeDriver();
	}


	@Given("^Airline Home Page is Loaded$")
	public void aviacompanyHomePageIsLoaded() throws Throwable {
		driver.get("https://www.expedia.com.my/");
		homePage = new HomePage(driver);
		assertTrue(homePage != null);
	}

	@When("^User Set Flight Mode$")
	public void userSetFlightMode() throws Throwable {
		homePage.selectSearchFlightMode();
	}

	@When("^User Set One Way Ticket$")
	public void userSetOneWayTicket() throws Throwable {
		homePage.selectOneWayFlight();
	}

	@When("^User Set Flight From Minsk$")
	public void setFlightFromMinsk() throws Throwable {
		homePage.setFlightFrom("minsk");
	}

	@When("^User Set Flight To Moscow$")
	public void setFlightToMoscow() throws Throwable {
		homePage.setFlightTo("moscow");
	}

	@When("^User Set Date (\\d+)/(\\d+)/(\\d+)$")
	public void setDate(int arg1, int arg2, int arg3) throws Throwable {
		homePage.setDepartureDate("20/06/2019");
	}

	@When("^User Clicked Search$")
	public void clickSearch() throws Throwable {
		searchResultPage = homePage.performSearch();
	}

	@When("^User Sow Result List$")
	public void userSowResultList() throws Throwable {
		offersCount = searchResultPage.countSearchResults();
	}

	@Then("^Result List Contains More Then (\\d+)$")
	public void resultListContainsMoreThen(int offers) throws Throwable {
		assertTrue(offersCount > offers);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
