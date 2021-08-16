package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassPage extends MyAcountPage{
	
	@FindBy(css ="[href=\"/en_US/account/address-book/add\"] .plus " )
	WebElement addAddresBtn;
	@FindBy(css =".column address:nth-child(1) > strong:nth-child(1)" )
	List<WebElement> AddresList;
	

	public ChangePassPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
