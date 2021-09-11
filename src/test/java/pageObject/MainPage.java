package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends MenuPage {

	@FindBy(css = ".header.sylius-product-name")
	List<WebElement> productsList;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	// Choose a product from the main page
	public void chooseProduct(String name) {
		for (WebElement el : productsList) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				sleep(3000);
				break;
			}
		}
	}

}
