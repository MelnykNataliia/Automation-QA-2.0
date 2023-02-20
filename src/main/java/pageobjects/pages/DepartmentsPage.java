package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepartmentsPage extends BasePage {
	public DepartmentsPage(WebDriver driver) {
		super(driver);
	}

	// Locators for departments field
	By departmentsList = By.id("menu-departments");

	// Method to enter departments page
	public void enterDepartmentsPage() {
		driver.findElement(departmentsList).click();
	}
}
