package pageObject;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends MyAcountPage{
	
	@FindBy(css ="#sylius_customer_profile_firstName" )
	WebElement firstNamElement;
	@FindBy(css ="#sylius_customer_profile_lastName" )
	WebElement lastNamElement;
	@FindBy(css ="#sylius_customer_profile_email" )
	WebElement emailElement;
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
	
	public void setFirstName(String firstName) {
		fillText(firstNamElement, firstName);
	}
	public void setLastName(String lastName) {
		fillText(lastNamElement, lastName);
	}
	public void setEmail(String email) {
		fillText(emailElement, email);
	}
	public void setGender(String gender) {
		SelectByText(genderElement, gender);
	}
	
	public void updateProfile(String firstName,String lastName,String email,String gender) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setGender(gender);
		click(saveChangesBtn);
		sleep(3000);
	}
	
	
	
	
	//Validate
	public String getSucessMsg() {
		return getT(messageElement);
	}

}
