package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdessBookPage extends MyAcountPage{
	
	@FindBy(css =".plus.icon" )
	WebElement addAdressElement;
	@FindBy(css =".column address:nth-child(1) > strong:nth-child(1)" )
	List<WebElement> AddresList;

	public AdessBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
