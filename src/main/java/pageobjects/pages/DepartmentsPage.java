package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepartmentsPage extends BasePage {
	public DepartmentsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "menu-departments")
	WebElement departments;

	@FindBy(id = "department-search-title")
	WebElement searchDepartmentTitle;

	@FindBy(id = "department-search-filter")
	WebElement searchDepartmentButton;

	@FindBy(id = "department-search-clear")
	WebElement clearSearchDepartmentButton;

	@FindBy(id = "new-department")
	WebElement newDepartment;

	public void enterDepartments() {
		departments.click();
	}

	public void enterSearchDepartmentTitle() {
		searchDepartmentTitle.click();
	}

	public void enterSearchDepartmentButton() {
		searchDepartmentButton.submit();
	}

	public void enterClearSearchDepartmentButton() {
		clearSearchDepartmentButton.submit();
	}

	public void enterNewDepartments() {
		newDepartment.click();
	}
}
