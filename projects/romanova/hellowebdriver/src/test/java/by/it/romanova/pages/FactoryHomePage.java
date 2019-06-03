package by.it.romanova.pages;

import by.it.romanova.tools.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryHomePage extends Util {

    public FactoryHomePage(WebDriver driver) throws InterruptedException {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightSearchButton;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement flightOriginField;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement flightDestinationField;

    @FindBy(xpath = "//input[@id=\"flight-departing-hp-flight\"]")
    private WebElement departureDateField;

    @FindBy(xpath = "//input[@id=\"flight-returning-hp-flight\"]")
    private WebElement returningDateField;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div//label/button")
    private WebElement submitButton;

    @FindBy(id = "gcw-packages-form-hp-package")
    private WebElement mainForm;

    @FindBy(id = "header-account-menu")
    private WebElement dropDownAccount;

    @FindBy(id = "header-account-signin-button")
    private WebElement signInOption;

    @FindBy(xpath = "//*[@id='traveler-selector-hp-flight']/div/ul/li/button")
    private WebElement selectNumberOfPeople;

    @FindBy(xpath = "//*[@id='traveler-selector-hp-flight']/div/ul/li/div/div/div/div[1]/div[4]/button")
    private WebElement buttonIncreaseNumberOfAdults;

    public FactoryHomePage clickFlightSearch(){
        flightSearchButton.click();
        return this;
    }

    public FactoryHomePage typeDepartureAirport(String text){
        flightOriginField.click();
        flightOriginField.sendKeys(text);
        return this;
    }

    public FactoryHomePage typeDestinationAirport(String text){
        flightOriginField.click();
        flightDestinationField.sendKeys(text);
        return this;
    }

    public FactoryHomePage selectDepartingDate(){
        String date = getCurrentDate();
        departureDateField.sendKeys(date);
        return this;
    }

    public FactoryHomePage selectDepartingDate(int days){
        String date = getFutureDate(days);
        departureDateField.sendKeys(date);
        return this;
    }

    public FactoryHomePage selectReturningDate(int days) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            returningDateField.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i < 10; i++) {
            returningDateField.sendKeys(Keys.BACK_SPACE);
        }
        String date = getFutureDate(days);
        returningDateField.sendKeys(date);
        return this;
    }

    public FactorySearchResultPage submitForm(){
        submitButton.click();
        FactorySearchResultPage factorySearchResultPage = new FactorySearchResultPage(driver);
        return factorySearchResultPage;
    }

    public FactoryHomePage openAccountDropDown() throws InterruptedException {
        shortWait(driver);
        dropDownAccount.click();
        return this;
    }

    public FactoryHomePage selectTwoAdults() {
        selectNumberOfPeople.click();
        buttonIncreaseNumberOfAdults.click();
        selectNumberOfPeople.click();
        return this;
    }

    public FactoryLoginPage openSignInForm() throws InterruptedException {

        signInOption.click();
        FactoryLoginPage factoryLoginPage = new FactoryLoginPage(driver);
        return factoryLoginPage;
    }


}
