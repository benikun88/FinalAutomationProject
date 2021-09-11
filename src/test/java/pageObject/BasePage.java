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

	// Accept the alert pop up
	public void alertOK() {
		driver.switchTo().alert().accept();
	}

	// Get the current URL page name
	public String GetURL() {
		String URL = driver.getCurrentUrl();
		return URL;
	}

	// Fill the text in the text filed
	public void fillText(WebElement el, String text) {
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
		el.sendKeys(text);
	}

	// Click on element
	public void click(WebElement el) {
		highlightElement(el, "yellow");
		el.click();
	}

	// Get the text of the element
	public String getT(WebElement el) {
		highlightElement(el, "yellow");
		return el.getText();
	}

	// Create the system waiting before continue to next execution
	public void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Fill the alert with text
	public void fillAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	public void quit() {
		driver.quit();
	}

	// highlight the Element for failure test
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

	// Hover with the mouse over elements
	public void hoverMouse(WebElement el) {
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
	}

	// waiting
	protected void waitForVisibleOfElement(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	protected void waitForInVisibleOfElement(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	// Wait for objects elements instead of sleep
	public void implicitWait(long timeunit) {
		driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
	}

	// Wait for objects elements instead of sleep
	public void explicitWaitVisibility(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for objects elements instead of sleep
	public void explicitWaitClickable(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for objects elements instead of sleep
	public void explicitWaitAllElements(List<WebElement> elements) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	// Select element from drop off list
	public void SelectByValue(WebElement el, String Value) {
		Select s = new Select(el);
		s.selectByVisibleText(Value);
	}

	// Select element from drop off list
	public void SelectByText(WebElement el, String text) {
		Select s = new Select(el);
		s.selectByVisibleText(text);

	}

	// Select element from drop off list
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
