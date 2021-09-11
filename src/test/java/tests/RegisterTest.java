package tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.MainPage;
import pageObject.RegisterPage;

@Epic("Login and Sign up")
public class RegisterTest extends BaseTest {
	private Random rand = new Random();

	@Severity(SeverityLevel.BLOCKER)
	@Feature("Verify the sign up funcionality")
	@Description("Register with valid Data,unused email")
	@Test(description = "Sign up- valid unused email")
	public void tc_01_valid() {
		int versionNumber = rand.nextInt(10000);
		String email = "b" + versionNumber + "@gmail.com";
		MainPage mainPage = new MainPage(driver);
		mainPage.clickRegister();
		RegisterPage register = new RegisterPage(driver);
		register.register("beni", "kun", email, "05212345", "12345", "12345");
		String actual = register.getGeneralMsg();
		String expected = "Thank you for registering, check your email to verify your account.";
		assertEquals(actual, expected);

	}

	@Severity(SeverityLevel.BLOCKER)
	@Feature("Verify the sign up funcionality")
	@Description("Register with invalid Data,used email")
	@Test(description = "Register with Already used email address")
	public void tc_03_RegisterUsedEmail() {
		String email = "fashion@example.com";
		MainPage mainPage = new MainPage(driver);
		mainPage.clickRegister();
		RegisterPage register = new RegisterPage(driver);
		register.register("beni", "kun", email, "05212345", "12345", "12345");
		String actual = register.getemailAlert();
		String expected = "This email is already used.";
		assertEquals(actual, expected);

	}
}
