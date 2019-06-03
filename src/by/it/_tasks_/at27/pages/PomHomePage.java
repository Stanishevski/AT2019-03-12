package by.it._tasks_.at27.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomHomePage {

	private WebDriver driver;
	private By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	
	public PomHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	//Get the User name from Home Page
		public String getHomePageDashboardUserName(){
		 return	driver.findElement(homePageUserName).getText();
		}
}
