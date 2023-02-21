package tests;

import config.ChromeDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.pages.ContactsPage;
import pageobjects.pages.LoginPage;
import testdata.TestData;
import utils.GlobalHelpers;
import utils.ITestListenerClass;
import utils.RandomGenerator;

import java.util.logging.Logger;

@Listeners(ITestListenerClass.class)
public class Task22 extends ChromeDriverConfiguration {
	protected WebDriver driver = ChromeDriverConfiguration.createDriver();
	protected ContactsPage contacts = new ContactsPage(driver);

	Logger logger = Logger.getLogger(Task22.class.getName());

	@Test(testName = "createContact")
	public void createNewContact() {
		RandomGenerator randomManager = new RandomGenerator();

		logger.info("Running a test to create a new contact and check the errors");

		// Test data
		String contactFirstName = randomManager.getRandomString(2);
		String contactLastName = randomManager.getRandomString(1);
		String contactEmail = randomManager.getRandomString(1);
		String ticketsPrefix = randomManager.getRandomString(2);

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Fill all fields and submit the form for new contact
		ContactsPage.using(driver)
					.enterContactsPage()
					.enterNewContact()
					.getFirstName(contactFirstName)
					.getLastName(contactLastName)
					.getEmail(contactEmail)
					.getPrefix()
					.submitButton();

		logger.info("Comparing the entered invalid values and checking the errors");

		// Comparing the entered invalid values and checking the errors
		Assert.assertFalse(((Boolean) contacts.isEmailValid("example.com")), contactEmail);
		Assert.assertFalse(((Boolean) contacts.isEmailEmpty("example@test.com")), contactEmail);
		Assert.assertFalse(((Boolean) contacts.validLogin("example")), contactEmail);
		Assert.assertFalse(((Boolean) contacts.validPrefix("pr")), ticketsPrefix);
		Assert.assertFalse(((Boolean) contacts.validLastName(1)), contactLastName);

		logger.info("All errors successfully checked");

		logger.info("The test was successfully passed");
	}
}
