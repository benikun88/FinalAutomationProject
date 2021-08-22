package pageObject;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Choose product
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
	public void search(String item) {
		fillText(searchFieldElement, item);
		click(searchBtn);
	}

	// Clear the search results
	public void clearSearch() {
		click(searchBtn);
	}

	// validate
	public String checkItmeName() {
		return getT(productName);
	}
}
