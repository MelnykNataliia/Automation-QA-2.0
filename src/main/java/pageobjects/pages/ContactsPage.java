package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GlobalHelpers;

public class ContactsPage extends BasePage {
	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	public static ContactsPage using(WebDriver driver) {
		return new ContactsPage(driver);
	}

	// Locators for contacts field
	By contacts = By.id("menu-contacts");
	By newContact = By.id("new-contact");
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email = By.id("email");
	By prefix = By.id("ticketPrefix");
	By submit = By.id("contact-form-submit");

	// Method to enter contacts page
	public ContactsPage enterContactsPage() {
		driver.findElement(contacts).click();
		return this;
	}

	public ContactsPage enterNewContact() {
		driver.findElement(newContact).click();
		return this;
	}

	public ContactsPage getFirstName(String contactFirstName) {
		driver.findElement(firstName).sendKeys(contactFirstName);
		return this;
	}

	public ContactsPage getLastName(String contactLastName) {
		driver.findElement(lastName).sendKeys(contactLastName);
		return this;
	}

	public ContactsPage getEmail(String contactEmail) {
		driver.findElement(email).sendKeys(contactEmail);
		return this;
	}

	public ContactsPage getPrefix() {
		driver.findElement(prefix);
		return this;
	}

	public void submitButton() {
		GlobalHelpers.sleepWait(3000);
		driver.findElement(submit).click();
	}

}

