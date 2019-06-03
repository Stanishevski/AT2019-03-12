package by.it._tasks_.at27.page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomHomePage {

	WebDriver driver;
	@FindBy(xpath="//table//tr[@class='heading3']")
	WebElement homePageUserName;
	
	public PomHomePage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Get the User name from Home Page
		public String getHomePageDashboardUserName(){
		 return	homePageUserName.getText();
		}
}
