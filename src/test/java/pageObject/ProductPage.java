package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MenuPage {

	@FindBy(css = "#sylius_add_to_cart_cartItem_variant_dress_size")
	WebElement sizeDressElement;
	@FindBy(css = "#sylius_add_to_cart_cartItem_variant_t_shirt_size")
	WebElement sizeShirtElement;
	@FindBy(css = "#sylius_add_to_cart_cartItem_variant_jeans_size")
	WebElement sizeJeansElement;
	@FindBy(css = "#sylius_add_to_cart_cartItem_variant_dress_height")
	WebElement hightDressElement;
	@FindBy(css = "#sylius_add_to_cart_cartItem_quantity")
	WebElement quantityElement;
	@FindBy(css = "[type=\"submit\"] .cart")
	WebElement addToCartBtn;
	@FindBy(css = "#sylius-cart-validation-error")
	WebElement stockErrorElement;
	@FindBy(css = "sylius-product-name")
	WebElement productNameElement;

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectSize(String text) {
		SelectByValue(hightDressElement, text);
	}

	public void addDress(String size, String height, String Quantity) {
		changeDressSize(size);
		changeheight(height);
		changeQuantity(Quantity);
		addToCart();
		sleep(2000);
	}

	public void addjeans(String size, String Quantity) {
		changeJeansSize(size);
		changeQuantity(Quantity);
		addToCart();
		sleep(2000);
	}

	public void addShirt(String size, String Quantity) {
		changeShirtSize(size);
		changeQuantity(Quantity);
		addToCart();
		sleep(2000);
	}

	public void addcap(String Quantity) {
		changeQuantity(Quantity);
		addToCart();
		sleep(2000);
	}

	public void addToCart() {
		click(addToCartBtn);
	}

	public void changeDressSize(String size) {
		SelectByValue(sizeDressElement, size);
	}

	public void changeJeansSize(String size) {
		SelectByValue(sizeJeansElement, size);
	}

	public void changeShirtSize(String size) {
		SelectByValue(sizeShirtElement, size);
	}

	public void changeQuantity(String Quantity) {
		fillText(quantityElement, Quantity);
	}

	public void changeheight(String height) {
		SelectByValue(hightDressElement, height);
	}

	// validation
	public String getOutOfStockMsg() {
		return getT(stockErrorElement);
	}

	public String getProductName() {
		return getT(productNameElement);
	}

}
