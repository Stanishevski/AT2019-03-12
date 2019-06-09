package by.it.okoyro.belavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BelaviaSearchResultPage {
	private WebDriver driver;

	public BelaviaSearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy()
	private WebElement foundedFlights;

//	public int countSearchResults(){
//		List<WebElement> searchResults =
//		return
//	}
}
