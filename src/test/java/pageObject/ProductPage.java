package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

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
	}

	// Add dress to cart
	@Step("Choose size: {0},height: {0},Quantity: {0}")
	public void addDress(String size, String height, String Quantity) {
		changeDressSize(size);
		changeHeight(height);
		changeQuantity(Quantity);
		addToCart();
	}

	// Add jeans to cart
	@Step("Choose size: {0},Quantity: {0}")
	public void addJeans(String size, String Quantity) {
		changeJeansSize(size);
		changeQuantity(Quantity);
		addToCart();
	}

	// Add shirt to cart
	@Step("Choose size: {0},Quantity: {0}")
	public void addShirt(String size, String Quantity) {
		changeShirtSize(size);
		changeQuantity(Quantity);
		addToCart();
	}

	// Add cap to cart
	public void addcap(String Quantity) {
		changeQuantity(Quantity);
		addToCart();
	}

	public void addToCart() {
		click(addToCartBtn);
	}

	// Select item size from drop list
	public void selectSize(String text) {
		SelectByValue(hightDressElement, text);
	}

	// Change the dress size
	public void changeDressSize(String size) {
		SelectByValue(sizeDressElement, size);
	}

	// Change the jeans size
	public void changeJeansSize(String size) {
		SelectByValue(sizeJeansElement, size);
	}

	// Change the shirt size
	public void changeShirtSize(String size) {
		SelectByValue(sizeShirtElement, size);
	}

	// Change the item Quantity
	public void changeQuantity(String Quantity) {
		fillText(quantityElement, Quantity);
	}

	// Change the item height
	public void changeHeight(String height) {
		SelectByValue(hightDressElement, height);
	}

	// validation
	// Get alert out of stock
	public String getOutOfStockMsg() {
		return getT(stockErrorElement);
	}

	// Get the product name
	public String getProductName() {
		return getT(productNameElement);
	}

}
