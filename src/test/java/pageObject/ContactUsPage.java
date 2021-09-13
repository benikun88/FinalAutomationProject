package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ContactUsPage extends MenuPage {

	@FindBy(css = "#sylius_contact_email")
	WebElement emailElement;
	@FindBy(css = "#sylius_contact_message")
	WebElement messagFiledElement;
	@FindBy(css = ".submit.button")
	WebElement sendBtn;
	@FindBy(css = ".error:nth-child(1) > div.ui.red.pointing.label.sylius-validation-error")
	WebElement emailAlert;
	@FindBy(css = "div.ui.red.pointing.label.sylius-validation-error")
	WebElement msgAlert;
	@FindBy(css = ".message.sylius-flash-message:nth-child(2) div p")
	WebElement generalMsg;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Send message to costumer support
	@Step("Enter email: {0},and message {1}")
	public void sendMsg(String email, String msg) {
		fillText(emailElement, email);
		fillText(messagFiledElement, msg);
		click(sendBtn);
	}

	// Validation
	// Check the message if success send
	public String getMsg() {
		waitForVisibleOfElement(generalMsg);
		return getT(generalMsg);
	}

	// get error of the email field
	public String getEmailAlert() {
		waitForVisibleOfElement(emailAlert);
		return getT(emailAlert);
	}

	// get error of the message field
	public String getMsgAlert() {
		waitForVisibleOfElement(msgAlert);
		return getT(msgAlert);
	}

}
