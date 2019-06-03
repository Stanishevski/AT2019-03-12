package by.it._tasks_.at27.page_factory_google_q;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleSearchPage {
    @FindBy(name = "q") //если совпадает с именем или id можно не указывать
    private WebElement q; //элемент по локатору

    void searchFor(String text) {
        q.sendKeys(text);   //используем
        q.submit();         //используем
    }
} 