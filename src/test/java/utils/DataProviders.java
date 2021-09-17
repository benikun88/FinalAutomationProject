package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider
	public Object[][] loginData() {
		Object[][] myData = { { "@example.com", "sylius" }, { "gal", "123" }, { "", "" }, { "!", "===" }, };
		return myData;
	}
	
	@DataProvider
	public Object[][] contactUsData() {
		Object[][] myData = { { "dummy.com", "test", "This email is invalid." },
				{ "fashion@example.com", "", "Please enter your message." } };
		return myData;
	}
}
