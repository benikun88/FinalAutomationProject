package pageObject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.beust.jcommander.internal.Console;

import io.qameta.allure.Step;

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
	@Step("enter ,first name: {0},last Name: {1},street Address: {2},country: {3},city: {4},postcode: {5}")
	public void fillAddress(String firstName, String lastName, String streetAddress, String country, String city,
			String postcode) {
		setFirstName(firstName);
		setLastName(lastName);
		setStreetAddress(streetAddress);
		setCountry(country);
		waitForVisibleOfElement(cityElement);
		setCity(city);
		setPostCode(postcode);
		sleep(2000);
		click(nextBtn);
		sleep(1000);
	}

	// fill address shipment in the order flow user not logged in
	@Step("enter email: {0},first name: {1},last Name: {2},street Address: {3},country: {4},city: {5},postcode: {6}")
	public void fillAddressNoEmail(String email, String firstName, String lastName, String streetAddress,
			String country, String city, String postcode) {
		setEmail(email);
		setFirstName(firstName);
		setLastName(lastName);
		setStreetAddress(streetAddress);
		setCountry(country);
		setCity(city);
		setPostCode(postcode);
		click(nextBtn);
	}

	// fill Email field
	public void setEmail(String email) {

		fillText(emailElement, email);
	}

	// fill first name field
	public void setFirstName(String firstName) {
		fillText(firsNameElement, firstName);
	}

	// fill last name field
	public void setLastName(String lastName) {
		fillText(lastNameElement, lastName);
	}

	// fill street address field
	public void setStreetAddress(String streetAddress) {
		fillText(streetAddressElement, streetAddress);
	}

	// fill country field
	public void setCountry(String country) {
		SelectByText(countryElement, country);
	}

	// fill city field
	public void setCity(String city) {
		fillText(cityElement, city);
	}

	// fill post code field
	public void setPostCode(String postcode) {
		fillText(postcodeElement, postcode);
	}

}
