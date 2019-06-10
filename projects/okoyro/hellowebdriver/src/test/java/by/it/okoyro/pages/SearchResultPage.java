package by.it.okoyro.pages;

import by.it.okoyro.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

	private WebDriver driver;
	private By foundedFlight = By.cssSelector("#flightModuleList span.show-flight-details");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public int countSearchResults() {
		int searchResultsQuantity = Util.findAll(driver, foundedFlight).size();
		return searchResultsQuantity;
	}
}
