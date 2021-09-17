package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.ContactUsPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import utils.DataProviders;

public class ContactUsTest extends BaseTest {

	private MainPage mainPage;
	private ContactUsPage connect;

	@BeforeMethod
	public void goToLoginPage() {
		mainPage = new MainPage(driver);
		mainPage.clickConnectUs();
		connect = new ContactUsPage(driver);
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("Customer support")
	@Description("send message to support and get input for succes or fail send")
	@Test(dataProviderClass = DataProviders.class, dataProvider = "contactUsData", description = "send message to support")
	public void tc_12_13__sendMsg(String user, String msg, String expectedMsg) {
		connect.sendMsg(user, msg);
		String actual = connect.getMsgAlert();
		String expected = expectedMsg;
		assertEquals(actual, expected);
	}

	@Test(description = "send message to support")
	public void tc_14_sendMsg() {
		connect.sendMsg("fashion@example.com", "test");
		String actual = connect.getMsg();
		String expected = "Your contact request has been submitted successfully.";
		assertEquals(actual, expected);
	}

}
