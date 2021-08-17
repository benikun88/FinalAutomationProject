package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends MyAcountPage{
	
	
	@FindBy(css=".pencil")
	WebElement editAcountBtn;
	@FindBy(css=".ui.text.menu .lock.icon")
	WebElement changpassBtn;
	@FindBy(css="#verification-form .button .checkmark ")
	WebElement verificationBtn;

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickedit() {
		click(editAcountBtn);
	}
	public void changePass() {
		click(changpassBtn);
	}
	public void vrifyAcount() {
		click(verificationBtn);
	}
	
	
	
	public String getSucessMsg() {
		return getT(messageElement);
	}
}
