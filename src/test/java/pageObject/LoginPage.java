package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LoginPage extends MenuPage {

	@FindBy(css = "#_username")
	WebElement userElement;
	@FindBy(css = "#_password")
	WebElement passwordElement;
	@FindBy(css = "[type=\"submit\"]")
	WebElement singElement;
	@FindBy(css = ".column [href=\"/en_US/register\"]")
	WebElement createAccountBtnElement;
	@FindBy(css = "a.ui.right.floated.button:nth-child(6)")
	WebElement forgotPassBtn;
	@FindBy(css = ".negative.message p")
	WebElement loginEreMsg;
	@FindBy(css = ".positive.message.sylius-flash-message:nth-child(2) div p")
	WebElement posativeMsg;
	@FindBy(css = ".positive .close ")
	WebElement closeSuccesMsgBtn;
	@FindBy(css = ".message.sylius-flash-message:nth-child(3) div p")
	WebElement verifyMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Login to account
	@Step("fill email: {0},fill password:{1}")
	public void login(String email, String password) {
		setUser(email);
		setPass(password);
		click(singElement);
	}

	// Fill the user text box
	@Step("fill email: {0}")
	public void setUser(String email) {
		fillText(userElement, email);
	}

	// Fill the user password box
	@Step("fill email: {0}")
	public void setPass(String password) {
		fillText(passwordElement, password);
	}

	// Click on the Forget password button
	public void clickForgotPassBtn() {
		click(forgotPassBtn);
	}

	// Click on the create account button
	public void clickCreateacountBtn() {
		click(createAccountBtnElement);
	}

	// Validation
	// Get the error login error message
	public String getError() {
		waitForVisibleOfElement(loginEreMsg);
		return getT(loginEreMsg);
	}

	// Get the success login message
	public String getMsg() {
		waitForVisibleOfElement(posativeMsg);
		return getT(posativeMsg);
	}

	// Get the URL validation account
	public String getUrlForUserVrify() {
		String url = getT(verifyMsg);
		url = url.substring(32, 84);
		System.out.println(url);
		return url;
	}

}
