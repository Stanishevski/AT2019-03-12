package by.it._tasks_.at27.page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class PomLogin {

    /**
     * All WebElements are identified by @FindBy annotation
     */
    WebDriver driver;
    @FindBy(name = "uid")
    WebElement userpomName;

    @FindBy(name = "password")
    WebElement passwordpom;

    @FindBy(className = "barone")
    WebElement titleText;

    @FindBy(name = "btnLogin")
    WebElement login;

    public PomLogin(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create lazy all WebElements
        AjaxElementLocatorFactory factory=
                new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory, this);
    }


    //Set user name in textbox
    public void setUserName(String strUserName) {
        userpomName.sendKeys(strUserName);

    }

    //Set password in password textbox
    public void setPassword(String strPassword) {
        passwordpom.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin() {
        login.click();
    }

    //Get the title of Login Page
    public String getLoginTitle() {
        return titleText.getText();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     *
     * @param strUserName
     * @param strPassword
     * @return
     */
    public void loginToPom(String strUserName, String strPassword) {
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();

    }
}
