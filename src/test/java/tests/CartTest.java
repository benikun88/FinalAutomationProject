package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.math3.util.Precision;
import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProductPage;

public class CartTest extends BaseTest {

	@Test(description = "add product to cart")
	public void tc_15_addToCart() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product = new ProductPage(driver);
		product.addDress("M", "Regular", "1");
		CartPage cart = new CartPage(driver);
		boolean actual = cart.checkItemExist("Sleeveless Dress");
		boolean expectd = true;
		assertEquals(actual, expectd);
		cart.removeItem("Sleeveless Dress");
		cart.goHomePage();

	}
	@Test(description = "Remove product from cart")
	public void tc_16_removeFromCart() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product=new ProductPage(driver);
		product.addDress("M","Regular", "1");
		CartPage cart=new CartPage(driver);
		cart.removeItem("Sleeveless Dress");
		String actual = cart.getcartMsg();
		String expectd = "Item has been removed from cart";
		assertEquals(actual, expectd);
		cart.goHomePage();

		
	}
	@Test(description = "Empty cart")
	public void tc_17_emptyCart() {
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
		cart.goHomePage();

		
	}
	
	@Test(description = "update cart")
	public void tc_18_updateCart() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product = new ProductPage(driver);
		product.addDress("M", "Regular", "1");
		CartPage cart = new CartPage(driver);
		cart.changeQuantity("2");
		double actual =cart.getTotalprice();
		double expectd =cart.getUnitPrice()*2;
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();

	}
	@Test(description = "apply valid coupon")
	public void tc_19_applyCoupon() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product = new ProductPage(driver);
		product.addDress("M", "Regular", "1");
		CartPage cart = new CartPage(driver);
		double discount=cart.getTotalprice()*0.10;
		double expectd =cart.getTotalpriceShip()-discount;
		expectd=Precision.round(expectd, 2);
		cart.applyCoupon("test8Dselenium");
		double actual =cart.getTotalpriceShip();
		assertEquals(actual, expectd);
	}
	@Test(description = "apply invalid coupon")
	public void tc_20_applyInvalidCoupon() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product = new ProductPage(driver);
		product.addDress("M", "Regular", "1");
		CartPage cart = new CartPage(driver);
		cart.applyCoupon("test");
		String actual=cart.getCpnErr();
		String expectd="Coupon code is invalid.";
		assertEquals(actual, expectd);
	}
	@Test(description = "update out of stock quantity-error")
	public void tc_21_updateOutOfStockToCart() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product = new ProductPage(driver);
		product.addDress("S", "Petite", "1");
		CartPage cart = new CartPage(driver);
		cart.changeQuantity("3");
		String actual=cart.getstockErr();
		String expectd="S Petite does not have sufficient stock.";
		assertEquals(actual, expectd);
	}
	@Test(description = "update out of stock quantity-total price")
	public void tc_22_updateOutOfStockToCart() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseProduct("Sleeveless Dress");
		ProductPage product = new ProductPage(driver);
		product.addDress("S", "Petite", "1");
		CartPage cart = new CartPage(driver);
		double expectd=cart.getTotalprice();
		cart.changeQuantity("3");
		double actual=cart.getTotalprice();;
		assertEquals(actual, expectd);
	}
	
}
