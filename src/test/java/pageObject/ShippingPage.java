package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends MenuPage{
	
	
	@FindBy(css=".ui.segment .required")
	List<WebElement> shipMethod;
	@FindBy(css="#next-step")
	WebElement nextBtn;
	@FindBy(css="div.column > a.ui.large.icon.labeled.button")
	WebElement changeAddBtn;

	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void chooseshiping(String ship) {
		for (WebElement el : shipMethod) {
			if(el.getText().equalsIgnoreCase(ship)) {
				click(el);
				sleep(3000);
				click(nextBtn);
				break;
			}
		}
	}
	
	public void returnToAdress() {
		click(changeAddBtn);
	}

}
