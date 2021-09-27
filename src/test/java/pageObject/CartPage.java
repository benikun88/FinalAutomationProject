package pageObject;

import java.util.List;

import org.apache.commons.math3.util.Precision;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;

import io.qameta.allure.Step;

public class CartPage extends MenuPage {

	@FindBy(css = ".sylius-cart-remove-button")
	List<WebElement> iconTrashElements;
	@FindBy(css = "#sylius-cart-items .sylius-product-name")
	List<WebElement> productsList;
	@FindBy(css = "#sylius_cart_items_0_quantity")
	WebElement quantityElement;
	@FindBy(css = ".sylius-unit-price")
	WebElement unitPriceElement;
	@FindBy(css = ".sylius-total")
	WebElement TotalPriceElement;
	@FindBy(css = "#sylius-cart-grand-total")
	WebElement TotalPriceShipElement;
	@FindBy(css = ".fluid.labeled.icon.button:nth-child(2)")
	WebElement checkoutBtn;
	@FindBy(css = "#sylius-cart-update")
	WebElement updateBtnElement;
	@FindBy(css = "#sylius_cart_promotionCoupon")
	WebElement couponElement;
	@FindBy(css = "#sylius-save")
	WebElement applyCouponBtn;
	@FindBy(css = "#sylius-cart-clear")
	WebElement clearCartBtn;
//	@FindBy(css="div.content > p:nth-child(2)")
//	WebElement successalert;
	@FindBy(css = ".positive.message.sylius-flash-message:nth-child(2) div p")
	WebElement CartStatusMsg;
	@FindBy(css = ".positive .close ")
	WebElement closeMsgBtn;
	@FindBy(css = ".sylius-validation-error")
	WebElement stockMsg;
	@FindBy(css = "#sylius-coupon .sylius-validation-error")
	WebElement couponMsg;
	@FindBy(css = ".info.message:nth-child(3) div.content p")
	WebElement infoCartMsg;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	// Remove product from cart
	@Step("Remove Item: {0}")
	public void removeItem(String name) {
		sleep(2000);
		int index = 0;
		for (WebElement el : productsList) {
			if (el.getText().equalsIgnoreCase(name)) {
				break;
			}
			index++;
		}
		click(iconTrashElements.get(index));
		sleep(2000);
	}

	// Clear the cart
	public void clearCart() {
		waitForVisibleOfElement(clearCartBtn);
		click(clearCartBtn);
	}

	// Click pass to checkout page
	public void clickCheckout() {
		waitForVisibleOfElement(checkoutBtn);
		click(checkoutBtn);
	}

	// change the quantity of a product in the cart
	@Step("Ass Quantity: {0}")
	public void changeQuantity(String qcy) {
		waitForVisibleOfElement(quantityElement);
		fillText(quantityElement, qcy);
		click(updateBtnElement);
		sleep(2000);
	}

	// Apply coupon in the cart
	@Step("Apply copoun: {0}")
	public void applyCoupon(String cpn) {
		waitForVisibleOfElement(couponElement);
		fillText(couponElement, cpn);
		click(applyCouponBtn);
		sleep(1000);
	}

	// Validation
	// Get total price include shipment,coupon
	public String getOrderTotal() {
		return getT(TotalPriceShipElement);
	}

	// Get cart status in add or remove item
	public String getCartMsg() {
		return getT(CartStatusMsg);
	}

	// Get out of stock indication
	public String getStockErr() {
		return getT(stockMsg);
	}

	// Get coupon error
	public String getCpnErr() {
		return getT(couponMsg);
	}

	// Check for indication if the top bar cart button indicate empty cart
	public String checkEmptyCartTopBar() {
		clickCart();
		return getT(cartEmptyMsgTopBar);
	}

	// Check if item exist in cart
	public boolean checkItemExist(String name) {
		sleep(2000);
		for (WebElement el : productsList) {
			if (el.getText().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	// Check if item exist in cart top bar button
	public boolean checkItemExistOncartBtn(String name) {
		clickCart();
		productsList.remove(productsList.size() - 1);
		for (WebElement el : productsList) {
			if (el.getText().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	// Get info if cart is empty
	public String getInfoCart() {
		return getT(infoCartMsg);
	}

	// Get price of one unit of product
	public double getUnitPrice() {
		String unit = getT(unitPriceElement);
		int size = unit.length();
		unit = unit.substring(1, size);
		double unitPrice = Double.parseDouble(unit);
		unitPrice = Precision.round(unitPrice, 2);
		return unitPrice;
	}

	// Get the total price of product
	public double getTotalprice() {
		waitForVisibleOfElement(TotalPriceElement);
		String unit = getT(TotalPriceElement);
		int size = unit.length();
		unit = unit.substring(1, size);
		double unitPrice = Double.parseDouble(unit);
		unitPrice = Precision.round(unitPrice, 2);
		return unitPrice;
	}

	// Get the total price of all product include shipping and discounts
	public double getTotalpriceShip() {
		String unit = getT(TotalPriceShipElement);
		int size = unit.length();
		unit = unit.substring(1, size);
		double unitPrice = Double.parseDouble(unit);
		unitPrice = Precision.round(unitPrice, 2);
		return unitPrice;
	}

}
