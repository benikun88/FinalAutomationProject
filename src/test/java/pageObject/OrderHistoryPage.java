package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends MyAcountPage{
	
	@FindBy(css ="tbody:nth-child(2) tr.item:nth-child(1) > td:nth-child(1)" )
	WebElement orderNumElement;
	@FindBy(css ="tr.item:nth-child(1) > td:nth-child(2)" )
	WebElement orderDateElement;
	@FindBy(css ="tr.item:nth-child(1) > td:nth-child(3)" )
	WebElement shipToElement;
	@FindBy(css ="tr.item:nth-child(1) > td:nth-child(4)" )
	WebElement orderTotalElement;
	@FindBy(css ="tr.item:nth-child(1) td:nth-child(5) div.ui.header" )
	WebElement statElements;
	@FindBy(css ="table.ui.sortable.stackable.very.basic.celled.table tr.item:nth-child(1) td:nth-child(6) div.ui.buttons a.ui.labeled.icon.button:nth-child(1) > i.icon.search" )
	WebElement showOrderBtn;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
