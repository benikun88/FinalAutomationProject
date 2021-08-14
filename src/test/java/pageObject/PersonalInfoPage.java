package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends MyAcountPage{
	
	@FindBy(css ="#sylius_customer_profile_firstName" )
	WebElement firstNamElement;
	@FindBy(css ="#sylius_customer_profile_lastName" )
	WebElement lastNamElement;
	@FindBy(css ="#sylius_customer_profile_email" )
	WebElement emilElement;
	@FindBy(css ="#sylius_customer_profile_phoneNumber" )
	WebElement phoneNumElement;
	@FindBy(css ="#sylius_customer_profile_birthday" )
	WebElement birthdayElement;
	@FindBy(css ="#sylius_customer_profile_gender" )
	WebElement genderElement;
	@FindBy(css =".primary.button:nth-child(8)" )
	WebElement saveChangesBtn;
	
	public PersonalInfoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
