package tests;

import api.contacts.*;
import api.spec.Specifications;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.pages.selenide.BasePage_Selenide;
import pageobjects.pages.selenide.CategoriesPage_Selenide;
import pageobjects.pages.selenide.ContactsPage_Selenide;
import pageobjects.pages.selenide.ManagersPage_Selenide;
import testdata.TestData;
import utils.GlobalHelpers;
import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class Task25 extends BasePage_Selenide {
	protected ManagersPage_Selenide managers = new ManagersPage_Selenide();
	protected CategoriesPage_Selenide categories = new CategoriesPage_Selenide();
	protected ContactsPage_Selenide contacts = new ContactsPage_Selenide();
	protected Login login = new Login();
	private final static String URL = "http://176.36.27.131:8180/rest/";

	Logger logger = Logger.getLogger(Task25.class.getName());

	@Test
	@Tag("ManagersPage")
	public void createManager() {
		logger.info("Running a test to create a new manager");

		RandomGenerator randomManager = new RandomGenerator();

		// Test data
		String firstName = randomManager.getRandomString(7);
		String lastName = randomManager.getRandomString(9);
		String email = randomManager.getRandomEmail(4);
		String department = "Managers";
		int phoneNumber = randomManager.getRandomNumber(10);
		String skype = randomManager.getRandomSkype(11);

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Managers page
		managers.enterManagersPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Fill all fields and submit the form for new manager
		managers.fillAllFieldsForManager(firstName, lastName, email, department, Integer.toString(phoneNumber), skype);

		// Find the created manager and open information
		managers.searchManager(firstName);

		logger.info("The test was successfully passed");
	}

	@Test
	@Tag("ManagersPage")
	public void deleteManager() {
		logger.info("Running a test to delete manager");

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Managers page
		managers.enterManagersPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Delete the created manager
		managers.deleteManager();

		// Check the found error
		managers.errorDelete();

		logger.info("Test failed, manager cannot be deleted: Internal Server Error");
	}

	@Test
	@Tag("ManagersPage")
	public void editManager() {
		logger.info("Running a test to edit manager information");

		RandomGenerator randomManager = new RandomGenerator();

		// Test data
		String newFirstName = randomManager.getRandomString(5);
		String newLastName = randomManager.getRandomString(6);

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Managers page
		managers.enterManagersPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Edit the manager information
		managers.editManager(newFirstName, newLastName);

		logger.info("The test was successfully passed, the manager information was successfully edit");
	}

	@Test
	@Tag("ManagersPage")
	public void filterManagerAndClearFilter() {
		logger.info("Running a test to filter managers by first name, last name, department name " +
				"and clear filter button");

		RandomGenerator randomManager = new RandomGenerator();
		HashMap<String, String> hashMap = new HashMap<>();

		// Test data
		String firstName = randomManager.getRandomString(7);
		String lastName = randomManager.getRandomString(9);
		String email = randomManager.getRandomEmail(4);
		String department = "Managers";
		int phoneNumber = randomManager.getRandomNumber(10);
		String skype = randomManager.getRandomSkype(11);

		// Save generated data
		hashMap.put("firstName", firstName);
		hashMap.put("lastName", lastName);
		hashMap.put("email", email);
		hashMap.put("department", department);
		hashMap.put("phoneNumber", Integer.toString(phoneNumber));
		hashMap.put("skype", skype);

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Managers page
		managers.enterManagersPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Fill all fields and submit the form for new manager
		managers.fillAllFieldsForManager(hashMap.get("firstName"), hashMap.get("lastName"), hashMap.get("email"), hashMap.get("department"), hashMap.get("phoneNumber"), hashMap.get("skype"));

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Filter the created manager by first name, last name, department name and open information
		managers.filterManager(hashMap.get("firstName"), hashMap.get("lastName"), hashMap.get("department"));

		// Clear filters
		managers.clearFilter();

		logger.info("The test was successfully passed");
	}

	@Test
	@Tag("ManagersPage")
	public void sortManagers() {
		logger.info("Running a test to sort managers by full name, department");

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Managers page
		managers.enterManagersPage();

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Sort managers by full name
		managers.sortByFullName();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Pagination
		managers.moveThroughPages(1);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Open Managers page
		managers.enterManagersPage();

		// Sort managers by department
		managers.sortByDepartment();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Pagination
		managers.moveThroughPages(1);

		logger.info("The test was successfully passed");
	}

	@Test
	@Tag("CategoriesPage")
	public void createCategory() {
		logger.info("Running a test to create a new category");

		// Test data
		String newCategoryTitle = "New Test Category";

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Categories page
		categories.enterCategoriesPage();

		// Fill all fields and submit the form for new category
		categories.fillAllFieldsForCategory(newCategoryTitle);

		// Open Categories page
		categories.enterCategoriesPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Find the created category and open information
		categories.findNewCategory(newCategoryTitle);

		logger.info("The test was successfully passed");
	}

	@Test
	@Tag("CategoriesPage")
	public void deleteCategory() {
		logger.info("Running a test to delete category");

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Categories page
		categories.enterCategoriesPage();

		// Delete the created category
		categories.deleteCategory();

		logger.info("The test was successfully passed");
	}

	@Test
	@Tag("CategoriesPage")
	public void editCategory() {
		logger.info("Running a test to edit category, add new color and new stage");

		// Test data
		String newCategoryTitle = "New Category";
		String newCategoryColor = "Pink";
		String newCategoryStage = "CLOSE";

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Categories page
		categories.enterCategoriesPage();

		// Edit category information, add new color and new stage
		categories.editCategory(newCategoryTitle, newCategoryColor, newCategoryStage);

		logger.info("The test was successfully passed");
	}

	@Test
	@Tag("CategoriesPage")
	public void editAndDeleteCategoryStage() {
		logger.info("Running a test to edit category stage");

		// Test data
		String newCategoryStage = "TEST STAGE";

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Open Categories page
		categories.enterCategoriesPage();

		// Edit category Stage
		categories.editCategoryStage(newCategoryStage);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Delete category Stage
		categories.deleteCategoryStage();

		logger.info("The test was successfully passed");
	}

	@Test
	@Tag("ContactsPage")
	public void contactFlow() throws JsonProcessingException {
		logger.info("Running a test to create a new contact");

		Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
		Map<String, String> hashMap = new HashMap<>();
		RandomGenerator randomManager = new RandomGenerator();

		// Test data
		String emailAddress = randomManager.getRandomEmail(6);
		String email = randomManager.getRandomEmail(7);
		String companyName = randomManager.getRandomString(8);
		String prefix = randomManager.getRandomString(4).toUpperCase(Locale.ROOT);
		String firstName = randomManager.getRandomString(7);
		String lastName = randomManager.getRandomString(9);
		String loginContact = randomManager.getRandomEmail(7);
		String newEmail = randomManager.getRandomEmail(7);

		// Save generated data
		hashMap.put("emailAddress", emailAddress);
		hashMap.put("email", email);
		hashMap.put("name", companyName);
		hashMap.put("ticketPrefix", prefix);
		hashMap.put("firstName", firstName);
		hashMap.put("lastName", lastName);
		hashMap.put("login", loginContact);
		hashMap.put("newEmail", newEmail);

		EmailList emailList = new EmailList(false, hashMap.get("emailAddress"), false, false, true);

		ArrayList<EmailList> arrayEmailList = new ArrayList<>();
		arrayEmailList.add(emailList);

		Company company = new Company(hashMap.get("email"), true, hashMap.get("name"), 0, hashMap.get("ticketPrefix"));
		Contact contact = new Contact(-1, arrayEmailList, hashMap.get("firstName"), hashMap.get("lastName"), hashMap.get("login"));

		NewContactDto newContact = new NewContactDto(company, contact);

		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(newContact);

		// Website login
		login.getLogin();

		// Fill all fields and create a new contact
		Response response = given()
				.sessionId(login.session)
				.when()
				.body(jsonStr)
				.post("contact-with-company")
				.then().log().all()
				.extract().response();
		JsonPath jsonPath = response.jsonPath();
		String contactId = jsonPath.get("contactId").toString();

		logger.info("New contact was successfully created");

		logger.info("Running a test to check created contact");

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Open Contacts page
		contacts.enterContactsPage();

		// Find the created contact and open information
		contacts.searchCratedContact(hashMap.get("firstName"));

		// Compare saved data with field values
		Assertions.assertEquals(hashMap.get("firstName") + " " + hashMap.get("lastName"), contacts.fullName.getText());
		Assertions.assertEquals(hashMap.get("ticketPrefix"), contacts.prefix.getText());
		Assertions.assertEquals(hashMap.get("login"), contacts.login.getText());

		logger.info("Created contact was successfully found in the contacts list");

		logger.info("Running a test to edit contact information");

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Edit the contact information
		contacts.editCratedContact(hashMap.get("newEmail"));

		logger.info("Contact information was successfully edited");

		logger.info("Running a test to delete created contact");

		// Website login
		login.getLogin();

		given()
				.sessionId(login.session)
				.when()
				.delete("contact/" + contactId)
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.extract().response();

		logger.info("Created contact was successfully deleted");

		logger.info("Running a test to check if a contact has been deleted");

		// Open browser
		BasePage_Selenide.open();

		// Website login
		BasePage_Selenide.login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Open Contacts page
		contacts.enterContactsPage();

		// Find the created contact
		contacts.isContactDeleted(hashMap.get("firstName"));

		logger.info("The test was successfully passed: Element not found");
	}
}
