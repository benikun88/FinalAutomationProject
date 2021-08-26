package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css = "div.ui.large.stackable.menu:nth-child(3) .ui ,[href=\"/en_US/taxons/category/dresses\"]")
	List<WebElement> levelOnetopBarList;
	@FindBy(css = "div.ui.large.stackable.menu:nth-child(3) .ui a")
	List<WebElement> levelTwotopBarList;
	@FindBy(css = ".ui.dropdown.item:nth-child(4)")
	WebElement tshirtDropBtn;
	@FindBy(css = ".ui.dropdown.item:nth-child(2)")
	WebElement capsDropBtn;
	@FindBy(css = ".ui.dropdown.item:nth-child(3)")
	WebElement jeansDropBtn;
	@FindBy(css = ".stackable.menu:nth-child(3) > a.item:nth-child(2)")
	WebElement dressBtn;
	@FindBy(css = "#sylius-cart-total")
	WebElement cartTotalElement;
	@FindBy(css = "#sylius-cart-button")
	WebElement cartBtn;
	@FindBy(css = ".cart .ui.fluid.primary.button")
	WebElement checkOutBtnTop;
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
	WebElement homePageBtn;
	@FindBy(css = ".ui.large.flowing.cart.popup.left.center.transition.visible")
	WebElement cartEmptyMsgTopBar;
	@FindBy(css = ".message.sylius-flash-message:nth-child(2) div p")
	WebElement generalMsg;
	@FindBy(css = ".message.sylius-flash-message:nth-child(3) div p")
	WebElement generalSecondMsg;

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	// Click on the cart button on the header
	public void clickCart() {
		click(cartBtn);
		sleep(2000);
	}

	// Click Login button
	public void clicksignIn() {
		if (isExist(loginBtn)) {
			click(loginBtn);
			sleep(2000);
		}
	}

	// Click my account
	public void clickMyacount() {
		if (isExist(myAcountBtn)) {
			click(myAcountBtn);
			sleep(2000);
		}
	}

	// Press logout
	public void LogOut() {
		click(logOutBtn);
		sleep(2500);

	}

	// Go to home page
	public void goHomePage() {
		click(homePageBtn);
	}

	// Go to register page
	public void clickRegister() {
		click(registerBtn);
	}

	// Go to cart page
	public void editCart() {
		clickCart();
		click(editcartBtn);
	}

	// Go to checkout page
	public void enterCheckout() {
		clickCart();
		click(checkOutBtnTop);
	}

	// Click on connect us
	public void clickConnectUs() {
		click(contactUsBtn);

	}
	// Click on dress menu
	public void clickDressCategory() {
		click(dressBtn);
		
	}

	// Validate
	// Check the number of items in the cart
	public String checkNumOfItems() {
		return getT(cartBtn);
	}

	public String checkCartTotal() {
		return getT(cartTotalElement);
	}

	public String getGeneralMsg() {
		return getT(generalMsg);
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
