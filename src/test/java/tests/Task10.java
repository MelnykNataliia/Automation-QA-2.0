package tests;

import config.ChromeDriverConfiguration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.pages.DepartmentsPage;
import pageobjects.pages.LoginPage;
import pageobjects.pages.TicketsPage;
import pageobjects.pages.СompaniesPage;
import testdata.TestData;
import utils.GlobalHelpers;


public class Task10 extends ChromeDriverConfiguration {
	protected WebDriver driver = ChromeDriverConfiguration.createDriver();
	protected LoginPage login = new LoginPage(driver);
	protected TicketsPage tickets = new TicketsPage(driver);
	protected DepartmentsPage departments = new DepartmentsPage(driver);
	protected СompaniesPage companies = new СompaniesPage(driver);

	@Test
	public void createNewTicket() {
		// Test data
		String newTicketTitle = "New Ticket";
		String newTicketCategory = "Test";
		String newTicketStage = "OPEN";
		String newTicketCompany = "Snowball";
		String newTicketContact = "Nataliia Melnyk";
		String newTicketPriority = "P4";

		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Fills all fields and submit the form for new ticket
		tickets.fillAllFieldsForTicket(newTicketTitle, newTicketCategory, newTicketStage, newTicketCompany, newTicketContact, newTicketPriority);

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Checks whether a new ticket has been created
		tickets.findNewTicket(newTicketTitle);
	}

	@Test
	public void createNewDepartment() {
		// Test data
		String newDepartmentTitle = "Logistics Department";
		String newDepartmentPhone = "+44 (0)20 3893 3066";
		String newDepartmentEmail = "logisticsnowball@gmail.com";
		String newDepartmentCountry = "UK";
		String newDepartmentCity = "London";

		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Open Departments page
		departments.enterDepartmentsPage();

		// Fills all fields and submit the form for new department
		departments.fillAllFieldsForDepartment(newDepartmentTitle, newDepartmentPhone, newDepartmentEmail, newDepartmentCountry, newDepartmentCity);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Checks whether a new department has been created
		departments.findNewDepartment();
	}

	@Test
	public void createNewCompany() {
		// Test data
		String newCompanyTitle = "Logistic Ltd";
		String newCompanyCountry = "UK";
		String newCompanyCity = "London";
		String newCompanyPhone = "+44 (0)20 3893 3066";

		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Open Companies page
		companies.enterCompaniesPage();

		// Fills all fields and submit the form for new company
		companies.fillAllFieldsForCompany(newCompanyTitle, newCompanyCountry, newCompanyCity, newCompanyPhone);

		// Page load delay
		GlobalHelpers.sleepWait(3000);

		// Checks whether a new company has been created
		companies.findNewCompany(newCompanyTitle);
	}
}
