package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage extends BasePage {
	public CategoriesPage(WebDriver driver) {
		super(driver);
	}

	// Locator for categories field
	By categories = By.id("menu-categories");

	// Method to enter categories
	public void enterCategoriesPage() {
		driver.findElement(categories).click();
	}
}

