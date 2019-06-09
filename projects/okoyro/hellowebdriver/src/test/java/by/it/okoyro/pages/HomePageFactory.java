package by.it.okoyro.pages;

import by.it.okoyro.tools.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	private WebDriver driver;

	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Elements
	@FindBy(id = "tab-flight-tab-hp")
	private WebElement flightTab;

	@FindBy(id = "flight-origin-hp-flight")
	private WebElement flightInputFrom;

	@FindBy(id = "flight-destination-hp-flight")
	private WebElement flightInputTo;

	@FindBy(id = "aria-option-0")
	private WebElement firstOption;

	@FindBy(id = "flight-departing-hp-flight")
	private WebElement departureDateInput;

	@FindBy(className = "datepicker-close-btn")
	private WebElement closeDatepickerButton;

	@FindBy(id = "flight-returning-hp-flight")
	private WebElement returnDateInput;

	@FindBy(css = "section#section-flight-tab-hp button[type='submit']")
	private WebElement searchButton;


	//Behaviour
	public HomePageFactory selectSearchFlightMode() {
		flightTab.click();
		return this;
	}

	public HomePageFactory setFlightFrom(String destinationFrom) {
		flightInputFrom.click();
		Util.shortWait(driver);
		flightInputFrom.sendKeys(destinationFrom);
		Util.shortWait(driver);
		firstOption.click();
		return this;
	}

	public HomePageFactory setFlightTo(String destinationTo) {
		flightInputTo.click();
		Util.shortWait(driver);
		flightInputTo.sendKeys(destinationTo);
		Util.shortWait(driver);
		firstOption.click();
		return this;
	}

	public HomePageFactory setDepartureDate(String date) {
		departureDateInput.click();
		Util.shortWait(driver);
		departureDateInput.sendKeys(date);
		closeDatepickerButton.click();
		Util.shortWait(driver); // to make sure search button is clickable
		return this;
	}

	public HomePageFactory setReturnDate(String date) {
		returnDateInput.click();
		returnDateInput.clear(); // it doesn't clear
		returnDateInput.sendKeys(Keys.BACK_SPACE); // delete 1 symbol
		Util.shortWait(driver);
		returnDateInput.sendKeys(date);
		closeDatepickerButton.click();
		Util.shortWait(driver);
		return this;
	}


	public SearchResultPageFactory performSearch() {
		searchButton.click(); // not sure will work
//		(new WebDriverWait(driver, 15))
//				.until(ExpectedConditions.elementToBeClickable(searchButton));
//		driver.findElement(searchButton).click();
		SearchResultPageFactory resultPageFactory = new SearchResultPageFactory(driver);
		return resultPageFactory;
	}
}
