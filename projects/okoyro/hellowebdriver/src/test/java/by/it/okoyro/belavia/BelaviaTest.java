package by.it.okoyro.belavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BelaviaTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test(enabled = false)
	public void taskB() throws Exception {
		driver.get("https://en.belavia.by/");

		BelaviaStartPage startPage = new BelaviaStartPage(driver);

		LoginFormBelavia loginForm = startPage
				.getLoginMenu();
		BelaviaHomePage homePage = loginForm
				.setUserName()
				.setPassword()
				.confirmLogin();
		homePage
				.setFlightFrom("Minsk (MSQ), BY")
				.setFlightTo("Moscow (MOW), RU")
				.setReturnFlight()
				.setDeparterDate("20")
				.setReturnDate("3")
				.setTwoPersonFlight()
				.performSearch();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
