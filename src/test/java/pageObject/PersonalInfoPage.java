package pageObject;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class PersonalInfoPage extends MyAcountPage {

	@FindBy(css = "#sylius_customer_profile_firstName")
	WebElement firstNamElement;
	@FindBy(css = "#sylius_customer_profile_lastName")
	WebElement lastNamElement;
	@FindBy(css = "#sylius_customer_profile_email")
	WebElement emailElement;
	@FindBy(css = "#sylius_customer_profile_phoneNumber")
	WebElement phoneNumElement;
	@FindBy(css = "#sylius_customer_profile_birthday")
	WebElement birthdayElement;
	@FindBy(css = "#sylius_customer_profile_gender")
	WebElement genderElement;
	@FindBy(css = ".primary.button:nth-child(8)")
	WebElement saveChangesBtn;

	public PersonalInfoPage(WebDriver driver) {
		super(driver);
	}

	// Fill the first name text box
	public void setFirstName(String firstName) {
		fillText(firstNamElement, firstName);
	}

	// Fill the last name text box
	public void setLastName(String lastName) {
		fillText(lastNamElement, lastName);
	}

	// Fill the email text box
	public void setEmail(String email) {
		fillText(emailElement, email);
	}

	// Choose gender
	public void setGender(String gender) {
		SelectByText(genderElement, gender);
	}

	// Update the user profile fields
	@Step("fill first Name: {0},last Name: {1},email: {2},gender: {3}")
	public void updateProfile(String firstName, String lastName, String email, String gender) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setGender(gender);
		click(saveChangesBtn);
	}

	// Validate
	// Check success update
	public String getSucessMsg() {
		waitForVisibleOfElement(messageElement);
		return getT(messageElement);
	}

}
