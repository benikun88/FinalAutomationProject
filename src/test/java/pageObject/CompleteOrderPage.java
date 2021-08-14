package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteOrderPage extends BasePage{
	
	@FindBy(css=".sylius-unit-price")
	WebElement unitPricElement;
	@FindBy(css="#total")
	WebElement totalPricElement;
	@FindBy(css=".labeled.button")
	WebElement placeOrederBtn;
	@FindBy(css="#sylius-thank-you")
	WebElement thankYouMsg;
	@FindBy(css="#payment-method-page")
	WebElement metofPayBtn;

	public CompleteOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
