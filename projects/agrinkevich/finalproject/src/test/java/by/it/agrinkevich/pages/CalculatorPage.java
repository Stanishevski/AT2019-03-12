package by.it.agrinkevich.pages;

import by.it.agrinkevich.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    private WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    private By byInputExpression = By.id("expression");
    private By byOutputResult = By.id("results");
    private By byButtonSubmit = By.id("Submit");

    public CalculatorPage setExpression(String expr){
        WebElement inputExpression = Util.find(driver, byInputExpression);
        inputExpression.click();
        Util.shortWait(driver);
        inputExpression.sendKeys(expr);
        return this;
    }

    public CalculatorPage submit(){
        WebElement buttonSubmit = Util.find(driver, byButtonSubmit);
        buttonSubmit.click();
        return this;
    }

    public String getResult(){
        WebElement outputResult = Util.find(driver, byOutputResult);
        String result = outputResult.getText();
        return result;
    }
}
