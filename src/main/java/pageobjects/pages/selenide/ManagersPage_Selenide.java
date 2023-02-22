package pageobjects.pages.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.GlobalHelpers;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;

public class ManagersPage_Selenide extends BasePage_Selenide {
	Logger logger = Logger.getLogger(ManagersPage_Selenide.class.getName());

	public final SelenideElement managers = $("#menu-managers");
	public final SelenideElement newManagerButton = $("#managers-new-manager");
	public final SelenideElement managerFirstName = $("#firstName");
	public final SelenideElement managerLastName = $("#lastName");
	public final SelenideElement managerEmail = $("#email");
	public final SelenideElement managerDepartment = $("#manager-form-department-select");
	public final SelenideElement managerPhoneNumber = $("#phone");
	public final SelenideElement managerSkype = $("#skype");
	public final SelenideElement submitButton = $("#manager-form-submit");
	public final SelenideElement filterByFirstName = $("#search-manager-firstname");
	public final SelenideElement filterByLastName = $("#search-manager-lastname");
	public final SelenideElement filterByDepartment = $("#search-manager-department");
	public final SelenideElement filterButton = $("#search-manager-filter");
	public final SelenideElement editButton = $("#managers-edit-btn");
	public final SelenideElement deleteButton = $("#managers-delete-btn");
	public final SelenideElement clearButton = $("#search-manager-clear");
	public final SelenideElement infoWindow = $("#infoModal");
	public final SelenideElement sortByFullName = $("#managers-fullname-sort-asc");
	public final SelenideElement sortByDepartment = $("#managers-department-sort-asc");

	// Method to enter managers page
	public void enterManagersPage() {
		logger.info("Navigating to the Managers page");

		managers.click();

		logger.info("Navigation to the Managers page successfully completed");
	}

	public void fillAllFieldsForManager(String firstName, String lastName, String email, String department, String phoneNumber, String skype) {
		logger.info("Opening a form to create a new manager, filling in all fields to create a new manager and submitting the form");

		newManagerButton.click();
		managerFirstName.sendKeys(firstName);
		managerLastName.sendKeys(lastName);
		GlobalHelpers.sleepWait(2000);
		managerEmail.sendKeys(email);
		managerDepartment.sendKeys(department);
		managerPhoneNumber.sendKeys(phoneNumber);
		managerSkype.sendKeys(skype);
		submitButton.click();

		logger.info("New manager form successfully submitted");
	}

	// Method finds the created manager and open information
	public void searchManager(String firstName) {
		logger.info("Searching for a created manager");

		filterByFirstName.sendKeys(firstName);
		GlobalHelpers.sleepWait(3000);
		filterButton.click();
		$(By.partialLinkText(firstName)).click();

		logger.info("A new manager was successfully found in the managers list");
	}

	// Method finds the created manager and open information
	public void filterManager(String firstName, String lastName, String department) {
		logger.info("Searching for a created manager");

		filterByFirstName.sendKeys(firstName);
		filterByLastName.sendKeys(lastName);
		filterByDepartment.sendKeys(department);
		GlobalHelpers.sleepWait(3000);
		filterButton.click();

		logger.info("A new manager was successfully found in the managers list");
	}

	// Method edits the created manager
	public void editManager(String firstName, String lastName) {
		logger.info("Editing a created manager");

		editButton.click();
		managerFirstName.clear();
		managerFirstName.sendKeys(firstName);
		GlobalHelpers.sleepWait(3000);
		managerLastName.clear();
		managerLastName.sendKeys(lastName);
		GlobalHelpers.sleepWait(3000);
		submitButton.click();

		logger.info("The contact was successfully edit");
	}

	// Method deletes the created manager
	public void deleteManager() {
		deleteButton.click();
		GlobalHelpers.sleepWait(3000);
		Selenide.switchTo().alert().accept();
	}

	public void errorDelete() {
		infoWindow.shouldBe(Condition.visible);
		{
			System.out.println("Internal Server Error");
		}
	}

	// Method clears filters
	public void clearFilter() {
		clearButton.click();
	}

	// Method sorts managers by full name
	public void sortByFullName() {
		sortByFullName.click();
	}

	// Method sorts managers by department
	public void sortByDepartment() {
		sortByDepartment.click();
	}

	// Pagination
	public void moveThroughPages(int offsetFromActual) {
		SelenideElement ul = $(By.className("ngx-pagination"));
		ElementsCollection col = ul.$$x(".//li");
		SelenideElement active = col.find(Condition.cssClass("current"));
		int index = col.indexOf(active);
		index = index + offsetFromActual;
		col.get(index).$x(".//a").click();
	}
}
