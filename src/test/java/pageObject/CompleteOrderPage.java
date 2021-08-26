package pageObject;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteOrderPage extends BasePage {

	@FindBy(css = ".sylius-unit-price")
	WebElement unitPricElement;
	@FindBy(css = "#total")
	WebElement totalPricElement;
	@FindBy(css = ".labeled.button")
	WebElement placeOrederBtn;
	@FindBy(css = "#sylius-thank-you .sub")
	WebElement thankYouMsg;
	@FindBy(css = "#sylius-payment-method")
	WebElement payMetodElement;
	@FindBy(css = "#sylius_checkout_complete_notes")
	WebElement noteFieldElement;
	@FindBy(css = "sylius-show-order-in-account")
	WebElement viewOrderBtn;

	public CompleteOrderPage(WebDriver driver) {
		super(driver);
	}
	public void vierOrder() {
		click(viewOrderBtn);
	}

	// Click on place order - last order flow step
	public void placeOrder() {
		click(placeOrederBtn);
	}

	public void enterNotes(String note) {
		fillText(noteFieldElement, note);
	}

	// validation
	public String checkOrderSuccess() {
		return getT(thankYouMsg);
	}
}
