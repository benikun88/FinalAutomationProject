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
import pageObject.ProductsPage;
import pageObject.ShippingPage;

public class E2ETest extends BaseTest {

	MainPage mainPage;
	ProductPage product;
	LoginPage loginPage;
	ProductsPage products;
	String product1 = "Summer tunic";
	String product2 = "Slim fit men";
	String user = "fashion@example.com";
	String password = "sylius";

	@Test(description = "E2E Test")
	public void tc_15_E2E() {
		mainPage = new MainPage(driver);
		mainPage.clicksignIn();
		loginPage = new LoginPage(driver);
		loginPage.login(user, password);
		mainPage.clickDressCategory();
		products=new ProductsPage(driver);
		products.chooseProduct(product1);
		product = new ProductPage(driver);
		product.addDress("S","Petite", "1");
		CartPage cart = new CartPage(driver);
		cart.clickCheckout();
		AdressessPage addPage = new AdressessPage(driver);
		addPage.fillAddress("John", "Dow", "the street", "United States", "New York", "311988");
		ShippingPage shipMethod = new ShippingPage(driver);
		shipMethod.chooseshipping("FedEx");
		PaymentPage payment = new PaymentPage(driver);
		payment.choosePayMethod("Bank transfer");
		CompleteOrderPage coplOrder = new CompleteOrderPage(driver);
		coplOrder.placeOrder();
		String actual = coplOrder.checkOrderSuccess();
		String expectd = "You have successfully placed an order.";
		assertEquals(actual, expectd);

	}

}
