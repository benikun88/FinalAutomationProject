package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends MenuPage {

	@FindBy(css = "#sylius_contact_email")
	WebElement contactEmailElement;
	@FindBy(css = "#sylius_contact_message")
	WebElement contactMsgElement;
	@FindBy(css = ".submit.button")
	WebElement sendBtn;
	@FindBy(css = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/p[1]")
	WebElement alertMsg;

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Send message to support
	public void sendMsg(String email, String msg) {
		fillText(contactEmailElement, email);
		fillText(contactMsgElement, msg);
		click(sendBtn);
	}

	// Validate
	// Check the message if success send
	public String getMsgContactPage() {
		return getT(alertMsg);
	}
}
