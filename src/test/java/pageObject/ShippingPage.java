package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends MenuPage{
	
	
	@FindBy(css=".ui.segment .required")
	List<WebElement> shipMethod;
	@FindBy(css="#next-step")
	WebElement nextBtnElement;
	@FindBy(css="div.column > a.ui.large.icon.labeled.button")
	WebElement changeAddBtn;

	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
