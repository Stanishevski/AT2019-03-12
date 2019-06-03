package by.it._tasks_.at27.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PomLogin {

	private WebDriver driver;
	private By user99GuruName = By.name("uid");
	private By password99Guru = By.name("password");
	private By titleText =By.className("barone");
	private By login = By.name("btnLogin");
	
	public PomLogin(WebDriver driver){
		this.driver = driver;
	}
	//Set user name in textbox
	public void setUserName(String strUserName){
		driver.findElement(user99GuruName).sendKeys(strUserName);;
	}
	
	//Set password in password textbox
	public void setPassword(String strPassword){
		 driver.findElement(password99Guru).sendKeys(strPassword);
	}
	
	//Click on login button
	public void clickLogin(){
			driver.findElement(login).click();
	}
	
	//Get the title of Login Page
	public String getLoginTitle(){
	 return	driver.findElement(titleText).getText();
	}

	public void loginToPom(String strUserName,String strPasword){
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();		
		
	}
}
