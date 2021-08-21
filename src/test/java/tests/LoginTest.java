package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.MainPage;

public class LoginTest extends BaseTest{
	
//	String actual=pP.getCartAmount();
//	String expected="2";
//	Assert.assertEquals(actual, expected);
	
	@Test(description = "Login with valid Data")
	public void tc_05_valid() {
		MainPage mainPage=new MainPage(driver);
		mainPage.clicksignIn();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("fashion@example.com", "sylius");
		String actual=mainPage.getUserName();
		String expectd="Hello Ben Cohen!";
		assertEquals(actual, expectd);
		mainPage=new MainPage(driver);
		mainPage.LogOut();
			
	}
	@Test(description = "Login with invalid user name")
	public void tc_06_inValidUser() {
		MainPage mainPage=new MainPage(driver);
		mainPage.clicksignIn();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("@example.com", "sylius");
		String actual=loginPage.getError();
		String expectd="Invalid credentials.";
		assertEquals(actual, expectd);
		
	}
	@Test(description = "Login with invalid password")
	public void tc_07_inValidPass() {
		MainPage mainPage=new MainPage(driver);
		mainPage.clicksignIn();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("fashion@example.com", "ylius");
		String actual=loginPage.getError();
		String expectd="Invalid credentials.";
		assertEquals(actual, expectd);
		
	}
	@Test(description = "check login after page reload")
	public void tc_08_validReloadPage() {
		MainPage mainPage=new MainPage(driver);
		mainPage.clicksignIn();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("fashion@example.com", "sylius");
		driver.navigate().refresh();
		String actual=mainPage.getUserName();
		String expectd="Hello Ben Cohen!";
		assertEquals(actual, expectd);
		mainPage=new MainPage(driver);
		mainPage.LogOut();
	}
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

	