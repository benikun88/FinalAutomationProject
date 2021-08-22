package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.MainPage;

public class SearchProductTest extends BaseTest{
	@Test(description = "Sing out after login")
	public void tc_09_validReloadPage() {
		MainPage mainPage=new MainPage(driver);
		mainPage.clicksignIn();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("fashion@example.com", "sylius");
		mainPage=new MainPage(driver);
		mainPage.LogOut();
		String actual=mainPage.checkLogOut();
		String expectd="Login";
		assertEquals(actual, expectd);
	}

}
