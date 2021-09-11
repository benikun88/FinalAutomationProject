package pageObject;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ProductsPage extends MenuPage {

	@FindBy(css = "#criteria_search_value")
	WebElement searchFieldElement;
	@FindBy(css = ".search")
	WebElement searchBtn;
	@FindBy(css = ".button .cancel")
	WebElement canelBtn;
	@FindBy(css = ".sylius-product-name")
	List<WebElement> productsList;
	@FindBy(css = ".sylius-product-name")
	WebElement productName;
	@FindBy(css = ".info.message .content p")
	WebElement searchInfoMsg;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	// Choose product
	@Step("Choose product {0}")
	public void chooseProduct(String name) {
		for (WebElement el : productsList) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				sleep(3000);
				break;
			}
		}
	}

	// Search product from available items
	@Step("search product {0}")
	public void search(String item) {
		fillText(searchFieldElement, item);
		click(searchBtn);
		sleep(2000);
	}

	// Clear the search results
	public void clearSearch() {
		click(searchBtn);
	}

	// validate
	// Get the name item
	public String checkItmeName() {
		return getT(productName);
	}

	// Get message if item don't exist
	public String getSearchInfoMsg() {
		return getT(searchInfoMsg);
	}
}
