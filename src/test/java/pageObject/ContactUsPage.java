package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends MenuPage{
	
	
	@FindBy(css="#sylius_contact_email") 
	WebElement emailElement;
	@FindBy(css="#sylius_contact_message") 
	WebElement messagElement;
	@FindBy(css=".submit.button") 
	WebElement sendBtn;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
