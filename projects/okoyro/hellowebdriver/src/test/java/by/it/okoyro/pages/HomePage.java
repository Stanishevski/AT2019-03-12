package by.it.okoyro.pages;

import by.it.okoyro.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Elements' Locators

	private By flightTab = By.id("tab-flight-tab-hp");
	private By flightInputFrom = By.id("flight-origin-hp-flight");
	private By flightInputTo = By.id("flight-destination-hp-flight");
	private By oneWayButton = By.id("flight-type-one-way-label-hp-flight");
	private By searchButton = By.cssSelector("section#section-flight-tab-hp button[type='submit']");
	private By departureDateInput = By.id("flight-departing-single-hp-flight");
	private By firstOption = By.id("aria-option-0");
	private By closeDatepickerButton = By.className("datepicker-close-btn");

	// App Behaviour

	public HomePage selectSearchFlightMode() {
		Util.find(driver, flightTab).click();
		return this;
	}

	public HomePage selectOneWayFlight() {
		Util.find(driver, oneWayButton).click();
		return this;
	}

	public HomePage setFlightFrom(String destinationFrom) {
		Util.find(driver, flightInputFrom).click();
		Util.shortWait(driver);
		Util.find(driver, flightInputFrom).sendKeys(destinationFrom);
		Util.shortWait(driver);
		WebElement dropDawnValue = Util.find(driver, firstOption);
		dropDawnValue.click();
		return this;
	}

	public HomePage setFlightTo(String destinationTo) {
		Util.find(driver, flightInputTo).click();
		Util.shortWait(driver);
		Util.find(driver, flightInputTo).sendKeys(destinationTo);
		Util.shortWait(driver);
		WebElement dropDownValue = Util.find(driver, firstOption);
		dropDownValue.click();
		return this;
	}

	public HomePage setDepartureDate(String date) {
		Util.find(driver, departureDateInput).click();
		Util.shortWait(driver);
		Util.find(driver, departureDateInput).sendKeys(date);
		Util.find(driver, closeDatepickerButton).click();
		Util.shortWait(driver);// to make sure search button is clickable
		return this;
	}

	public SearchResultPage performSearch() {
		(new WebDriverWait(driver, 15))
				.until(ExpectedConditions.elementToBeClickable(searchButton));
		driver.findElement(searchButton).click();
		SearchResultPage resultPage = new SearchResultPage(driver);
		return resultPage;
	}
}
