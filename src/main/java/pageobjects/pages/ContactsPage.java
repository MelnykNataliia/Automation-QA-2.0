package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {
	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	// Locators for contacts field
	By contacts = By.id("menu-contacts");

	// Method to enter contacts page
	public void enterContactsPage() {
		driver.findElement(contacts).click();
	}
}

