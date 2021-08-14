	package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{
	@FindBy(css=".ui.dropdown.item:nth-child(1)")
	WebElement tshirtDropBtn;
	@FindBy(css=".ui.dropdown.item:nth-child(2)")
	WebElement capsDropBtn;
	@FindBy(css=".ui.dropdown.item:nth-child(3)")
	WebElement jeansDropBtn;
	@FindBy(css=".menu:nth-child(3) > a.item:nth-child(3)")
	WebElement dressBtn; 	
	@FindBy(css ="#sylius-cart-total" )
	WebElement cartTotalElement;
	@FindBy(css = ".button-search")
	WebElement serachBtn;
	@FindBy(css = "#sylius-cart-button")
	WebElement cartBtn;
	@FindBy(css = ".cart .ui.fluid.primary.button")
	WebElement checkOutBtn;
	@FindBy(css = ".text.button:nth-child(2)")
	WebElement editcartBtn;
	@FindBy(css ="[href=\"/en_US/login\"]" )
	WebElement loginBtn;
	@FindBy(css =".ui.right.stackable.inverted.menu [href=\"/en_US/register\"]" )
	WebElement registerBtn;
	@FindBy(css = ".sylius-logout-button")
	WebElement logOutBtn;
	@FindBy(css = ".inverted.menu > a.item:nth-child(2)")
	WebElement myAcountBtn;
	@FindBy(css = ".inverted.menu > div.item:nth-child(1)")
	WebElement usernamElement;
	@FindBy(css = ".menu.transition.visible .item")
	WebElement barlist;
	@FindBy(css = ".column:nth-child(3) div.ui.inverted.link.list:nth-child(2) > a.item:nth-child(1)")
	WebElement contactUsBtn;
	@FindBy(css = "#Logo")
	WebElement homepageBtn;
	

	public MenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void pressSearch() {
		click(serachBtn);
	}
	public void enterCart() {
		click(cartBtn);
	}
	public void signIn() {
		if (isExist(loginBtn)) {
			click(loginBtn);
			sleep(2000);
		}
	}	
	public void singout() {
		if (isExist(loginBtn)) {
			click(logOutBtn);
		}
	}
	
	public void goHomePage() {
		click(homepageBtn);
	}
	

}
