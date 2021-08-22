package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);

	}

	public void alertOK() {
		driver.switchTo().alert().accept();
	}

	public String GetURL() {
		String URL = driver.getCurrentUrl();
		return URL;
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		highlightElement(el, "yellow");
		el.click();
	}

	public String getT(WebElement el) {
		highlightElement(el, "yellow");
		return el.getText();
	}

	public void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void fillAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	public void quit() {
		driver.quit();
	}

	public void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:red;border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

	public void hoverMouse(WebElement el) {
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
	}

	public void implicitWait(long timeunit) {
		driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
	}

	public void explicitWaitVisibility(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void explicitWaitClickable(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void explicitWaitAllElements(List<WebElement> elements) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void SelectByValue(WebElement el, String Value) {
		Select s = new Select(el);
		s.selectByVisibleText(Value);
	}

	public void SelectByText(WebElement el, String text) {
		Select s = new Select(el);
		s.selectByVisibleText(text);

	}

	public void SelectByIndex(WebElement el, int i) {
		Select s = new Select(el);
		s.selectByIndex(i);

	}

	// check if element list exist
	public boolean isListExist(List<WebElement> list) {
		if (list.size() != 0) {
			return true;
		}

		else
			return false;
	}

	// check if element exist
	public boolean isExist(WebElement el) {
		return el.isDisplayed();
	}

}
