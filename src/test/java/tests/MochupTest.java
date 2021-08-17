package tests;

import org.apache.tools.ant.taskdefs.Sleep;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.MyAcountPage;
import pageObject.PersonalInfoPage;
import pageObject.ProductPage;
import pageObject.AuthenticationPage;
import pageObject.CartPage;
import pageObject.MainPage;

public class MochupTest extends BaseTest{
	
	@Test(priority =1)
	public void tc_01_loginFailed1() {
		MenuPage men=new MenuPage(driver);
		men.clicksignIn();
		AuthenticationPage lP=new AuthenticationPage(driver);
		lP.login("fashion@example.com", "sylius");
		men.clickMyacount();
		MyAcountPage myAcount=new MyAcountPage(driver);
		myAcount.clickPersonalInfoTab();
		PersonalInfoPage personalInfo=new PersonalInfoPage(driver);
		personalInfo.updateProfile("bati","banana", "fashion@example.com", "Female");
		

		}
	@Test(priority =2)
	public void tc_02_loginFailed1() {
		
		MainPage mainP=new MainPage(driver);
		mainP.chooseProduct("Slim fit men");
		ProductPage pro=new ProductPage(driver);
		pro.addShirt("S","1");
		pro.goHomePage();
		mainP=new MainPage(driver);
		mainP.chooseProduct("Circle-skirt Dress");
		pro=new ProductPage(driver);
		pro.addDress("S","Tall","1");
		CartPage cart=new CartPage(driver);
		cart.deleteitem("Slim fit men");
	
		
	}
}
