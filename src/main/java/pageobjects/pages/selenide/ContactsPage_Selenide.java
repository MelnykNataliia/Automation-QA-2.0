package pageobjects.pages.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.GlobalHelpers;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ContactsPage_Selenide extends BasePage_Selenide {

	Logger logger = Logger.getLogger(ContactsPage_Selenide.class.getName());

	public final SelenideElement contacts = $("#menu-contacts");
	public final SelenideElement firstName = $("tbody tr td:nth-child(1)");
	public final SelenideElement fullName = $x("//div[text()='Full name:']/following-sibling::div/p");
	public final SelenideElement login = $x("//div[text()='Login:']/following-sibling::div/p");
	public final SelenideElement prefix = $x("//div[text()='Prefix:']/following-sibling::div/p");
	public final SelenideElement submit = $("#contact-form-submit");
	public final SelenideElement searchFirstName = $("#first-name");
	public final SelenideElement searchButton = $("#search-contacts");
	public final SelenideElement editButton = $("#contact-edit");
	public final SelenideElement editEmail = $x("//div[2]/a[1]/i[1]");
	public final SelenideElement changeEmail = $("#email");
	public final SelenideElement submitEmail = $("#contact-form-submit");

	// Method to enter contacts page
	public void enterContactsPage() {
		logger.info("Navigating to the Contacts page");

		contacts.click();

		logger.info("Navigation to the Contacts page successfully completed");
	}

	// Method finds the created contact
	public void searchCratedContact(String contactFirstName) {
		logger.info("Searching for a created contact");

		searchFirstName.sendKeys(contactFirstName);
		GlobalHelpers.sleepWait(3000);
		searchButton.click();
		firstName.click();

		logger.info("A new contact was successfully found in the contacts list");
	}

	// Method edits the created contact
	public void editCratedContact(String newEmail) {
		logger.info("Editing a created contact");

		editButton.click();
		editEmail.click();
		changeEmail.clear();
		changeEmail.sendKeys(newEmail);
		submitEmail.click();
		GlobalHelpers.sleepWait(3000);
		submit.click();

		logger.info("The contact was successfully edit");
	}

	// Method checks deleted contact
	public void isContactDeleted(String contactFirstName) {
		searchFirstName.sendKeys(contactFirstName);
		GlobalHelpers.sleepWait(3000);
		searchButton.click();
		firstName.shouldNotBe(Condition.visible);
	}
}

