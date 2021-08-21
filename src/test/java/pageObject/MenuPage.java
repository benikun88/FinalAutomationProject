package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css = "div.ui.large.stackable.menu div,[href=\"/en_US/taxons/category/dresses\"]")
	List<WebElement> topBarList;
	@FindBy(css = ".ui.dropdown.item:nth-child(1)")
	WebElement tshirtDropBtn;
	@FindBy(css = ".ui.dropdown.item:nth-child(2)")
	WebElement capsDropBtn;
	@FindBy(css = ".ui.dropdown.item:nth-child(3)")
	WebElement jeansDropBtn;
	@FindBy(css = ".menu:nth-child(3) > a.item:nth-child(3)")
	WebElement dressBtn;
	@FindBy(css = "#sylius-cart-total")
	WebElement cartTotalElement;
	@FindBy(css = "#sylius-cart-button")
	WebElement cartBtn;
	@FindBy(css = ".cart .ui.fluid.primary.button")
	WebElement checkOutBtn;
	@FindBy(css = ".text.button:nth-child(2)")
	WebElement editcartBtn;
	@FindBy(css = "[href=\"/en_US/login\"]")
	WebElement loginBtn;
	@FindBy(css = ".ui.right.stackable.inverted.menu [href=\"/en_US/register\"]")
	WebElement registerBtn;
	@FindBy(css = ".sylius-logout-button")
	WebElement logOutBtn;
	@FindBy(css = ".inverted.menu > a.item:nth-child(2)")
	WebElement myAcountBtn;
	@FindBy(css = ".inverted.menu > div.item:nth-child(1)")
	WebElement userNamElement;
	@FindBy(css = ".menu.transition.visible .item")
	WebElement barlist;
	@FindBy(css = ".column:nth-child(3) div.ui.inverted.link.list:nth-child(2) > a.item:nth-child(1)")
	WebElement contactUsBtn;
	@FindBy(css = "#Logo")
	WebElement homepageBtn;
	@FindBy(css = ".ui.large.flowing.cart.popup.left.center.transition.visible")
	WebElement cartEmptyMsg;
	@FindBy(css = ".message.sylius-flash-message:nth-child(2) div p")
	WebElement generalMsg;
	@FindBy(css = ".message.sylius-flash-message:nth-child(3) div p")
	WebElement generalSecondMsg;

	public MenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickCart() {
		click(cartBtn);
		sleep(2000);
	}

	public void clicksignIn() {
		if (isExist(loginBtn)) {
			click(loginBtn);
			sleep(2000);
		}
	}

	public void clickMyacount() {
		if (isExist(myAcountBtn)) {
			click(myAcountBtn);
			sleep(2000);
		}
	}

	public void LogOut() {
			click(logOutBtn);
			sleep(2000);

	}

	public void goHomePage() {
		click(homepageBtn);
	}

	public void clickregister() {
		click(registerBtn);
	}

	public void editCart() {
		clickCart();
		click(editcartBtn);
	}

	public void enterCheckout() {
		clickCart();
		click(checkOutBtn);
	}
	public void clickConnectUs() {
		click(contactUsBtn);

	}
	
	

	// validate
	public String checkNumOfItems() {
		return getT(cartBtn);
	}

	public String checkCartTotal() {
		return getT(cartTotalElement);
	}

	public String getGeneralMsg() {
		return getT(cartTotalElement);
	}
	public String getUserName() {
		return getT(userNamElement);
	}
	public String checkLogOut() {
		return getT(logOutBtn);
	}
	
//	public void vrifyAcount() {
//		String str=getT(generalSecondMsg);
//		System.out.println(str.substring(0,2));
//	}

}
