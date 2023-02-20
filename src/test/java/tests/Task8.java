package tests;

import config.ChromeDriverConfiguration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.*;


public class Task8 extends ChromeDriverConfiguration {
	protected WebDriver driver = ChromeDriverConfiguration.createDriver();
	protected DashboardPage dashboard = new DashboardPage(driver);
	protected TicketsPage tickets = new TicketsPage(driver);
	protected ContactsPage contacts = new ContactsPage(driver);
	protected DepartmentsPage departments = new DepartmentsPage(driver);
	protected CategoriesPage categories = new CategoriesPage(driver);

	private void login(LoginPage userName, LoginPage userPassword) {
	}

	@Test
	public void testOpenDashboardPage() {
		// Website login
		login(userName, userPassword);

		// Initialise Element
		PageFactory.initElements(driver, dashboard);

		// Open Dashboard page
		dashboard.enterDashboardPage();
	}

	@Test
	public void testOpenTicketsPage() {
		// Website login
		login(userName, userPassword);

		// Initialise Element
		PageFactory.initElements(driver, tickets);

		// Open Tickets page
		tickets.enterTickets();
	}

	@Test
	public void testOpenContactsPage() {
		// Website login
		login(userName, userPassword);

		// Initialise Element
		PageFactory.initElements(driver, contacts);

		// Open Contacts page
		contacts.enterContacts();
	}

	@Test
	public void testOpenDepartmentsPage() {
		// Website login
		login(userName, userPassword);

		// Initialise Element
		PageFactory.initElements(driver, departments);

		// Open Departments page
		departments.enterDepartments();
	}

	@Test
	public void testOpenCategoriesPage() {
		// Website login
		login(userName, userPassword);

		// Initialise Element
		PageFactory.initElements(driver, categories);

		// Open Categories page
		categories.enterCategories();
	}
}