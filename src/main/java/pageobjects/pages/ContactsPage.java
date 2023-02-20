package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {
	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "menu-contacts")
	WebElement contacts;

	@FindBy(id = "first-name")
	WebElement searchFirstName;

	@FindBy(id = "last-name")
	WebElement searchLastName;

	@FindBy(id = "search-contacts")
	WebElement searchContactButton;

	@FindBy(id = "clear-search-contact")
	WebElement clearSearchContactButton;

	@FindBy(id = "new-contact")
	WebElement newContact;

	public void enterContacts() {
		contacts.click();
	}

	public void enterSearchFirstName() {
		searchFirstName.click();
	}

	public void enterSearchLastName() {
		searchLastName.click();
	}

	public void enterSearchContactsButton() {
		searchContactButton.submit();
	}

	public void enterClearSearchContactsButton() {
		clearSearchContactButton.submit();
	}

	public void enterNewContact() {
		newContact.click();
	}
}

