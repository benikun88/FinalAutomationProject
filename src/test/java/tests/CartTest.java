package tests;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import org.apache.commons.math3.util.Precision;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.CartPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProductPage;
import pageObject.ProductsPage;

@Epic("Shopping Cart")
public class CartTest extends BaseTest {

	private MainPage mainPage;
	private ProductPage product;
	private ProductsPage products;
	private String product1 = "Summer tunic";
	private String product2 = "Slim fit men";
	private String coupon = "AC";

	@BeforeMethod
	public void choooseProduct() {
		mainPage = new MainPage(driver);
		mainPage.clickDressCategory();
		products = new ProductsPage(driver);
		products.chooseProduct(product1);
		product = new ProductPage(driver);
		product.addDress("S", "Petite", "1");
	}

	@Feature("Verify the add/remove from cart functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Add product to cart and check if exist in cart,after that clean cart and return to home page")
	@Test(description = "Add product to cart")
	public void tc_15_addToCart() {
		CartPage cart = new CartPage(driver);
		boolean actual = cart.checkItemExist(product1);
		assertTrue(actual);
		cart.removeItem(product1);
		cart.goHomePage();

	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Verify the add/remove from cart functionality")
	@Description("Add product to cart and check if exist in cart,after that clean cart and return to home page")
	@Test(description = "Remove product from cart")
	public void tc_16_removeFromCart() {

		CartPage cart = new CartPage(driver);
		cart.removeItem(product1);
		String actual = cart.getcartMsg();
		String expectd = "Item has been removed from cart";
		assertEquals(actual, expectd);
		cart.goHomePage();

	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Verify the add/remove from cart functionality")
	@Description("Add product to cart clean cart and check it empty")
	@Test(description = "Empty cart")
	public void tc_17_emptyCart() {

		product.goHomePage();
		mainPage = new MainPage(driver);
		mainPage.chooseProduct(product2);
		product = new ProductPage(driver);
		product.addShirt("S", "1");
		CartPage cart = new CartPage(driver);
		cart.clearCart();
		String actual = cart.getInfoCart();
		String expectd = "Your cart is empty";
		assertEquals(actual, expectd);
		cart.goHomePage();

	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("cart update")
	@Description("Add product to cart,change the Quantity , and check if price has change")
	@Test(description = "update cart")
	public void tc_18_updateCart() {
		CartPage cart = new CartPage(driver);
		cart.changeQuantity("2");
		double actual = cart.getTotalprice();
		double expectd = cart.getUnitPrice() * 2;
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();

	}

	@Severity(SeverityLevel.MINOR)
	@Feature("cart update")
	@Description("Add product to cart,apply valid copun, and check if price has change")
	@Test(description = "apply valid coupon")
	public void tc_19_applyCoupon() {
		CartPage cart = new CartPage(driver);
		double discount = cart.getTotalprice() * 0.10;
		double expectd = cart.getTotalpriceShip() - discount;
		expectd = Precision.round(expectd, 2);
		cart.applyCoupon(coupon);
		double actual = cart.getTotalpriceShip();
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("cart update")
	@Description("Add product to cart,apply invalid copun, and check if price hasent change")
	@Test(description = "apply invalid coupon")
	public void tc_20_applyInvalidCoupon() {
		CartPage cart = new CartPage(driver);
		cart.applyCoupon("test");
		String actual = cart.getCpnErr();
		String expectd = "Coupon code is invalid.";
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Feature("cart update")
	@Description("Add product to cart,change Quantity to 99 and check if there is out of stock alert")
	@Test(description = "add to cart unavilale quantity-error check")

	public void tc_21_updateOutOfStockToCart() {
		CartPage cart = new CartPage(driver);
		cart.changeQuantity("99");
		String actual = cart.getstockErr();
		String expectd = "S Petite does not have sufficient stock.";
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

	@Severity(SeverityLevel.NORMAL)
	@Feature("cart update")
	@Description("Add product to cart with Quantity of 99 and check if there is out of stock alert ")
	@Test(description = "add to cart unavilale quantity-total price")

	public void tc_22_updateOutOfStockToCart() {
		CartPage cart = new CartPage(driver);
		double expectd = cart.getTotalprice();
		cart.changeQuantity("99");
		double actual = cart.getTotalprice();
		assertEquals(actual, expectd);
		cart.clearCart();
		cart.goHomePage();
	}

}
