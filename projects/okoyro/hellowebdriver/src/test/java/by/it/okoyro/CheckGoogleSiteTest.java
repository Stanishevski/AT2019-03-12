package by.it.okoyro;

import by.it.okoyro.tools.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckGoogleSiteTest {

	@Test
	public void checkGoogleTitle() throws Exception {
		WebDriver driver = Util.buildChromeDriver();
		try {
			driver.get("https://google.com");
			(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.titleIs("Google"));
		}
		finally {
			driver.close();
		}
	}
}
