package by.it.romanova.pages;

import by.it.romanova.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePage extends Util {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By
            FLIGHT_SEARCH_BUTTON = By.id("tab-flight-tab-hp"),
            FLIGHT_ORIGIN_FIELD = By.id("flight-origin-hp-flight"),
            FLIGHT_DESTINATION_FIELD = By.id("flight-destination-hp-flight"),
            DEPARTURE_DATE_FIELD = By.xpath("//input[@id=\"flight-departing-hp-flight\"]"),
            DEPARTURE_DATE = By.xpath("//*[@id=\"flight-departing-wrapper-hp-flight\"]/div//button[@data-day=1]"),
            RETURNING_DATE_FIELD = By.xpath("//input[@id=\"flight-returning-hp-flight\"]"),
            RETURNING_DATE = By.xpath("//*[@id=\"flight-returning-wrapper-hp-flight\"]/div//button[@data-day=30]"),
            SUBMIT_BUTTON = By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div//label/button"),
            MAIN_FORM = By.id("gcw-packages-form-hp-package");


    public void clickFlightSearch(){
        waitForElementAndClick(FLIGHT_SEARCH_BUTTON);
    }

    public void typeDepartureAirport(String text){
        waitForElementAndSendKeys(FLIGHT_ORIGIN_FIELD,text);
    }

    public void typeDestinationAirport(String text){
        waitForElementAndSendKeys(FLIGHT_DESTINATION_FIELD, text);
    }

    public void selectDepartingDate(){
        String date = getCurrentDate();
        waitForElementAndSendKeys(DEPARTURE_DATE_FIELD,date);
    }

    public void selectDepartingDate(int days){
        String date = getFutureDate(days);
        waitForElementAndSendKeys(DEPARTURE_DATE_FIELD,date);
    }

    public void selectReturningDate(int days) throws InterruptedException {
        waitForElementAndClick(RETURNING_DATE_FIELD);
        shortWait(driver);
        waitForElementAndClear(RETURNING_DATE_FIELD);
        String date = getFutureDate(days);
        waitForElementAndSendKeys(RETURNING_DATE_FIELD, date);
    }

    public void submitForm(){
        waitForElementAndClick(SUBMIT_BUTTON);
    }

    public void assertMainPageLoaded(){
        waitForElement(10000,MAIN_FORM);
    }


}
