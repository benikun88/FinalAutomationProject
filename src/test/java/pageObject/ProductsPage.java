package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends MenuPage {
	
	@FindBy(css ="#criteria_search_value" )
	WebElement searchfieldElement;
	@FindBy(css=".search")
	WebElement searchBtn;
	@FindBy(css=".button .cancel")
	WebElement canelBtn;
	@FindBy(css=".sylius-product-name")
	List<WebElement> productslist;

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
