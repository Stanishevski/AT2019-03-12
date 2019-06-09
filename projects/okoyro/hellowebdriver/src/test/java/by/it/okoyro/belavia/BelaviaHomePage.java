package by.it.okoyro.belavia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BelaviaHomePage {
	private WebDriver driver;

	public BelaviaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Elements
	@FindBy(id = "OriginLocation_Combobox")
	private WebElement flightFromInput;

	@FindBy(id = "DestinationLocation_Combobox")
	private WebElement flightToInput;

	@FindBy(id = "JourneySpan_Rt")
	private WebElement returnFlightOption;

	@FindBy(id = "DepartureDate_Datepicker")
	private WebElement departureDateDatepicker;

	@FindBy(id = "ReturnDate_Datepicker")
	private WebElement returnDateDatepicker;

	@FindBy(id = "Passengers")
	private WebElement passengerInput;

	@FindBy(xpath = "//div[@id='Passengers']//div[@class='spin'][1]//a[@class='spin-plus']")
	private WebElement passQuantityIncrease;

	@FindBy(css = "div#step-2 button[type='submit']")
	private WebElement searchButton;


	//Behaviour
	public BelaviaHomePage setFlightFrom(String from) {
		flightFromInput.sendKeys(from);
		shortWait(driver);
		return this;
	}

	public BelaviaHomePage setFlightTo(String to) {
		flightToInput.sendKeys(to);
		shortWait(driver);
		return this;
	}

	public BelaviaHomePage setReturnFlight() {
		if (!returnFlightOption.isSelected()) {
			returnFlightOption.findElement(By.cssSelector("label[for='JourneySpan_Rt']")).click(); // don't know how to click
		}
		returnFlightOption.sendKeys("\n");
		return this;

	}

	public BelaviaHomePage setDeparterDate(String date) {
		driver.findElement(By.xpath("//*[@id='step-2']//input[@id='DepartureDate_Datepicker']/..//i[@class='icon-calendar']")).click();
		List<WebElement> days = driver.findElements(By.cssSelector("#calendar .ui-datepicker-group-last td[data-handler='selectDay']"));
		for (WebElement day : days) {
			if (day.getText().equals(date)) {
				day.click();
				shortWait(driver);
				break;
			}
		}
		return this;
	}

	public BelaviaHomePage setReturnDate(String date) {
		List<WebElement> days = driver.findElements(By.cssSelector("#calendar .ui-datepicker-group-last td[data-handler='selectDay']"));
		for (WebElement day : days) {
			if (day.getText().equals(date)) {
				day.click();
				shortWait(driver);
				break;
			}
		}
		return this;
	}

	public BelaviaHomePage setTwoPersonFlight() {
		passengerInput.click();
		shortWait(driver);
		passQuantityIncrease.click();
		shortWait(driver);
		return this;
	}

	public BelaviaSearchResultPage performSearch() {
		searchButton.click();
		return new BelaviaSearchResultPage(driver);
	}


	public static void shortWait(WebDriver driver) {
		new Actions(driver).pause(1000).perform();
	}
}
