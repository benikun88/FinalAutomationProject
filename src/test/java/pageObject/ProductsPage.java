package pageObject;

import java.util.List;

import org.apache.commons.lang3.Validate;
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
	@FindBy(css=".sylius-product-name")
	WebElement productname;

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void chooseProduct(String name) {
		for (WebElement el : productslist) {
			if(el.getText().equalsIgnoreCase(name)) {
				click(el);
				sleep(3000);
				break;
			}
		}
	}
	
	public void search(String item) {
		fillText(searchfieldElement, item);
		click(searchBtn);
	}

	
	
	//validate
	public String checkItmeName() {
		return getT(productname);
	}
}
