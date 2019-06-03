package by.it.romanova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryLoginPage{

    private WebDriver driver;

    public FactoryLoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(5000);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gss-signin-email")
    private WebElement emailField;

    @FindBy(id = "gss-signin-password")
    private WebElement passwordField;

    @FindBy(id = "gss-signin-submit")
    private WebElement signInButton;

    public FactoryLoginPage setEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
        return this;
    }

    public FactoryLoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public FactoryHomePage logIn() throws InterruptedException {
        signInButton.click();
        Thread.sleep(100000);
        FactoryHomePage factoryStartPage = new FactoryHomePage(driver);
        return factoryStartPage;
    }
}
