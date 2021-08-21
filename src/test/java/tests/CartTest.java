package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProductPage;

public class CartTest extends BaseTest {

	@Test(description = "add product to cart")
	public void tc_14_addToCart() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product=new ProductPage(driver);
		product.addDress("M","Regular", "1");
		CartPage cart=new CartPage(driver);
		boolean actual = cart.checkItemExist("Sleeveless Dress");
		boolean expectd = true;
		assertEquals(actual, expectd);
		cart.removeItem("Sleeveless Dress");
		
	}
	@Test(description = "Remove product from cart")
	public void tc_15_removeFromCart() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product=new ProductPage(driver);
		product.addDress("M","Regular", "1");
		CartPage cart=new CartPage(driver);
		cart.removeItem("Sleeveless Dress");
		String actual = cart.getcartMsg();
		String expectd = "Item has been removed from cart";
		assertEquals(actual, expectd);
		
	}
	@Test(description = "Empty cart")
	public void tc_16_emptyCart() {
		MainPage mainP=new MainPage(driver);
		mainP.chooseProduct("Regular Fit V-neck woman");
		ProductPage pro=new ProductPage(driver);
		pro.addShirt("S","1");
		pro.goHomePage();
		mainP=new MainPage(driver);
		mainP.chooseProduct("Sleeveless Dress");
		pro=new ProductPage(driver);
		pro.addDress("S","Tall","1");
		CartPage cart=new CartPage(driver);
		cart.clearCart();
		String actual = cart.getInfoCart();
		String expectd = "Your cart is empty";
		assertEquals(actual, expectd);
		
	}
}
