package by.it.stanishevski;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    public static void main(String[] args) throws  InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get ("https://google.com");
        Thread.sleep(5000 );
        By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
        WebElement queryInput = driver.findElement(queryLocator);
        queryInput.sendKeys("Sponge Bob\n");
        Thread.sleep(5000);

    }

}
