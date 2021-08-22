package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassPage extends MyAcountPage {

	@FindBy(css = "#sylius_user_change_password_currentPassword")
	WebElement currentPassElement;
	@FindBy(css = "#sylius_user_change_password_newPassword_first")
	WebElement newPasswordElement;
	@FindBy(css = "#sylius_user_change_password_newPassword_second")
	WebElement confirmPassElement;
	@FindBy(css = ".primary.button:nth-child(4)")
	WebElement saveChangesBtn;
	@FindBy(css = "div.ui.segment form.ui.loadable.form div.required.field.error:nth-child(2) > div")
	WebElement currentPassAlert;
	@FindBy(css = "div.ui.segment form.ui.loadable.form div.required.field.error:nth-child(3) > div")
	WebElement newPassAlert;

	public ChangePassPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Change the password
	public void changePass(String current, String newPass, String Confirm) {
		fillText(currentPassElement, current);
		fillText(newPasswordElement, newPass);
		fillText(confirmPassElement, Confirm);
		click(saveChangesBtn);
	}

	// validation
	public String getcurrentPassErr() {
		return getT(currentPassAlert);
	}

	public String getnewPassErr() {
		return getT(newPasswordElement);
	}

	public String getSuccesChangeMsg() {
		return getT(messageElement);
	}

}
