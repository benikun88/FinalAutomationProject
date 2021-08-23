package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

	@FindBy(css = "#sylius-cart-items .sylius-product-name")
	List<WebElement> productsList;
	@FindBy(css = "#sylius-summary-grand-total")
	WebElement orderTotalElement;
	@FindBy(css = "#sylius-summary-shipping-total")
	WebElement shippingTotalElement;
	@FindBy(css = "sylius-summary-items-subtotal")
	WebElement subtotalElement;

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

}
