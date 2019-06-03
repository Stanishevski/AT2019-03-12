package by.it.agrinkevich;

import by.it.agrinkevich.pages.CalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void calcScalarAddScalarTest() throws Exception{
        driver.get("http://localhost:8088/");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String actualValue = calculatorPage
                .setExpression("2+2")
                .submit()
                .getResult();
        String expectedValue = "4.0";
        Assert.assertEquals("Addition works incorrectly", expectedValue, actualValue);
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
}
