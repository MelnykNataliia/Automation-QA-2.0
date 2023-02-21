package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GlobalHelpers;

import java.util.logging.Logger;

public class CategoriesPage extends BasePage {
	public CategoriesPage(WebDriver driver) {
		super(driver);
	}

	Logger logger = Logger.getLogger(CategoriesPage.class.getName());

	// Locator for categories field
	By categories = By.id("menu-categories");
	By createNewCategoryButton = By.id("new-category-btn");
	By categoryTitle = By.id("name");
	By submitNewCategoryButton = By.id("category-form-submit");
	By searchCategory = By.id("search-bar");
	By searchButton = By.id("search-bar-submit");

	// Method to enter categories page
	public void enterCategoriesPage() {
		logger.info("Navigating to the Categories page");

		driver.findElement(categories).click();

		logger.info("Navigation to the Categories page successfully completed");
	}

	// Methods describe actions with elements
	public void fillAllFieldsForCategory(String newCategoryTitle) {
		logger.info("Opening a form to create a new category, filling in all fields to create a new category and submitting the form");

		driver.findElement(createNewCategoryButton).click();
		driver.findElement(categoryTitle).sendKeys(newCategoryTitle);
		driver.findElement(submitNewCategoryButton).click();

		logger.info("New category form successfully submitted");
	}

	// Method finds the created Category
	public void findNewCategory(String newCategoryTitle) {
		logger.info("Searching for a created category");

		driver.findElement(searchCategory).sendKeys(newCategoryTitle);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(searchButton).click();

		logger.info("A new category was successfully found in the categories list");
	}
}

