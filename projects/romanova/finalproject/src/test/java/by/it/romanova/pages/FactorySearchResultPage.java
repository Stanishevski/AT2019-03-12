package by.it.romanova.pages;

import by.it.romanova.tools.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FactorySearchResultPage extends Util {

    public FactorySearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class=\"flight-module segment offer-listing\"]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[@class=\"primary-content   custom-primary-padding\"]/span")
    private List<WebElement> prices;

    public FactorySearchResultPage checkMoreThanOneResult(){
        Assert.assertTrue(searchResults.size()>=1);
        return this;
    }

    private List<String> getPrices(){
        Iterator<WebElement> iterator = prices.iterator();
        List<String> prices = new LinkedList<>();
        while (iterator.hasNext()){
            prices.add(iterator.next().getText().replace("$",""));
        }
        return prices;
    }

    public FactorySearchResultPage assertPricesHigher(int price){
        List<String> prices = this.getPrices();
        Iterator<String> iterator = prices.iterator();
        while (iterator.hasNext()){
            int gottenPrice = Integer.parseInt(iterator.next());
            Assert.assertTrue(gottenPrice > price);
        }
        return this;
    }
}
