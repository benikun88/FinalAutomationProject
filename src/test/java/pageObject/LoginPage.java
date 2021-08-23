package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	public void login(String email, String password) {
		setUser(email);
		setPass(password);
		click(singElement);
		sleep(2000);
	}

	public void setUser(String email) {
		fillText(userElement, email);
	}

	public void setPass(String password) {
		fillText(passwordElement, password);
	}

	public void clickForgotPassBtn() {
		click(forgotPassBtn);
	}

	public void clickCreateacountBtn() {
		click(createAccountBtnElement);
	}

	// Validation
	public String getError() {

		return getT(loginEreMsg);
	}

	public String getMsg() {

		return getT(posativeMsg);
	}
	public String getUrlForUserVrify() {
		String url=getT(verifyMsg);
		url = url.substring(32,84);
		System.out.println(url);
		return url;
	}

}
