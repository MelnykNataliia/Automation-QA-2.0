package pageobjects.pages.selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utils.GlobalHelpers;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CategoriesPage_Selenide extends BasePage_Selenide {
	Logger logger = Logger.getLogger(CategoriesPage_Selenide.class.getName());

	public final SelenideElement categories = $("#menu-categories");
	public final SelenideElement newCategoryButton = $("#new-category-btn");
	public final SelenideElement categoryTitle = $("#name");
	public final SelenideElement submitButton = $("#category-form-submit");
	public final SelenideElement searchCategory = $("#search-bar");
	public final SelenideElement searchButton = $("#search-bar-submit");
	public final SelenideElement deleteButton = $("#category-delete-btn");
	public final SelenideElement editCategoryButton = $("#category-stage-edit-btn");
	public final SelenideElement detailsEditButton = $(byClassName("category-details_mini-wrap-edit-button"));
	public final SelenideElement categoryColor = $("#color");
	public final SelenideElement newStageButton = $("#stages-new-stage");
	public final SelenideElement stageTitle = $("#name");
	public final SelenideElement submitNewStageButton = $("#stage-form-submit-btn");
	public final SelenideElement getCategory = $x("(//a[contains(text(),'New Category')])[1]");
	public final SelenideElement editCategoryDetails = $("#category-details-edit");
	public final SelenideElement editStageButton = $("#stages-edit-btn");
	public final SelenideElement deleteStageButton = $("#stages-delete-btn");


	// Method to enter categories page
	public void enterCategoriesPage() {
		logger.info("Navigating to the Categories page");

		categories.click();

		logger.info("Navigation to the Categories page successfully completed");
	}

	public void fillAllFieldsForCategory(String newCategoryTitle) {
		logger.info("Opening a form to create a new category, filling in all fields to create a new category and submitting the form");

		newCategoryButton.click();
		categoryTitle.sendKeys(newCategoryTitle);
		submitButton.click();

		logger.info("New category form successfully submitted");
	}

	// Method finds the created category
	public void findNewCategory(String newCategoryTitle) {
		logger.info("Searching for a created category");

		searchCategory.sendKeys(newCategoryTitle);
		GlobalHelpers.sleepWait(3000);
		searchButton.click();

		logger.info("A new category was successfully found in the categories list");
	}

	// Method deletes the created category
	public void deleteCategory() {
		logger.info("Deleting category");

		deleteButton.click();
		GlobalHelpers.sleepWait(3000);
		Selenide.switchTo().alert().accept();

		logger.info("The category was successfully delete");
	}

	// Method edits the created category
	public void editCategory(String newCategoryTitle, String newCategoryColor, String newCategoryStage) {
		logger.info("Editing a created category");

		editCategoryButton.click();
		detailsEditButton.click();
		categoryTitle.clear();
		categoryTitle.sendKeys(newCategoryTitle);
		GlobalHelpers.sleepWait(3000);
		categoryColor.clear();
		categoryColor.sendKeys(newCategoryColor);
		submitButton.click();
		GlobalHelpers.sleepWait(3000);
		newStageButton.click();
		stageTitle.sendKeys(newCategoryStage);
		submitNewStageButton.click();

		logger.info("The category was successfully edit");
	}

	// Method edits the category Stage
	public void editCategoryStage(String newCategoryStage) {
		logger.info("Editing category stage");

		getCategory.pressEnter();
		editCategoryDetails.click();
		submitButton.click();
		GlobalHelpers.sleepWait(3000);
		editStageButton.click();
		stageTitle.clear();
		stageTitle.sendKeys(newCategoryStage);
		submitNewStageButton.click();

		logger.info("The category stage was successfully edit");
	}

	// Method deletes the category Stage
	public void deleteCategoryStage() {
		logger.info("Deleting category stage");

		deleteStageButton.click();
		Selenide.switchTo().alert().accept();

		logger.info("The category stage was successfully delete");
	}
}
