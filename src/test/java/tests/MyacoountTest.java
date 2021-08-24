package tests;

import static org.testng.Assert.assertEquals;

import org.apache.commons.math3.analysis.function.Min;
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
	String username = "b@gmail.com";
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
		dashboard.changePass();
		changePassword.changePass(newPassword, password, password);
		mainPage.LogOut();

	}

	@Test(description = "check change password - invalid")
	public void tc_29_changePassInvalid() {
		mainPage.clickMyacount();
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.changePass();
		ChangePassPage changePassword = new ChangePassPage(driver);
		changePassword.changePass(newPassword, newPassword, newPassword);
		String actual = changePassword.getcurrentPassErr();
		String expected = "Provided password is different than the current one.";
		assertEquals(actual, expected);
		mainPage.LogOut();
	}
}
