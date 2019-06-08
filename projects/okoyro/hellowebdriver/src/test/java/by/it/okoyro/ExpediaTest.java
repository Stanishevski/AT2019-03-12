package by.it.okoyro;

import by.it.okoyro.pages.HomePage;
import by.it.okoyro.pages.HomePageFactory;
import by.it.okoyro.pages.SearchResultPage;
import by.it.okoyro.pages.SearchResultPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ExpediaTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		//		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true);
		driver = new ChromeDriver(chromeOptions);
	}

	@Test
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

	@Test
	public void taskB() {
		driver.get("https://www.expedia.com.my/");

		HomePageFactory homePageFactory = new HomePageFactory(driver);
		SearchResultPageFactory resultPageFactory = homePageFactory
				.selectSearchFlightMode()
				.setFlightFrom("minsk")
				.setFlightTo("moscow")
				.setDepartureDate("20/06/2019")
				.setReturnDate("05/07/2019")
				.performSearch();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
