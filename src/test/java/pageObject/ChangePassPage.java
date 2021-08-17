package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassPage extends MyAcountPage{
	
	@FindBy(css ="#sylius_user_change_password_currentPassword" )
	WebElement currentpassElement;
	@FindBy(css ="#sylius_user_change_password_newPassword_first" )
	WebElement newPasswordElement;
	@FindBy(css ="#sylius_user_change_password_newPassword_second" )
	WebElement confirmPassElement;
	@FindBy(css =".primary.button:nth-child(4)" )
	WebElement saveChangesBtn;
	

	public ChangePassPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void changePass(String current,String newPass,String Confirm) {
		fillText(currentpassElement, current);
		fillText(newPasswordElement, current);
		fillText(confirmPassElement, current);
		click(saveChangesBtn);
	}

}
