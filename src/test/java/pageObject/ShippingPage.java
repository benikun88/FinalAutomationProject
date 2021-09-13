package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

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

	// Choose the shipping method
	@Step("choose shipping: {0}")
	public void chooseShipping(String ship) {
		for (WebElement el : shipMethod) {
			if (el.getText().equalsIgnoreCase(ship)) {
				click(el);
				// sleep(2000);
				explicitWaitClickable(nextBtn);
				click(nextBtn);
				break;
			}
		}
	}

	// Return back to address
	public void returnToAdress() {
		click(changeAddBtn);
	}

	// validation

}
