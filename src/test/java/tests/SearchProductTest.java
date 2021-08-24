package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProductPage;
import pageObject.ProductsPage;

public class SearchProductTest extends BaseTest {

	String product1 = "Summer tunic";
	String product2 = "Tshirt";

	@Test(description = "search for existing item in the product page")
	public void tc_24_SearchExistingItem() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickDressCategory();
		ProductsPage products = new ProductsPage(driver);
		products.search(product1);
		String actual = products.checkItmeName();
		String expectd = product1;
		assertEquals(actual, expectd);
		mainPage.goHomePage();
	}

	@Test(description = "search for non existing item in the product page")
	public void tc_25_SearchNonExistingItem() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickDressCategory();
		ProductsPage products = new ProductsPage(driver);
		products.search(product2);
		String actual = products.getSearchInfo();
		String expectd = "There are no results to display";
		assertEquals(actual, expectd);
	}

}
