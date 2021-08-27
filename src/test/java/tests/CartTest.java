package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.math3.util.Precision;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProductPage;

public class CartTest extends BaseTest {

	MainPage mainPage;
	ProductPage product;
	String product1 = "Slim fit V-neck men";
	String product2 = "Slim fit men";

	@BeforeMethod
	public void choooseProduct() {
		mainPage = new MainPage(driver);
		mainPage.chooseProduct(product1);
		product = new ProductPage(driver);
		product.addShirt("S", "1");
	}

	@Test(description = "add product to cart")
	public void tc_15_addToCart() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Slim fit V-neck men");
//		ProductPage product = new ProductPage(driver);
//		product.addShirt("M", "1");
		CartPage cart = new CartPage(driver);
		boolean actual = cart.checkItemExist(product1);
//		boolean expectd = true;
		assertTrue(actual);
		cart.removeItem(product1);
		cart.goHomePage();

	}

	@Test(description = "Remove product from cart")
	public void tc_16_removeFromCart() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Slim fit V-neck men");
//		ProductPage product = new ProductPage(driver);
//		product.addShirt("M", "1");
		CartPage cart = new CartPage(driver);
		cart.removeItem(product1);
		String actual = cart.getcartMsg();
		String expectd = "Item has been removed from cart";
		assertEquals(actual, expectd);
		cart.goHomePage();

	}

	@Test(description = "Empty cart")
	public void tc_17_emptyCart() {
//		MainPage mainP = new MainPage(driver);
//		mainP.chooseProduct("Regular Fit V-neck woman");
//		ProductPage product = new ProductPage(driver);
//		pro.addShirt("S", "1");
		product.goHomePage();
		mainPage = new MainPage(driver);
		mainPage.chooseProduct(product2);
		product = new ProductPage(driver);
		product.addShirt("M", "1");
		CartPage cart = new CartPage(driver);
		cart.clearCart();
		String actual = cart.getInfoCart();
		String expectd = "Your cart is empty";
		assertEquals(actual, expectd);
		cart.goHomePage();

	}

	@Test(description = "update cart")
	public void tc_18_updateCart() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Sleeveless Dress");
//		ProductPage product = new ProductPage(driver);
//		product.addDress("M", "Regular", "1");
		CartPage cart = new CartPage(driver);
		cart.changeQuantity("2");
		double actual = cart.getTotalprice();
		double expectd = cart.getUnitPrice() * 2;
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();

	}

	@Test(description = "apply valid coupon")
	public void tc_19_applyCoupon() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Sleeveless Dress");
//		ProductPage product = new ProductPage(driver);
//		product.addDress("M", "Regular", "1");
		CartPage cart = new CartPage(driver);
		double discount = cart.getTotalprice() * 0.10;
		double expectd = cart.getTotalpriceShip() - discount;
		expectd = Precision.round(expectd, 2);
		cart.applyCoupon("testCP");
		double actual = cart.getTotalpriceShip();
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

	@Test(description = "apply invalid coupon")
	public void tc_20_applyInvalidCoupon() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Sleeveless Dress");
//		ProductPage product = new ProductPage(driver);
//		product.addDress("M", "Regular", "1");
		CartPage cart = new CartPage(driver);
		cart.applyCoupon("test");
		String actual = cart.getCpnErr();
		String expectd = "Coupon code is invalid.";
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

	@Test(description = "update out of stock quantity-error")
	public void tc_21_updateOutOfStockToCart() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Sleeveless Dress");
//		ProductPage product = new ProductPage(driver);
//		product.addDress("S", "Petite", "1");
		CartPage cart = new CartPage(driver);
		cart.changeQuantity("5");
		String actual = cart.getstockErr();
		String expectd = "S does not have sufficient stock.";
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

	@Test(description = "add out of stock quantity-total price check")
	public void tc_22_updateOutOfStockToCart() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Sleeveless Dress");
//		ProductPage product = new ProductPage(driver);
//		product.addDress("S", "Petite", "1");
		CartPage cart = new CartPage(driver);
		double expectd = cart.getTotalprice();
		cart.changeQuantity("5");
		double actual = cart.getTotalprice();
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

}
