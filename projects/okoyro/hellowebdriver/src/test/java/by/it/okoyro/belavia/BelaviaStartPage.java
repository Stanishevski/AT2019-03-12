package by.it.okoyro.belavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BelaviaStartPage {

	private WebDriver driver;

	// в этом случае переменная инициализируется не сразу, а только когда нужно
	// так объявляются локаторы для PageFactory
	
	public BelaviaStartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "select-member")
	private WebElement loginIcon;


	public LoginFormBelavia getLoginMenu() {
		loginIcon.click();
		return new LoginFormBelavia(driver);
	}
}
