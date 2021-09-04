package tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import pageObject.MainPage;
import pageObject.RegisterPage;

public class RegisterTest extends BaseTest {
	Random rand = new Random();

	@Test(description = "Register with valid Data")
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
