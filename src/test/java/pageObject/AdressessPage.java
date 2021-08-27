package pageObject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.beust.jcommander.internal.Console;

public class AdressessPage extends CheckOutPage {

	
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

	public AdressessPage(WebDriver driver) {
		super(driver);
	}

	// fill address shipment in the order flow
	public void fillAddress(String firstName, String lastName, String streetAddress, String country, String city,
			String postcode) {
		setFirstName(firstName);
		setlastName(lastName);
		setstreetAddress(streetAddress);
		setcountry(country);
		sleep(2000);
		setcity(city);
		setpostcode(postcode);
		click(nextBtn);

	}

	public void fillAddressNoEmail(String email, String firstName, String lastName, String streetAddress,
			String country, String city, String postcode) {
		setEmail(email);
		setFirstName(firstName);
		setlastName(lastName);
		setstreetAddress(streetAddress);
		setcountry(country);
		setcity(city);
		setpostcode(postcode);
		click(nextBtn);

	}

	// fill Email filed
	public void setEmail(String email) {

		fillText(emailElement, email);
	}

	// fill first name filed
	public void setFirstName(String firstName) {
		fillText(firsNameElement, firstName);
	}

	// fill last name filed
	public void setlastName(String lastName) {
		fillText(lastNameElement, lastName);
	}

	// fill street address filed
	public void setstreetAddress(String streetAddress) {
		fillText(streetAddressElement, streetAddress);
	}

	// fill country filed
	public void setcountry(String country) {
		SelectByText(countryElement, country);
	}

	// fill city filed
	public void setcity(String city) {
		fillText(cityElement, city);
	}

	// fill post code filed
	public void setpostcode(String postcode) {
		fillText(postcodeElement, postcode);
	}

}
