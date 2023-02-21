package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GlobalHelpers;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ContactsPage extends BasePage {
	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	public static ContactsPage using(WebDriver driver) {
		return new ContactsPage(driver);
	}

	Logger logger = Logger.getLogger(ContactsPage.class.getName());

	// Locators for contacts field
	By contacts = By.id("menu-contacts");
	By newContact = By.id("new-contact");
	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email = By.id("email");
	By prefix = By.id("ticketPrefix");
	By submit = By.id("contact-form-submit");
	By searchFirstName = By.id("first-name");
	By searchButton = By.id("search-contacts");
	By editButton = By.id("contact-edit");
	By editEmail = By.xpath("//div[2]/a[1]/i[1]");
	By changeEmail = By.id("email");
	By submitEmail = By.id("contact-form-submit");
	By deleteButton = By.xpath("//tbody/tr[2]/td[7]/a[1]");

	public static By fullName = By.xpath("//div[text()='Full name:']/following-sibling::div/p");

	// Method to enter contacts page
	public ContactsPage enterContactsPage() {
		logger.info("Navigating to the Contacts page");

		driver.findElement(contacts).click();

		logger.info("Navigation to the Contacts page successfully completed");
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

	public Object isEmailValid(String input) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return driver.findElement(By.xpath("//div[contains(text(),'Email must be valid')]"));
		return pat.matcher(input).matches();
	}

	public Object isEmailEmpty(String input) {
		if (input.isEmpty()) {
			return driver.findElement(By.xpath("//div[contains(text(),'Email is required')]"));
		}
		return false;
	}

	public Object validLogin(String input) {
		if (input.isEmpty()) {
			return driver.findElement(By.xpath("//div[contains(text(),'Login is required')]"));
		}
		return false;
	}

	public Object validPrefix(String input) {
		if (input.length() >= 3 && input.length() <= 6) {
			return driver.findElement(By.xpath("//div[contains(text(),'Tickets prefix must be from 3 to 6 characters long')]"));
		}
		return false;
	}

	public Object validLastName(int length) {
		if (length >= 2) {
			return driver.findElement(By.xpath("//div[contains(text(),'Last name must be at least 2 characters long.')]"));
		}
		return false;
	}

	// Method finds the created contact
	public void searchCratedContact(String contactFirstName) {
		logger.info("Searching for a created contact");

		driver.findElement(searchFirstName).sendKeys(contactFirstName);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(searchButton).click();
		driver.findElement(By.partialLinkText(contactFirstName)).click();

		logger.info("The contact was successfully found in the contacts list");
	}

	// Method edits the created contact
	public void editCratedContact(String newFirstName, String newLastName, String newEmail) {
		logger.info("Editing a created contact");

		driver.findElement(editButton).click();
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(newFirstName);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(newLastName);
		driver.findElement(editEmail).click();
		GlobalHelpers.sleepWait(3000);
		driver.findElement(changeEmail).clear();
		driver.findElement(changeEmail).sendKeys(newEmail);
		driver.findElement(submitEmail).click();
		GlobalHelpers.sleepWait(3000);
		driver.findElement(submit).click();

		logger.info("The contact was successfully edit");
	}

	// Method deletes the created contact
	public void deleteContact() {
		driver.findElement(deleteButton).click();
		GlobalHelpers.sleepWait(3000);
		driver.switchTo().alert().accept();
	}
}

