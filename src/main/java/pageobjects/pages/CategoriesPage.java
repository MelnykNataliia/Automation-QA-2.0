package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GlobalHelpers;

public class CategoriesPage extends BasePage {
	public CategoriesPage(WebDriver driver) {
		super(driver);
	}

	// Locator for categories field
	By categories = By.id("menu-categories");
	By createNewCategoryButton = By.id("new-category-btn");
	By categoryTitle = By.id("name");
	By submitNewCategoryButton = By.id("category-form-submit");
	By searchCategory = By.id("search-bar");
	By searchButton = By.id("search-bar-submit");

	// Method to enter categories page
	public void enterCategoriesPage() {
		driver.findElement(categories).click();
	}

	// Methods describe actions with elements
	public void fillAllFieldsForCategory(String newCategoryTitle) {
		driver.findElement(createNewCategoryButton).click();
		driver.findElement(categoryTitle).sendKeys(newCategoryTitle);
		driver.findElement(submitNewCategoryButton).click();
	}

	// Method finds the created Category
	public void findNewCategory(String newCategoryTitle) {
		driver.findElement(searchCategory).sendKeys(newCategoryTitle);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(searchButton).click();
	}
}

