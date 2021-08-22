package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends MenuPage {

	@FindBy(css = "#next-step")
	WebElement nextBtn;
	@FindBy(css = "div.column > a.ui.large.icon.labeled.button")
	WebElement changeShipBtn;
	@FindBy(css = ".ui.segment .required")
	List<WebElement> payOptionList;

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Choose the pay method
	public void choosePayMethod(String payOption) {
		for (WebElement el : payOptionList) {
			if (el.getText().equalsIgnoreCase(payOption)) {
				click(el);
				sleep(3000);
				click(nextBtn);
				break;
			}
		}
	}

}
