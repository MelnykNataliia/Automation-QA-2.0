package tests;

import config.ChromeDriverConfiguration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.*;
import testdata.TestData;


public class Task8 extends ChromeDriverConfiguration {
	protected WebDriver driver = ChromeDriverConfiguration.createDriver();
	protected LoginPage login = new LoginPage(driver);
	protected DashboardPage dashboard = new DashboardPage(driver);
	protected TicketsPage tickets = new TicketsPage(driver);
	protected ContactsPage contacts = new ContactsPage(driver);
	protected DepartmentsPage departments = new DepartmentsPage(driver);
	protected CategoriesPage categories = new CategoriesPage(driver);

	@Test
	public void testOpenDashboardPage() {
		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Initialise Element
		PageFactory.initElements(driver, dashboard);

		// Open Dashboard page
		dashboard.enterDashboardPage();
	}

	@Test
	public void testOpenTicketsPage() {
		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Initialise Element
		PageFactory.initElements(driver, tickets);

		// Open Tickets page
		tickets.enterTicketsPage();
	}

	@Test
	public void testOpenContactsPage() {
		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Initialise Element
		PageFactory.initElements(driver, contacts);

		// Open Contacts page
		contacts.enterContactsPage();
	}

	@Test
	public void testOpenDepartmentsPage() {
		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Initialise Element
		PageFactory.initElements(driver, departments);

		// Open Departments page
		departments.enterDepartmentsPage();
	}

	@Test
	public void testOpenCategoriesPage() {
		// Website login
		login.login(TestData.userName, TestData.userPassword);

		// Initialise Element
		PageFactory.initElements(driver, categories);

		// Open Categories page
		categories.enterCategoriesPage();
	}
}