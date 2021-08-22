package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adressPage extends BasePage {

	@FindBy(css = "#sylius_checkout_address_customer_email")
	WebElement emailElement;
	@FindBy(css = "#sylius_checkout_address_billingAddress_firstName")
	WebElement firsNameElement;
	@FindBy(css = "#sylius_checkout_address_billingAddress_lastName")
	WebElement lastNameElement;
	@FindBy(css = "#sylius_checkout_address_billingAddress_street")
	WebElement streetAddressElement;
	@FindBy(css = "#sylius_checkout_address_billingAddress_countryCode")
	WebElement countryElement;
	@FindBy(css = "#sylius_checkout_address_billingAddress_city")
	WebElement cityElement;
	@FindBy(css = "#sylius_checkout_address_billingAddress_postcode")
	WebElement postcodeElement;
	@FindBy(css = "#next-step")
	WebElement nextBtn;

	public adressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void fillAdress(String email, String firstName, String lastName, String streetAddress, String country,
			String city, String postcode, String next) {
		setEmail(email);
		setFirstName(firstName);
		setlastName(lastName);
		setstreetAddress(streetAddress);
		setcountry(country);
		setcity(city);
		setpostcode(postcode);
		click(nextBtn);

	}

	public void setEmail(String email) {
		if (isExist(emailElement)) {
			fillText(emailElement, email);
		}
	}

	public void setFirstName(String firstName) {
		fillText(firsNameElement, firstName);
	}

	public void setlastName(String lastName) {
		fillText(lastNameElement, lastName);
	}

	public void setstreetAddress(String streetAddress) {
		fillText(streetAddressElement, streetAddress);
	}

	public void setcountry(String country) {
		fillText(countryElement, country);
	}

	public void setcity(String city) {
		fillText(cityElement, city);
	}

	public void setpostcode(String postcode) {
		fillText(postcodeElement, postcode);
	}

}
