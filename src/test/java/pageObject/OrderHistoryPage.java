package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

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
	}

	// show order from list
	@Step("choose order: {0}")
	public void chooseOrder(String name) {
		for (WebElement el : showOrderList) {
			if (el.getAttribute("href").contains(name)) {
				click(el);
				sleep(3000);
				break;
			}
		}
	}

	// Validation
	// Get status of the order
	public String getStatus() {
		return getT(statElements);
	}

}
