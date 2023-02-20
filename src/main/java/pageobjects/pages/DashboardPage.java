package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends BasePage {
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	// Locators for dashboard fields
	By dashboard = By.id("menu-dashboard");
	By dashboardDone = By.id("dashboard-done");
	By deadLineIsOver = By.id("company-additional-information");

	// Category`s locators
	public static By categories = By.xpath("//tbody/tr/td[9]/span[1]");
	public static By titleNames = By.xpath("//tbody/tr/td[3]/a[1]");
	public static By priority = By.xpath("//tbody/tr/td[5]");
	public static By id = By.xpath("//tbody/tr/td[2]");

	// Method to enter dashboard
	public void enterDashboardPage() {
		driver.findElement(dashboard).click();
	}

	// Method to enter "Done deadline" dashboard
	public void enterDashboardDone() {
		driver.findElement(dashboardDone).click();
	}

	// Method to enter "Deadline is over" via collapse element
	public void enterDeadLineIsOver() {
		driver.findElement(deadLineIsOver).click();
	}

	// Method gets the list of tickets "Deadline is over"
	public void getDeadLineIsOver() {
		enterDashboardPage();
		enterDashboardDone();
		enterDeadLineIsOver();
	}

	// Method gets text by index
	public void getWebElementsTitleByIndex(List<WebElement> webElementList, int i) {
		System.out.println(webElementList.get(i).getText());
	}

	// Getting list of elements and printing to the console
	public void getTitleNamesAndId(By categoriesWebElements, By titlesWebElements, String category) {
		List<WebElement> categories = driver.findElements(categoriesWebElements);
		List<WebElement> titles = driver.findElements(titlesWebElements);
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getText().trim().equals(category)) {
				getWebElementsTitleByIndex(titles, i);
			}
		}
	}

}