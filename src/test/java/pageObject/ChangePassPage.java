package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ChangePassPage extends MyAcountPage {

	@FindBy(css = "#sylius_user_change_password_currentPassword")
	WebElement currentPassElement;
	@FindBy(css = "#sylius_user_change_password_newPassword_first")
	WebElement newPasswordElement;
	@FindBy(css = "#sylius_user_change_password_newPassword_second")
	WebElement confirmPassElement;
	@FindBy(css = ".button.ui.large.primary.button")
	WebElement saveChangesBtn;
	@FindBy(css = ".field.error:nth-child(2) > div")
	WebElement currentPassAlert;
	@FindBy(css = ".field.error:nth-child(3) > div")
	WebElement newPassAlert;

	public ChangePassPage(WebDriver driver) {
		super(driver);
	}

	// Change the password
	@Step("change current pass: {0},to new pass {1}")
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

	// Get the error if new pass isn't match to confirm
	public String getnewPassErr() {
		return getT(newPasswordElement);
	}

	// Get massage success password change
	public String getSuccesChangeMsg() {
		return getT(messageElement);
	}

}
