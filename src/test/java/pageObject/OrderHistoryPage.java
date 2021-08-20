package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends MyAcountPage {

	@FindBy(css = "tbody:nth-child(2) tr.item:nth-child(1) > td:nth-child(1)")
	WebElement orderNumElement;
	@FindBy(css = "tr.item:nth-child(1) > td:nth-child(2)")
	WebElement orderDateElement;
	@FindBy(css = "tr.item:nth-child(1) > td:nth-child(3)")
	WebElement shipToElement;
	@FindBy(css = "tr.item:nth-child(1) > td:nth-child(4)")
	WebElement orderTotalElement;
	@FindBy(css = "tr.item:nth-child(1) td:nth-child(5) div.ui.header .ui")
	WebElement statElements;
	@FindBy(css = "td:nth-child(6) div.ui.buttons a:nth-child(1)")
	List<WebElement> showOrderList;
	@FindBy(css = "tr.item:nth-child(1) td:nth-child(6) div.ui.buttons")
	List<WebElement> showLastOrdweBtn;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void chooseProduct(String name) {
		for (WebElement el : showOrderList) {
			if (el.getAttribute("href").contains(name)) {
				click(el);
				sleep(3000);
				break;
			}
		}
	}

	// validation

	public String getStatus() {
		return getT(statElements);
	}

}
