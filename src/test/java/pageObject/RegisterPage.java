package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class RegisterPage extends MenuPage {

	@FindBy(css = "#sylius_customer_registration_firstName")
	WebElement firstNamElement;
	@FindBy(css = "#sylius_customer_registration_lastName")
	WebElement lastNamElement;
	@FindBy(css = "#sylius_customer_registration_email")
	WebElement emilElement;
	@FindBy(css = "#sylius_customer_registration_phoneNumber")
	WebElement phoneNumElement;
	@FindBy(css = "#sylius_customer_registration_user_plainPassword_first")
	WebElement passElement;
	@FindBy(css = "#sylius_customer_registration_user_plainPassword_second")
	WebElement passVerificationElement;
	@FindBy(css = ".large.primary.button")
	WebElement createAcountBtn;
	@FindBy(css = ".middle.aligned.column .button")
	WebElement singinBtn;
	@FindBy(css = "div.required.field.error:nth-child(1) > div")
	WebElement firstNameAlert;
	@FindBy(css = "div.required.field.error:nth-child(2) > div")
	WebElement lastNameAlert;
	@FindBy(css = "div.required.field.error:nth-child(3) > div")
	WebElement emailAlert;
	@FindBy(css = "div.required.field.error:nth-child(7) > div")
	WebElement passAlert;

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// Register a new account
	@Step("enter ,first name: {0},last Name: {1},email: {2},phone: {3},pass: {4},pass confirm: {5}")
	public void register(String name, String lastName, String email, String phone, String pass, String passconfirm) {
		setFirstNamElement(firstNamElement, name);
		setLastNamElement(lastNamElement, lastName);
		setEmilElement(emilElement, email);
		setPhoneNumElement(phoneNumElement, phone);
		setPassElement(passElement, pass);
		setPassVerificationElement(passVerificationElement, passconfirm);
		click(createAcountBtn);
		sleep(2000);
	}

	// Fill the first name text box
	public void setFirstNamElement(WebElement firstNamElement, String name) {
		fillText(firstNamElement, name);
	}

	// Fill the last name text box
	public void setLastNamElement(WebElement lastNamElement, String lastName) {
		fillText(lastNamElement, lastName);
	}

	// Fill the email text box
	public void setEmilElement(WebElement emilElement, String email) {
		fillText(emilElement, email);
	}

	// Fill the phone text box
	public void setPhoneNumElement(WebElement phoneNumElement, String phone) {
		fillText(phoneNumElement, phone);
	}

	// Fill the password text box
	public void setPassElement(WebElement passElement, String pass) {
		fillText(passElement, pass);
	}

	// Fill the verification password text box
	public void setPassVerificationElement(WebElement passVerificationElement, String passconfirm) {
		fillText(passVerificationElement, passconfirm);
	}

	// Click on sing in button
	public void singin() {
		click(singinBtn);
	}

	// Validate
	// Get alert if first name box is empty
	public String getfirstNameAlert() {

		return getT(firstNameAlert);
	}

	// Get alert if last name box is empty
	public String getlastNameAlert() {

		return getT(lastNameAlert);
	}

	// Get alert if email box is empty
	public String getemailAlert() {

		return getT(emailAlert);
	}

	// Get alert if password box is empty
	public String getpassAlert() {

		return getT(passAlert);
	}

}
