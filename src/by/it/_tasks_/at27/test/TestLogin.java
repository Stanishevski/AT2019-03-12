package by.it._tasks_.at27.test;

import java.util.concurrent.TimeUnit;

import by.it._tasks_.at27.pages.PomHomePage;
import by.it._tasks_.at27.pages.PomLogin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {

    private WebDriver driver;
    private PomLogin objLogin;
    private PomHomePage objHomePage;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.pom.com/V4/");
    }

    /**
     * This test case will login in http://demo.pom.com/V4/
     * Verify login page title as pom bank
     * Login to application
     * Verify the home page using Dashboard message
     */
    @Test
    public void test_Home_Page_Appear_Correct() {
        //Create Login Page object
        objLogin = new PomLogin(driver);
        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("pom bank"));
        //login to application
        objLogin.loginToPom("mgr123", "mgr!23");
        // go the next page
        objHomePage = new PomHomePage(driver);
        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName()
                .toLowerCase().contains("manger id : mgr123"));
    }

}
