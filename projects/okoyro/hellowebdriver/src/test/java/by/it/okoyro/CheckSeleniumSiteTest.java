package by.it.okoyro;

import by.it.okoyro.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSeleniumSiteTest {
	@Test
	public void checkSeleniumhq() throws Exception {
		WebDriver driver = Util.buildChromeDriver();  // use @Before annotation
		try {
			driver.get("https://google.com");
			WebElement searchInput = (new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.gLFyf.gsfi")));
			searchInput.sendKeys("seleniumhq");
			searchInput.submit();
			(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='csb ch']")));
			driver.findElements(By.className("LC20lb")).get(0).click();
			(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.titleIs("Selenium - Web Browser Automation"));

			driver.findElement(By.cssSelector("li#menu_download>a")).click();
			(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(By.className("sectionDownload")));
			driver.findElements(By.xpath("//*[@id='nav']//a[text()='Maven Information']")).get(0).click();
			(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.textMatches(By.cssSelector("#mainContent h2"),
														  Pattern.compile("Maven Information")));
			String dependencyText = driver.findElements(By.tagName("pre")).get(0).getText();
			Assert.assertTrue(dependencyText.contains("<artifactId>selenium-java</artifactId>"));
			// dependency version
			Pattern versionPattern = Pattern.compile("<version>(.*)<\\/version>");
			Matcher matcher = versionPattern.matcher("<dependency>         <groupId>org.seleniumhq.selenium</groupId>         <artifactId>selenium-java</artifactId>         <version>3.141.59</version>     </dependency>");
			if (matcher.find()) {
				String version = matcher.group(1);
				System.out.println(version);
			}
		}
		finally {    // use @After annotation
			driver.close();
		}
	}
}

