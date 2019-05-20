package by.it.stanishevski;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckGoogleSiteTest {

    @Test
    public void userTryFindHelloInGoogle () throws Exception {
        WebDriver driver = new ChromeDriver();
        try { driver.get ("https://google.com");
            By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, queryLocator); //??? Какими быстрыми клавишами получили метод из текста ниже
            queryInput.sendKeys("Прювет\n");
            //Thread.sleep(5000);
            waitAndGetWebElement(driver, By.xpath("//title[contains(text(),'Google')]"));

                    }
        finally {
            driver.quit();
        }
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }
}
