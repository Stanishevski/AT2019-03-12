package by.it.stanishevski.pages;

import by.it.stanishevski.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage1 {

    private WebDriver driver;

    private By byPrice=By.xpath("//*[@data-test-id='listing-price-dollars']");

    public ResultPage1(WebDriver driver) {
        this.driver = driver;
    }

    public int getResultSearchCount(){
        List<WebElement> elements = Util.findAll(driver,byPrice);
        return elements.size();
    }
}
