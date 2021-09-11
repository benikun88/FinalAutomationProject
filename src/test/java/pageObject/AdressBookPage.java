package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdressBookPage extends MyAcountPage {

	@FindBy(css = ".plus.icon")
	WebElement addAdressBtn;
	@FindBy(css = ".column address:nth-child(1) > strong:nth-child(1)")
	List<WebElement> AddresList;

	public AdressBookPage(WebDriver driver) {
		super(driver);
	}

	// click on the button to Add address to the book
	public void addAdress() {
		click(addAdressBtn);
	}

}
