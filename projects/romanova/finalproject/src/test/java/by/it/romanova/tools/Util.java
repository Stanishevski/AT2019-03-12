package by.it.romanova.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Util {

    protected WebDriver driver;

    protected Util(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElement(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> waitForElements(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementAndClick(By locator) {
        waitForElement(5000, locator).click();
    }

    protected void waitForElementAndClick(long timeout, By locator) {
        waitForElement(timeout, locator).click();
    }

    protected void waitForElementAndSendKeys(By locator, String text) {

        WebElement element = waitForElement(5000, locator);
        element.click();
        element.sendKeys(text);
    }

    protected void waitForElementAndClear(By locator) {

        WebElement element = waitForElement(5000, locator);
        for (int i = 0; i < 10; i++) {
            element.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i < 10; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }

    }

    protected void shortWait(WebDriver driver) throws InterruptedException {
        new Actions(driver).pause(1000).perform();
    }

    protected int getAmountOfElements(By locator)
    {
        List elements = waitForElements(10000, locator);
        return elements.size();
    }

    protected void assertSeveralElements(By locator)
    {
        int amount_of_elements = getAmountOfElements(locator);
        Assert.assertTrue(amount_of_elements>=1);
    }

    public String getCurrentDate(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate date = LocalDate.now().plusDays(1);
        return date.format(format);
    }

    public String getFutureDate(int days){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate date = LocalDate.now().plusDays(days+1);
        return date.format(format);
    }


}
