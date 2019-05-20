package by.it.stanishevski.TaskA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloSelenium {
    public static void main(String[] args) throws  InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get ("https://google.com");
        //Thread.sleep(5000 );
        By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
        WebElement queryInput = waitAndGetWebElement(driver, queryLocator); //??? Какими быстрыми клавишами получили метод из текста ниже

//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
//        WebElement queryInput = driver.findElement(queryLocator);

        queryInput.sendKeys("Sponge Bob\n");
        //Thread.sleep(5000);
        waitAndGetWebElement(driver, By.xpath("//span[@class=\"csb ch\"]"));
        driver.quit();
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }


}
