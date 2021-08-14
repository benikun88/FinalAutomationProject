package tests;

import org.apache.tools.ant.taskdefs.Sleep;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.ProductPage;
import pageObject.AuthenticationPage;
import pageObject.CartPage;
import pageObject.MainPage;

public class LoginTest extends BaseTest{
	
	@Test(priority =1)
	public void tc_01_loginFailed1() {
		MenuPage men=new MenuPage(driver);
		men.signIn();
		AuthenticationPage lP=new AuthenticationPage(driver);
		lP.login("shop@example.com", "sylius");

		}
	@Test(priority =2)
	public void tc_02_loginFailed1() {
		
		MainPage mainP=new MainPage(driver);
		mainP.chooseProduct("Circle-skirt Dress");
		ProductPage pro=new ProductPage(driver);
		pro.addDress("S","Tall","1");
		pro.goHomePage();
		mainP=new MainPage(driver);
		mainP.chooseProduct("Summer tunic");
		pro=new ProductPage(driver);
		pro.addDress("S","Tall","1");
		CartPage cart=new CartPage(driver);
		cart.deleteitem("Summer tunic");
	
		
	}
}
