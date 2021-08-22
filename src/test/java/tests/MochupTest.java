package tests;

import org.apache.tools.ant.taskdefs.Sleep;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.MyAcountPage;
import pageObject.PersonalInfoPage;
import pageObject.ProductPage;
import pageObject.RegisterPage;
import pageObject.LoginPage;
import pageObject.CartPage;
import pageObject.MainPage;

public class MochupTest extends BaseTest {

	@Test(priority = 1)
	public void tc_01_loginFailed1() {
		MenuPage men = new MenuPage(driver);
		men.clicksignIn();
		LoginPage lP = new LoginPage(driver);
		lP.login("fashion@example.com", "sylius");
		men.clickMyacount();
		MyAcountPage myAcount = new MyAcountPage(driver);
		myAcount.clickPersonalInfoTab();
		PersonalInfoPage personalInfo = new PersonalInfoPage(driver);
		personalInfo.updateProfile("bati", "banana", "fashion@example.com", "Female");

	}

	@Test(priority = 2)
	public void tc_02_loginFailed1() {

		MainPage mainP = new MainPage(driver);
		mainP.chooseProduct("Slim fit men");
		ProductPage pro = new ProductPage(driver);
		pro.addShirt("S", "1");
		pro.goHomePage();
		mainP = new MainPage(driver);
		mainP.chooseProduct("Circle-skirt Dress");
		pro = new ProductPage(driver);
		pro.addDress("S", "Tall", "1");
		CartPage cart = new CartPage(driver);
		cart.removeItem("Slim fit men");

	}

	@Test(priority = 2)
	public void tc_02_register() {

		MainPage main = new MainPage(driver);
		main.clickRegister();
		RegisterPage register = new RegisterPage(driver);
		register.register("beni","kun","b5@gmail.com","05234","12345","12345");
		LoginPage login=new LoginPage(driver);
		String url=login.GetURL();
		driver.get(url);
		driver.navigate().back();
		
		
		

	}
}
