package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProductPage;
import pageObject.ProductsPage;

@Epic("products page")
public class SearchProductTest extends BaseTest {

	private String product1 = "Summer tunic";
	private String product2 = "Tshirt";

	@Severity(SeverityLevel.MINOR)
	@Feature("search")
	@Description("search for existing item in the product page")
	@Test(description = "search for existing item in the product page")
	public void tc_24_SearchExistingItem() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickDressCategory();
		ProductsPage products = new ProductsPage(driver);
		products.search(product1);
		String actual = products.checkItmeName();
		String expected = product1;
		assertEquals(actual, expected);
		mainPage.goHomePage();
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("search")
	@Description("search for non existing item in the product page")
	@Test(description = "search for non existing item in the product page")
	public void tc_25_SearchNonExistingItem() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickDressCategory();
		ProductsPage products = new ProductsPage(driver);
		products.search(product2);
		String actual = products.getSearchInfoMsg();
		String expected = "There are no results to display";
		assertEquals(actual, expected);
	}

}
