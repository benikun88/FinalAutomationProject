package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassPage extends AuthenticationPage {
	
	@FindBy(css ="#sylius_user_request_password_reset_email" )
	WebElement emailElement;
	@FindBy(css ="a.button-medium" )
	WebElement passBtnElement;
	@FindBy(css ="[title=\"Back to Login\"]" )
	WebElement backBtnElement;
	@FindBy(css ="[type=\"submit\"]" )
	WebElement resetBtn;
	
	

	public ForgotPassPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
