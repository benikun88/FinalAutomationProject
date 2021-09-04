package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.ContactUsPage;
import pageObject.LoginPage;
import pageObject.MainPage;

public class ContactUsTest extends BaseTest {

	MainPage mainPage;
	ContactUsPage connect;

	@BeforeMethod
	public void goToLoginPage() {
		mainPage = new MainPage(driver);
		mainPage.clickConnectUs();
		connect = new ContactUsPage(driver);
	}

	@Test(description = "send message to support")
	public void tc_12_sendMsg() {
		connect.sendMsg("fashion@example.com", "test");
		String actual = connect.getMsg();
		String expectd = "Your contact request has been submitted successfully.";
		assertEquals(actual, expectd);
	}

	@Test(description = "send message to support")
	public void tc_13_sendMsg() {
		connect.sendMsg("dummy.com", "test");
		String actual = connect.getMsgAlert();
		String expectd = "This email is invalid.";
		assertEquals(actual, expectd);
	}

	@Test(description = "send message to support")
	public void tc_14_sendMsg() {
		connect.sendMsg("fashion@example.com", "");
		String actual = connect.getMsgAlert();
		String expectd = "Please enter your message.";
		assertEquals(actual, expectd);
	}

}
