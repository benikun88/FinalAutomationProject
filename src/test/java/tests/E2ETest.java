package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.math3.analysis.function.Add;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.AdressessPage;
import pageObject.CartPage;
import pageObject.CompleteOrderPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PaymentPage;
import pageObject.ProductPage;
import pageObject.ProductsPage;
import pageObject.ShippingPage;

@Epic("E2E")
public class E2ETest extends BaseTest {

	private MainPage mainPage;
	private ProductPage product;
	private LoginPage loginPage;
	private ProductsPage products;
	private String product1 = "Summer tunic";
	private String product2 = "Slim fit men";
	private String user = "fashion@example.com";
	private String password = "sylius";

	@Severity(SeverityLevel.BLOCKER)
	@Feature("Verify order flow")
	@Description("Choose product,add to cart and purcahse")
	@Test(description = "E2E Test")
	public void tc_15_E2E() {
		mainPage = new MainPage(driver);
		mainPage.clickSignIn();
		loginPage = new LoginPage(driver);
		loginPage.login(user, password);
		mainPage.clickDressCategory();
		products = new ProductsPage(driver);
		products.chooseProduct(product1);
		product = new ProductPage(driver);
		product.addDress("S", "Petite", "1");
		CartPage cart = new CartPage(driver);
		cart.clickCheckout();
		AdressessPage addPage = new AdressessPage(driver);
		addPage.fillAddress("John", "Dow", "the street", "United States", "New York", "311988");
		ShippingPage shipMethod = new ShippingPage(driver);
		shipMethod.chooseShipping("FedEx");
		PaymentPage payment = new PaymentPage(driver);
		payment.choosePayMethod("Bank transfer");
		CompleteOrderPage coplOrder = new CompleteOrderPage(driver);
		coplOrder.placeOrder();
		String actual = coplOrder.checkOrderSuccess();
		String expected = "You have successfully placed an order.";
		assertEquals(actual, expected);
	}
}
