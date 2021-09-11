package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ForgotPassPage extends LoginPage {

	@FindBy(css = "#sylius_user_request_password_reset_email")
	WebElement emailElement;
	@FindBy(css = "a.button-medium")
	WebElement passBtnElement;
	@FindBy(css = "[title=\"Back to Login\"]")
	WebElement backBtnElement;
	@FindBy(css = "[type=\"submit\"]")
	WebElement resetBtn;
	@FindBy(css = ".sylius-validation-error")
	WebElement errorMsgElement;

	public ForgotPassPage(WebDriver driver) {
		super(driver);
	}

	// Click Reset password button
	public void clickReset() {
		click(resetBtn);
	}

	// Reset password
	@Step("Enter email: {0}")
	public void resetPass(String emiString) {
		fillText(emailElement, emiString);
		clickReset();
	}

	// Validate
	// Get the error message
	public String getErrorMsg() {
		return getT(errorMsgElement);
	}

}
