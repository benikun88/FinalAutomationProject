package pageObject;

import java.util.List;

import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	WebElement checkoutBtnElement;
	@FindBy(css = "#sylius-cart-update")
	WebElement updateBtnElement;
	@FindBy(css = "#sylius_cart_promotionCoupon")
	WebElement couponElement;
	@FindBy(css = "#sylius-save")
	WebElement applaycouponBtn;
	@FindBy(css = "#sylius-cart-clear")
	WebElement clearCartBtn;
//	@FindBy(css="div.content > p:nth-child(2)")
//	WebElement successalert;
	@FindBy(css = ".positive.message.sylius-flash-message:nth-child(2) div p")
	WebElement MsgElement;
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
		// TODO Auto-generated constructor stub
	}

	public void removeItem(String name) {
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

	public void clearCart() {
		click(clearCartBtn);
	}

	public void clickCheckout() {
		click(checkOutBtn);
	}

	public void changeQuantity(String qcy) {
		fillText(quantityElement, qcy);
		click(updateBtnElement);
		sleep(2000);
	}

	public void applyCoupon(String cpn) {
		fillText(couponElement, cpn);
		click(applaycouponBtn);
	}

	// validation
	public String getOrderTotal() {
		return getT(TotalPriceShipElement);
	}

	public String getcartMsg() {
		return getT(MsgElement);
	}

	public String getstockErr() {
		return getT(stockMsg);
	}

	public String getCpnErr() {
		return getT(couponMsg);
	}

	public String checkEmptyCart() {
		clickCart();
		return getT(cartEmptyMsg);
	}

	public boolean checkItemExist(String name) {
		for (WebElement el : productsList) {
			if (el.getText().equalsIgnoreCase(name)) {
				return true;
			}

		}
		return false;
	}

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

	public String getInfoCart() {
		return getT(infoCartMsg);
	}

	public double getUnitPrice() {
		String unit = getT(unitPriceElement);
		int size = unit.length();
		unit = unit.substring(1, size);
		double unitPrice = Double.parseDouble(unit);
		unitPrice = Precision.round(unitPrice, 2);
//		System.out.println(unitPrice);
		return unitPrice;
	}

	public double getTotalprice() {
		String unit = getT(TotalPriceElement);
		int size = unit.length();
		unit = unit.substring(1, size);
		double unitPrice = Double.parseDouble(unit);
		unitPrice = Precision.round(unitPrice, 2);
//		System.out.println(unitPrice);
		return unitPrice;
	}

	public double getTotalpriceShip() {
		String unit = getT(TotalPriceShipElement);
		int size = unit.length();
		unit = unit.substring(1, size);
		double unitPrice = Double.parseDouble(unit);
		unitPrice = Precision.round(unitPrice, 2);
//		System.out.println(unitPrice);
		return unitPrice;
	}

}
