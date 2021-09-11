package tests;

import static org.testng.Assert.assertEquals;

import org.apache.commons.math3.analysis.function.Min;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.ChangePassPage;
import pageObject.ContactUsPage;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.MyAcountPage;

@Epic("My account")
public class MyAcountTest extends BaseTest {

	private MainPage mainPage;
	private LoginPage loginPage;
	private String username = "fashion@example.com";
	private String password = "sylius";
	private String newPassword = "12345";

	@BeforeMethod
	public void goToLoginPage() {
		mainPage = new MainPage(driver);
		mainPage.clicksignIn();
		loginPage = new LoginPage(driver);
		loginPage.login(username, password);

	}

	@Severity(SeverityLevel.NORMAL)
	@Feature("password change")
	@Description("change password with valid data")
	@Test(description = "check change password successfuly")
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

	@Severity(SeverityLevel.NORMAL)
	@Feature("password change")
	@Description("change password with invalid data")
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
