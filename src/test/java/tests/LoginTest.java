package tests;

import static org.testng.Assert.assertEquals;

import org.apache.tools.ant.taskdefs.Sleep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.MainPage;

public class LoginTest extends BaseTest {

	MainPage mainPage;
	LoginPage loginPage;
	String user = "fashion@example.com";
	String password = "sylius";

	@BeforeMethod
	public void goToLoginPage() {
		mainPage = new MainPage(driver);
		mainPage.clicksignIn();
		loginPage = new LoginPage(driver);

	}

	@Test(description = "Login with valid Data")
	public void tc_05_valid() {
		loginPage.login(user, password);
		String actual = mainPage.getUserName();
		String expectd = "Hello";
		assertEquals(actual, expectd);
		mainPage = new MainPage(driver);
		mainPage.LogOut();

	}

	@Test(dataProvider = "getData", description = "Login with invalid user name")
	public void tc_06_inValidUser(String invalidUser, String invalidPassword) {
		loginPage.login(invalidUser, invalidPassword);
		String actual = loginPage.getError();
		String expectd = "Invalid credentials.";
		assertEquals(actual, expectd);

	}

	@Test(description = "Login with invalid password")
	public void tc_07_inValidPass() {
		loginPage.login("fashion@example.com", "ylius");
		String actual = loginPage.getError();
		String expectd = "Invalid credentials.";
		assertEquals(actual, expectd);

	}

	@Test(description = "check login after page reload")
	public void tc_08_validReloadPage() {
		loginPage.login(user, password);
		driver.navigate().refresh();
		loginPage.sleep(2000);
		String actual = mainPage.getUserName();
		String expectd = "Hello";
		assertEquals(actual, expectd);
		mainPage = new MainPage(driver);
		mainPage.LogOut();
	}

	@Test(description = "Sing out after login")
	public void tc_09_validReloadPage() {
		loginPage.login(user, password);
		mainPage = new MainPage(driver);
		mainPage.LogOut();
		String actual = mainPage.checkLogOut();
		String expectd = "Login";
		assertEquals(actual, expectd);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "@example.com", "sylius" }, { "gal", "123" }, { "", "" }, { "!", "===" }, };
		return myData;

	}

}
