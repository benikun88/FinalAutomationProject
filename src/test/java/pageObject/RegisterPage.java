package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends MenuPage{
	
	@FindBy(css ="#sylius_customer_registration_firstName" )
	WebElement firstNamElement;
	@FindBy(css ="#sylius_customer_registration_lastName" )
	WebElement lastNamElement;
	@FindBy(css ="#sylius_customer_registration_email" )
	WebElement emilElement;
	@FindBy(css ="#sylius_customer_registration_phoneNumber" )
	WebElement phoneNumElement;
	@FindBy(css ="#sylius_customer_registration_user_plainPassword_first" )
	WebElement passElement;
	@FindBy(css ="#sylius_customer_registration_user_plainPassword_second" )
	WebElement passVerificationElement;
	@FindBy(css =".large.primary.button" )
	WebElement createacountBtn;
	@FindBy(css =".middle.aligned.column .button" )
	WebElement singuserElement;

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
