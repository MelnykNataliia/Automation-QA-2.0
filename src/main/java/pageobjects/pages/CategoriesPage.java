package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends BasePage {
	public CategoriesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "menu-categories")
	WebElement categories;

	@FindBy(id = "new-category-btn")
	WebElement newCategory;

	public void enterCategories() {
		categories.click();
	}

	public void enterNewCategory() {
		newCategory.click();
	}
}

