package by.it.udalyou;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helloselenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://googl.com");
        By queryLocator=By.xpath
                ("//input[@class='gLFyf gsfi']");

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
    WebElement queryInput=waitAndGetWebElement(driver,queryLocator);
    queryInput.sendKeys("привет \n");
       waitAndGetWebElement(driver,By.xpath(
               "//span[@class=\"csb ch\"]"));
        driver.quit();
    }
    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }
}
