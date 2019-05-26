package by.it.stanishevski;

import com.sun.org.apache.bcel.internal.classfile.LineNumber;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSeleniumSiteTest {

    @Test
    public void CheckSeleniumSiteTest () throws Exception {
        WebDriver driver = new ChromeDriver();
        try { driver.get ("https://google.com");
            By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, queryLocator);
            queryInput.sendKeys("seleniumhq\n");
            WebElement findFirstSiteBySerch =  driver.findElement(By.xpath("//div[@class='r']/a"));
            findFirstSiteBySerch.click();

            WebElement findDownload =  driver.findElement(By.xpath("//a[text()='Download']"));
            findDownload.click();

            WebElement findLeftMenuMavenInfo =  driver.findElement(By.xpath("//div[@class='left']//a [text()='Maven Information']"));
            findLeftMenuMavenInfo.click();

            WebElement checkDependencyText = driver.findElement(By.xpath("//pre [contains(., '<artifactId>selenium-java</artifactId>')]"));
            String stroka = checkDependencyText.getText();



            int positionArtifactId = stroka.indexOf("<artifactId>selenium-java</artifactId>");
            if (positionArtifactId > -1) {
                System.out.println("Element <artifactId>selenium-java</artifactId> OK");
            } else {
                System.out.println("Element doesn't issue");
            }
            int posVersionStart = stroka.indexOf("<version>") + 9;
            int posVersionEnd = stroka.indexOf("</version>");
            String strVersion = stroka.substring(posVersionStart, posVersionEnd);
            System.out.println("Java Version: " + strVersion);


















        }
        finally {
            driver.quit();
        }
    }

    private static WebElement waitAndGetWebElement (WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }
}
