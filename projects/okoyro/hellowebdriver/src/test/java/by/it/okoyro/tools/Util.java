package by.it.okoyro.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Util {

	public static WebElement find(WebDriver driver, By queryLocator) {
		(new WebDriverWait(driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(queryLocator));
		return driver.findElement(queryLocator);
	}

	public static List<WebElement> findAll(WebDriver driver, By queryLocator) {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(queryLocator));
		return driver.findElements(queryLocator);
	}

	public static ChromeDriver buildChromeDriver() {
		ChromeDriverService service =
				new ChromeDriverService.Builder().withWhitelistedIps("").build();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(System.getProperty("headless") != null);
		return new ChromeDriver(service, chromeOptions);
	}

	public static void shortWait(WebDriver driver) {
		new Actions(driver).pause(1000).perform();
	}
}
