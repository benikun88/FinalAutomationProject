package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends MyAcountPage {

	@FindBy(css = ".pencil")
	WebElement editAcountBtn;
	@FindBy(css = ".ui.text.menu .lock.icon")
	WebElement changePassBtn;
	@FindBy(css = "#verification-form .button .checkmark ")
	WebElement verificationBtn;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	// Edit the account
	public void clickedit() {
		click(editAcountBtn);
	}

	// Change the password
	public void changePass() {
		click(changePassBtn);
		sleep(1000);
	}

	// click on verify account button
	public void vrifyAccount() {
		click(verificationBtn);
	}

	// validation
	public String getSucessMsg() {
		return getT(messageElement);
	}
}
