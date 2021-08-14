package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MenuPage{
	
	
	
	@FindBy(css ="#sylius_add_to_cart_cartItem_variant_dress_size" )
	WebElement sizeDropElement;
	@FindBy(css="#sylius_add_to_cart_cartItem_variant_dress_height")
	WebElement hightDropElement;
	@FindBy(css="#sylius_add_to_cart_cartItem_quantity")
	WebElement quantityElement;
	@FindBy(css="[type=\"submit\"] .cart")
	WebElement addToCartBtn;
	@FindBy(css="#sylius-cart-validation-error")
	WebElement stockErrorElement;

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void selectSize(String text) {
		SelectByValue(hightDropElement, text);
	}
	public void addDress(String size,String height,String Quantity) {
		changeSize(size);
		changeheight(height);
		changeQuantity(Quantity);
		addToCart();
		sleep(2000);
	}
	
	public void addToCart() {
		click(addToCartBtn);
	}
	public void changeSize(String size) {
		SelectByValue(sizeDropElement, size);
	}
	public void changeQuantity(String Quantity) {
		fillText(quantityElement, Quantity);
	}
	public void changeheight(String height) {
		SelectByValue(hightDropElement, height);
	}
	

}
