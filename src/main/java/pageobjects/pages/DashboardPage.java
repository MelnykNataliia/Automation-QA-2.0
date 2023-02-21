package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class DashboardPage extends BasePage {
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	Logger logger = Logger.getLogger(DashboardPage.class.getName());

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
		logger.info("Navigating to the Dashboard page");

		driver.findElement(dashboard).click();

		logger.info("Navigation to the Dashboard page successfully completed");
	}

	// Method to enter "Done deadline" dashboard
	public void enterDashboardDone() {
		logger.info("Navigating to the Done Deadline");

		driver.findElement(dashboardDone).click();

		logger.info("Navigation to the Done Deadline successfully completed");
	}

	// Method to enter "Deadline is over" via collapse element
	public void enterDeadLineIsOver() {
		logger.info("Navigating to the Deadline is over");

		driver.findElement(deadLineIsOver).click();

		logger.info("Navigation to the Deadline is over successfully completed");
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