package tests;

import config.ChromeDriverConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.pages.ContactsPage;
import pageobjects.pages.LoginPage;
import pageobjects.pages.TicketsPage;
import testdata.TestData;
import utils.GlobalHelpers;
import utils.RandomGenerator;

import java.util.HashMap;
import java.util.logging.Logger;

public class Task24 extends ChromeDriverConfiguration {
	protected WebDriver driver = ChromeDriverConfiguration.createDriver();
	protected ContactsPage contacts = new ContactsPage(driver);
	protected TicketsPage tickets = new TicketsPage(driver);

	Logger logger = Logger.getLogger(Task24.class.getName());

	@Test
	@Tag("ContactPage")
	public void editContact() {
		logger.info("Running a test to edit contact information");

		HashMap<String, String> hashMap = new HashMap<>();
		RandomGenerator randomManager = new RandomGenerator();

		// Test data
		String firstName = "Nataliia";
		String newFirstName = randomManager.getRandomString(5);
		String newLastName = randomManager.getRandomString(6);
		String newEmail = randomManager.getRandomEmail(6);

		// Save generated data
		hashMap.put("newFirstName", newFirstName);
		hashMap.put("newLastName", newLastName);
		hashMap.put("newEmail", newEmail);

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Open Contacts page
		ContactsPage.using(driver).enterContactsPage();

		// Find the created contact and open information
		contacts.searchCratedContact(firstName);

		// Edit the contact information
		contacts.editCratedContact(newFirstName, newLastName, newEmail);

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Comparing saved data with field values
		Assertions.assertEquals(driver.findElement(ContactsPage.fullName).getText(), hashMap.get("newFirstName") + " " + hashMap.get("newLastName"));

		logger.info("The test was successfully passed, the contact information was successfully edit");
	}

	@Test
	@Tag("ContactPage")
	public void deleteContact() {
		logger.info("Running a test to delete contact");

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Open Contacts page
		ContactsPage.using(driver).enterContactsPage();

		// Delete contact
		contacts.deleteContact();

		logger.info("The test was successfully passed, the contact was successfully delete");
	}

	@Test
	@Tag("TicketPage")
	public void editTicket() {
		logger.info("Running a test to edit ticket information");

		// Test data
		String newTicketTitle = "Test Ticket";
		String newTicketCategory = "TestCategory";
		String newTicketStage = "IN PROGRESS";

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Edit the contact information
		tickets.editCratedTicket(newTicketTitle, newTicketCategory, newTicketStage);

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Check whether a new ticket has been created
		tickets.findNewTicket(newTicketTitle);

		logger.info("The test was successfully passed, the ticket information was successfully edit");
	}
}
