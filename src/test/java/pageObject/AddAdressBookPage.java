package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AddAdressBookPage extends MyAcountPage {

	@FindBy(css = "#sylius_address_firstName")
	WebElement firsNameElement;
	@FindBy(css = "#sylius_address_lastName")
	WebElement lastNameElement;
	@FindBy(css = "#sylius_address_street")
	WebElement streetAddressElement;
	@FindBy(css = "#sylius_address_countryCode")
	WebElement countryElement;
	@FindBy(css = "#sylius_address_city")
	WebElement cityElement;
	@FindBy(css = "#sylius_address_postcode")
	WebElement postcodeElement;
	@FindBy(css = ".plus")
	WebElement addBtn;

	public AddAdressBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// fill address shipment in the order flow
	@Step("enter ,first name: {0},last Name: {1},street Address: {2},country: {3},city: {4},postcode: {5}")
	public void fillAddress(String firstName, String lastName, String streetAddress, String country, String city,
			String postcode) {
		setFirstName(firstName);
		setLastName(lastName);
		setStreetAddress(streetAddress);
		setCountry(country);
		setCity(city);
		setPostCode(postcode);
		click(addBtn);
	}

	// fill first name filed
	public void setFirstName(String firstName) {
		fillText(firsNameElement, firstName);
	}

	// fill last name filed
	public void setLastName(String lastName) {
		fillText(lastNameElement, lastName);
	}

	// fill street address filed
	public void setStreetAddress(String streetAddress) {
		fillText(streetAddressElement, streetAddress);
	}

	// fill country filed
	public void setCountry(String country) {
		SelectByText(countryElement, country);
	}

	// fill city filed
	public void setCity(String city) {
		fillText(cityElement, city);
	}

	// fill post code filed
	public void setPostCode(String postcode) {
		fillText(postcodeElement, postcode);
	}
}
