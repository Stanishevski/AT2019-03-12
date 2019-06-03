package by.it._tasks_.at27.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class NoPOMTestLogin {

/**
* Login to application
*/
	@Test
	public void test_Home_Page_Appear_Correct(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.pom.com/V4/");
		//Find user name and fill user name
	    driver.findElement(By.name("uid")).sendKeys("mgr123");
	    //find password and fill it
	    driver.findElement(By.name("password")).sendKeys("mgr!23");
	    //click login button
	    driver.findElement(By.name("btnLogin")).click(); 
	    String homeText = driver.findElement(
	    		By.xpath("//table//tr[@class='heading3']")
		).getText();
	    //verify login success
		Assert.assertTrue(homeText.toLowerCase().contains("pom bank"));
	}
	
}
