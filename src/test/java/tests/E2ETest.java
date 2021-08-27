package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.math3.analysis.function.Add;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.AdressessPage;
import pageObject.CartPage;
import pageObject.CompleteOrderPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PaymentPage;
import pageObject.ProductPage;
import pageObject.ShippingPage;

public class E2ETest extends BaseTest {

	MainPage mainPage;
	ProductPage product;
	LoginPage loginPage;
	String product1 = "Slim fit V-neck men";
	String product2 = "Slim fit men";
	String user = "fashion@example.com";
	String password = "sylius";

//	@BeforeMethod
//	public void choooseProduct() {
//		mainPage = new MainPage(driver);
//		mainPage.clicksignIn();
//		loginPage = new LoginPage(driver);
//		mainPage = new MainPage(driver);
//		mainPage.chooseProduct(product1);
//		product = new ProductPage(driver);
//		product.addShirt("S", "1");
//	}

	@Test(description = "E2E Test")
	public void tc_15_E2E() {
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseProduct("Slim fit V-neck men");
//		ProductPage product = new ProductPage(driver);
//		product.addShirt("M", "1");
		mainPage = new MainPage(driver);
		mainPage.clicksignIn();
		loginPage = new LoginPage(driver);
		loginPage.login(user, password);
		mainPage.chooseProduct(product1);		
		product = new ProductPage(driver);
		product.addShirt("XL", "1");
		CartPage cart = new CartPage(driver);
		cart.clickCheckout();
		AdressessPage addPage=new AdressessPage(driver);
		addPage.fillAddress("John", "Dow", "the street", "United States","New York", "311988");
		ShippingPage shipMethod=new ShippingPage(driver);
		shipMethod.chooseshipping("FedEx");
		PaymentPage payment=new PaymentPage(driver);
		payment.choosePayMethod("Cash on delivery");
		CompleteOrderPage coplOrder=new CompleteOrderPage(driver);
		coplOrder.placeOrder();
		String actual = coplOrder.checkOrderSuccess();
		String expectd = "You have successfully placed an order.";
		assertEquals(actual, expectd);

	}

}
