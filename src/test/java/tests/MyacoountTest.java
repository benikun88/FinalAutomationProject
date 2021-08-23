package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.ChangePassPage;
import pageObject.ContactUsPage;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.MyAcountPage;

public class MyAcoountTest extends BaseTest {

	MainPage mainPage;
	LoginPage loginPage;
	String username = "b30@gmail.com";
	String password = "12345";
	String newPassword = "09876";

	@BeforeMethod
	public void goToLoginPage() {
		mainPage = new MainPage(driver);
		mainPage.clicksignIn();
		loginPage = new LoginPage(driver);
		loginPage.login(username, password);

	}

	@Test(description = "check change password succfuly")
	public void tc_29_changePass() {
		mainPage.clickMyacount();
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.changePass();
		ChangePassPage changePassword = new ChangePassPage(driver);
		changePassword.changePass(password, newPassword, newPassword);
		String actual = changePassword.getSuccesChangeMsg();
		String expected = "Your password has been changed successfully!";
		assertEquals(actual, expected);
		mainPage = new MainPage(driver);
		mainPage.LogOut();
	}
}
