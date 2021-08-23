package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends MenuPage {

	@FindBy(css = ".ui.segment .required")
	List<WebElement> shipMethod;
	@FindBy(css = "#next-step")
	WebElement nextBtn;
	@FindBy(css = "div.column > a.ui.large.icon.labeled.button")
	WebElement changeAddBtn;
	@FindBy(css = "div.column > a.ui.large.icon.labeled.button")
	List<WebElement> shipMethodPrice;

	public ShippingPage(WebDriver driver) {
		super(driver);
	}

	public void chooseshipping(String ship) {
		for (WebElement el : shipMethod) {
			if (el.getText().equalsIgnoreCase(ship)) {
				click(el);
				sleep(3000);
				click(nextBtn);
				break;
			}
		}
	}

	public void deleteitem(String name) {
		int index = 0;
		for (WebElement el : shipMethod) {
			if (el.getText().equalsIgnoreCase(name)) {
				break;
			}
			index++;
		}
		click(shipMethodPrice.get(index));
		sleep(2000);
	}

	public void returnToAdress() {
		click(changeAddBtn);
	}

	// validation

}
