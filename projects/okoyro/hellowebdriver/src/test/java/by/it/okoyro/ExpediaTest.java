package by.it.okoyro;

import by.it.okoyro.pages.HomePage;
import by.it.okoyro.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ExpediaTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test(invocationCount = 5)
	public void taskA() throws Exception {
		driver.get("https://www.expedia.com.my/");
		
		HomePage homePage = new HomePage(driver);
		SearchResultPage resultPage = homePage
				.selectSearchFlightMode()
				.selectOneWayFlight()
				.setFlightFrom("minsk")
				.setFlightTo("moscow")
				.setDepartureDate("20/06/2019")
				.performSearch();
		int searchResultsQuantity = resultPage.countSearchResults();
		Assert.assertTrue(searchResultsQuantity > 1);
	}

	@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}
