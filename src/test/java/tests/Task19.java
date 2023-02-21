package tests;

import config.ChromeDriverConfiguration;
import database.DataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.pages.*;
import testdata.TestData;
import utils.GlobalHelpers;

import java.sql.SQLException;
import java.util.logging.Logger;

public class Task19 extends ChromeDriverConfiguration {
	protected WebDriver driver = ChromeDriverConfiguration.createDriver();
	protected TicketsPage tickets = new TicketsPage(driver);
	protected СompaniesPage companies = new СompaniesPage(driver);
	protected ManagersPage managers = new ManagersPage(driver);
	protected CategoriesPage categories = new CategoriesPage(driver);
	protected DataBase newTicket = new DataBase();
	protected DataBase newCompany = new DataBase();
	protected DataBase newManager = new DataBase();
	protected DataBase newCategory = new DataBase();

	Logger logger = Logger.getLogger(Task19.class.getName());

	@Test
	public void createNewTicket() throws SQLException, ClassNotFoundException {
		logger.info("Running a test to create a new ticket and compare data in the table and DB");

		// Test data
		String newTicketTitle = "Test Ticket";
		String newTicketCategory = "Test";
		String newTicketStage = "CLOSED";
		String newTicketCompany = "Snowball";
		String newTicketContact = "Nataliia Melnyk";
		String newTicketPriority = "P4";
		String selectTitle = "select title from ticket where title = 'Test Ticket' limit 1";
		String selectCategoryName = "select category.name from category join ticket on category.id = ticket.category_id and title = 'Test Ticket' limit 1";
		String selectStageName = "select stage.name from stage join ticket on stage.id = ticket.stage_id and title = 'Test Ticket' limit 1";
		String selectCompanyName = "select company.name from company join ticket on company.id = ticket.id and name = 'Snowball'";
		String selectContact = "select concat(contact.first_name, ' ', contact.last_name) as full_name from contact join ticket on contact.id = ticket.contact_id and title = 'Test Ticket' limit 1";
		String selectPriority = "select priority from ticket where title = 'Test Ticket' limit 1";

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Fills all fields and submit the form for new ticket
		tickets.fillAllFieldsForTicket(newTicketTitle, newTicketCategory, newTicketStage, newTicketCompany, newTicketContact, newTicketPriority);

		// Checks whether a new ticket has been created
		tickets.findNewTicket(newTicketTitle);

		// Compare data in the table and DB
		Assertions.assertEquals(newTicket.ticketTitle(selectTitle), newTicketTitle);
		Assertions.assertEquals(newTicket.ticketCategory(selectCategoryName), newTicketCategory);
		Assertions.assertEquals(newTicket.ticketStage(selectStageName), newTicketStage);
		Assertions.assertEquals(newTicket.ticketCompany(selectCompanyName), newTicketCompany);
		Assertions.assertEquals(newTicket.ticketContact(selectContact), newTicketContact);
		Assertions.assertEquals(newTicket.ticketTitle(selectTitle), newTicketTitle);
		Assertions.assertEquals(newTicket.ticketPriority(selectPriority), newTicketPriority);

		logger.info("The test was successfully passed, the data in the table match data in the DB.");
	}

	@Test
	public void createNewInnerTicket() throws SQLException, ClassNotFoundException {
		logger.info("Running a test to create a new Inner ticket and compare data in the table and DB");

		// Test data
		String newInnerTicketTitle = "Test inner ticket";
		String selectInnerTicketTitle = "select title from ticket where title = 'Test inner ticket' limit 1";

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Page load delay
		GlobalHelpers.sleepWait(2000);

		// Fills title field and submit the form for new inner ticket
		tickets.fillTheFormForInnerTicket(newInnerTicketTitle);

		// Checks whether a new inner ticket has been created
		tickets.findNewInnerTicket();

		// Compare data in the table and DB
		Assertions.assertEquals(newTicket.ticketInnerTitle(selectInnerTicketTitle), newInnerTicketTitle);

		logger.info("The test was successfully passed, the data in the table match data in the DB.");
	}

	@Test
	public void createNewCompany() throws SQLException, ClassNotFoundException {
		logger.info("Running a test to create a new company and compare data in the table and DB");

		// Test data
		String newCompanyTitle = "Containership";
		String newCompanyCountry = "UK";
		String newCompanyCity = "Odesa";
		String newCompanyPhone = "+380482389330";
		String selectCompanyTitle = "select name from company where name = 'Containership' limit 1";

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Open Companies page
		companies.enterCompaniesPage();// Page load delay

		// Page load delay
		GlobalHelpers.sleepWait(2000);

		// Fills all fields and submit the form for new company
		companies.fillAllFieldsForCompany(newCompanyTitle, newCompanyCountry, newCompanyCity, newCompanyPhone);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Checks whether a new company has been created
		companies.findNewCompany(newCompanyTitle);

		// Compare data in the table and DB
		Assertions.assertEquals(newCompany.companyTitle(selectCompanyTitle), newCompanyTitle);

		logger.info("The test was successfully passed, the data in the table match data in the DB.");
	}

	@Test
	public void createNewManager() throws SQLException, ClassNotFoundException {
		logger.info("Running a test to create a new manager and compare data in the table and DB");

		// Test data
		String firstName = "TestFirstName";
		String lastName = "TestLastName";
		String email = "test17manager@gmail.com";
		String department = "Managers";
		String phoneNumber = "+380482389330";
		String skype = "testManager";
		String selectManagerFirstName = "select first_name from manager join department on manager.department_id = department.id and first_name = 'TestFirstName' and department.name = 'Managers' limit 1";
		String selectManagerLastName = "select last_name from manager join department on manager.department_id = department.id and last_name = 'TestLastName' and department.name = 'Managers' limit 1;";
		String selectManagerDepartment = "select department.name from department where department.name = 'Managers'";

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Open Managers page
		managers.enterManagersPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Fills all fields and submit the form for new manager
		managers.fillAllFieldsForManager(firstName, lastName, email, department, phoneNumber, skype);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Finds the created manager and open information
		managers.searchManager(firstName);

		// Compare data in the table and DB by criteria First Name, Last Name and Department Name
		Assertions.assertEquals(newManager.managerFirstName(selectManagerFirstName), firstName);
		Assertions.assertEquals(newManager.managerLastName(selectManagerLastName), lastName);
		Assertions.assertEquals(newManager.managerDepartment(selectManagerDepartment), department);

		logger.info("The test was successfully passed, the data in the table match data in the DB.");
	}

	@Test
	public void createNewCategory() throws SQLException, ClassNotFoundException {
		logger.info("Running a test to create a new category and compare data in the table and DB");

		// Test data
		String newCategoryTitle = "New Category";
		String selectCategoryTitle = "select category.name from category where name = 'New Category' limit 1";

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Open Categories page
		categories.enterCategoriesPage();

		// Fills all fields and submit the form for new category
		categories.fillAllFieldsForCategory(newCategoryTitle);

		// Open Categories page
		categories.enterCategoriesPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Finds the created category and open information
		categories.findNewCategory(newCategoryTitle);

		// Compare data in the table and DB
		Assertions.assertEquals(newCategory.newCategory(selectCategoryTitle), newCategoryTitle);

		logger.info("The test was successfully passed, the data in the table match data in the DB.");
	}
}
