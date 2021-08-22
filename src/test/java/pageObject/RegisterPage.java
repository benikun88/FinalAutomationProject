package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		// TODO Auto-generated constructor stub
	}

	// Register a new account 
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

	public void setFirstNamElement(WebElement firstNamElement, String name) {
		fillText(firstNamElement, name);
	}

	public void setLastNamElement(WebElement lastNamElement, String lastName) {
		fillText(lastNamElement, lastName);
	}

	public void setEmilElement(WebElement emilElement, String email) {
		fillText(emilElement, email);
	}

	public void setPhoneNumElement(WebElement phoneNumElement, String phone) {
		fillText(phoneNumElement, phone);
	}

	public void setPassElement(WebElement passElement, String pass) {
		fillText(passElement, pass);
	}

	public void setPassVerificationElement(WebElement passVerificationElement, String passconfirm) {
		fillText(passVerificationElement, passconfirm);
	}

	public void singin() {
		click(singinBtn);
	}

	// validate
	public String getfirstNameAlert() {

		return getT(firstNameAlert);
	}

	public String getlastNameAlert() {

		return getT(lastNameAlert);
	}

	public String getemailAlert() {

		return getT(emailAlert);
	}

	public String getpassAlert() {

		return getT(passAlert);
	}

}
