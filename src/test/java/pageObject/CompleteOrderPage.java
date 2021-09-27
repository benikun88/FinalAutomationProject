package pageObject;


import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.NoSuchElementException;


import io.qameta.allure.Step;

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
	@FindBy(css = ".sylius-show-order-in-account")
	WebElement viewOrderBtn;
	@FindBy(css = ".aligned.icon.header")
	WebElement serverErr;

	public CompleteOrderPage(WebDriver driver) {
		super(driver);
	}
	//	vIEW the order 
	public void viewOrder() {
		click(viewOrderBtn);
	}

	// Click on place order - last order flow step
	public void placeOrder() {
		click(placeOrederBtn);
	}

	// Fill note for order
	@Step("enter note {0}")
	public void enterNotes(String note) {
		fillText(noteFieldElement, note);
	}

	// validation
	// Check if order has purchase successfully
	public String checkOrderSuccess() {
		try {
			return getT(thankYouMsg);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return getT(serverErr);
		}
	}
}
	
