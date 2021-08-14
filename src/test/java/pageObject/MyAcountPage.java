package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcountPage extends MenuPage{
	@FindBy(css=".home")
	WebElement dashboardTab;
	@FindBy(css=".user")
	WebElement personalInfoTab; 	
	@FindBy(css=".lock") 
	WebElement chnagePassTab;
	@FindBy(css=".book")
	WebElement adressTab;
	@FindBy(css=".vertical.menu .icon.cart")
	WebElement orderHistoryTab;
	@FindBy(css=".item .gift")
	WebElement loyaltyTab; 

	public MyAcountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
