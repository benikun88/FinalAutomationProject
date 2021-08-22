package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObject.ContactUsPage;
import pageObject.LoginPage;
import pageObject.MainPage;

public class ContactUsTest extends BaseTest {

	@Test(description = "send message to support")
	public void tc_12_sendMsg() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickConnectUs();
		ContactUsPage connect = new ContactUsPage(driver);
		connect.sendMsg("fashion@example.com", "test");
		String actual = connect.getMsg();
		String expectd = "Your contact request has been submitted successfully.";
		assertEquals(actual, expectd);
	}

	@Test(description = "send message to support")
	public void tc_13_sendMsg() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickConnectUs();
		ContactUsPage connect = new ContactUsPage(driver);
		connect.sendMsg("dummy.com", "test");
		String actual = connect.getMsgAlert();
		String expectd = "This email is invalid.";
		assertEquals(actual, expectd);
	}

	@Test(description = "send message to support")
	public void tc_14_sendMsg() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickConnectUs();
		ContactUsPage connect = new ContactUsPage(driver);
		connect.sendMsg("fashion@example.com", "");
		String actual = connect.getMsgAlert();
		String expectd = "Please enter your message.";
		assertEquals(actual, expectd);
	}

}
