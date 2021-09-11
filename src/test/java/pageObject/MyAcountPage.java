package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcountPage extends MenuPage {
	@FindBy(css = ".home")
	WebElement dashboardTab;
	@FindBy(css = ".user")
	WebElement personalInfoTab;
	@FindBy(css = ".lock")
	WebElement chnagePassTab;
	@FindBy(css = ".book")
	WebElement adressTab;
	@FindBy(css = ".vertical.menu .icon.cart")
	WebElement orderHistoryTab;
	@FindBy(css = ".item .gift")
	WebElement loyaltyTab;
	@FindBy(css = ".sylius-flash-message p")
	WebElement messageElement;

	public MyAcountPage(WebDriver driver) {
		super(driver);
	}

	// Press on personal info tab in my account
	public void clickPersonalInfoTab() {
		click(personalInfoTab);
	}

	// validation
	// Get message 
	public String getMsg() {
		return getT(messageElement);
	}

}
