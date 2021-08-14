package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends MenuPage{
	
	@FindBy(css ="#_username" )
	WebElement userElement;
	@FindBy(css ="#_password" )
	WebElement passwordElement;
	@FindBy(css ="[type=\"submit\"]" )
	WebElement singElement;
	@FindBy(css =".column [href=\"/en_US/register\"]" )
	WebElement createAccountBtnElement;
	@FindBy(css ="a.ui.right.floated.button:nth-child(6)" )
	WebElement forgotPassBtn;

	public AuthenticationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void login(String email,String password) {
		fillText(userElement, email);
		fillText(passwordElement,password);
		click(singElement);
	}

}
