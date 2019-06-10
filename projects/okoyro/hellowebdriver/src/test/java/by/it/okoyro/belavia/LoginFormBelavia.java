package by.it.okoyro.belavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFormBelavia {

	private WebDriver driver;

	public LoginFormBelavia(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "MemberId")
	private WebElement userNameInput;

	@FindBy(id = "Password")
	private WebElement passwordInput;

	@FindBy(className =  "btn-b2-login")
	private WebElement loginButton;


	public LoginFormBelavia setUserName() {
		userNameInput.sendKeys("10012181001");
		return this;
	}

	public LoginFormBelavia setPassword(){
		passwordInput.sendKeys("R4H4K8");
		return this;
	}

	public BelaviaHomePage confirmLogin() {
		loginButton.click();
		return new BelaviaHomePage(driver);
	}
}
