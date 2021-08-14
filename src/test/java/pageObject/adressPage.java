package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adressPage extends BasePage{
	
	@FindBy(css="#sylius_checkout_address_customer_email")
	WebElement emailElement;
	@FindBy(css="#sylius_checkout_address_billingAddress_firstName")
	WebElement firsNameElement;
	@FindBy(css="#sylius_checkout_address_billingAddress_lastName")
	WebElement lastNameElement;
	@FindBy(css="#sylius_checkout_address_billingAddress_street")
	WebElement streetAddressElement;
	@FindBy(css="#sylius_checkout_address_billingAddress_street")
	WebElement addressElement;
	@FindBy(css="#sylius_checkout_address_billingAddress_countryCode")
	WebElement countryElement;
	@FindBy(css="#sylius_checkout_address_billingAddress_city")
	WebElement cityElement;
	@FindBy(css="#sylius_checkout_address_billingAddress_postcode")
	WebElement postcodeElement;
	@FindBy(css="#next-step")
	WebElement nextBtn;


	public adressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
