package tests;

import config.ChromeDriverConfiguration;
import database.DataBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.pages.LoginPage;
import pageobjects.pages.ManagersPage;
import pageobjects.pages.СompaniesPage;
import testdata.TestData;
import utils.GlobalHelpers;
import utils.ITestListenerClass;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;

@Listeners(ITestListenerClass.class)
public class Task21 extends ChromeDriverConfiguration {
	protected WebDriver driver = ChromeDriverConfiguration.createDriver();
	protected ManagersPage managers = new ManagersPage(driver);
	protected СompaniesPage companies = new СompaniesPage(driver);
	protected DataBase newManager = new DataBase();
	protected DataBase newCompany = new DataBase();

	Logger logger = Logger.getLogger(Task21.class.getName());

	@Test(testName = "createManager")
	public void createNewManager() throws SQLException, ClassNotFoundException {
		logger.info("Running a test to create a new manager and compare the entered value and created parameters in the table \n" +
				"and compare the created parameters and DB parameters in the table");

		HashMap<String, String> hashMap = new HashMap<>();

		// Test data
		String firstName = "Oliver";
		String lastName = "Williams";
		String email = "oli_wi87@gmail.com";
		String department = "Managers";
		String phoneNumber = "+13475474258";
		String skype = "OliWilli_87";

		// Saved data
		hashMap.put("firstName", firstName);
		hashMap.put("lastName", lastName);
		hashMap.put("email", email);
		hashMap.put("department", department);
		hashMap.put("phoneNumber", phoneNumber);
		hashMap.put("skype", skype);

		// SQL Queries
		String selectFullName = "select concat (first_name, ' ', last_name) as full_name\n" +
				"from manager\n" +
				"    join department\n" +
				"        on manager.department_id = department.id\n" +
				"               and first_name = 'Oliver'\n" +
				"               and department.name = 'Managers'\n" +
				"limit 1;";

		String selectEmail = "select manager.login\n" +
				"from manager\n" +
				"where first_name = 'Oliver'\n" +
				"limit 1;";

		String selectDepartment = "select department.name from department\n" +
				"    join manager m\n" +
				"        on department.id = m.department_id\n" +
				"               and m.first_name = 'Oliver'\n" +
				"limit 1;";

		String selectPhoneNumber = "select manager.phone from manager\n" +
				"where first_name = 'Oliver'\n" +
				"limit 1;";

		String selectSkype = "select manager.skype from manager\n" +
				"where first_name = 'Oliver'\n" +
				"limit 1;";

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Open Managers page
		managers.enterManagersPage();

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		// Fill all fields and submit the form for new manager
		managers.fillAllFieldsForManager(hashMap.get("firstName"), hashMap.get("lastName"), hashMap.get("email"), hashMap.get("department"), hashMap.get("phoneNumber"), hashMap.get("skype"));

		// Find the created manager and open information
		managers.searchManager(hashMap.get("firstName"));

		logger.info("Comparing the entered value and created parameters in the table on the managers page using the assertion methods");

		// Comparing the entered value and created parameters in the table on the managers page using the assertion methods
		Assert.assertEquals(driver.findElement(ManagersPage.name).getText(), hashMap.get("firstName") + " " + hashMap.get("lastName"));
		Assert.assertEquals(driver.findElement(ManagersPage.email).getText(), hashMap.get("email"));
		Assert.assertEquals(driver.findElement(ManagersPage.department).getText(), hashMap.get("department"));
		Assert.assertEquals(driver.findElement(ManagersPage.phone).getText(), hashMap.get("phoneNumber"));
		Assert.assertEquals(driver.findElement(ManagersPage.skype).getText(), hashMap.get("skype"));

		logger.info("Comparing was successfully passed, entered value match created parameters in the table");

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		logger.info("Comparing the created parameters and DB parameters in the table on the managers page using the assertion methods");

		// Comparing the created parameters and DB parameters in the table on the managers page using the assertion methods
		Assert.assertEquals(newManager.managerFirstName(selectFullName), hashMap.get("firstName") + " " + hashMap.get("lastName"));
		Assert.assertEquals(newManager.managerEmail(selectEmail), hashMap.get("email"));
		Assert.assertEquals(newManager.managerDepartment(selectDepartment), hashMap.get("department"));
		Assert.assertEquals(newManager.managerPhone(selectPhoneNumber), hashMap.get("phoneNumber"));
		Assert.assertEquals(newManager.managerSkype(selectSkype), hashMap.get("skype"));

		logger.info("Comparing was successfully passed, created parameters match DB parameters in the table");

		logger.info("The test was successfully passed, entered value match created parameters in the table," +
				"created parameters match DB parameters in the table");
	}

	@Test(testName = "createCompany")
	public void createNewCompany() throws SQLException, ClassNotFoundException {
		logger.info("Running a test to create a new company and compare data in the table and DB");

		HashMap<String, String> hashMap = new HashMap<>();

		// Test data
		String newCompanyTitle = "Containerships";
		String newCompanyCountry = "Ukraine";
		String newCompanyCity = "Odesa";
		String newCompanyPhone = "+380482389330";

		// SQL Queries
		String selectCompanyTitle = "select name from company\n" +
				"where name = 'Containerships'\n" +
				"limit 1;";
		String selectCompanyCountry = "select country from company\n" +
				"where name = 'Containerships' \n" +
				"  and company.country is not null\n" +
				"limit 1;";
		String selectCompanyCity = "select city from company\n" +
				"where name = 'Containerships'\n" +
				"  and company.city is not null\n" +
				"limit 1;";
		String selectCompanyPhone = "select phone from company\n" +
				"where name = 'Containerships'\n" +
				"  and company.phone is not null\n" +
				"limit 1;";

		// Saved data
		hashMap.put("title", newCompanyTitle);
		hashMap.put("country", newCompanyCountry);
		hashMap.put("city", newCompanyCity);
		hashMap.put("phone", newCompanyPhone);

		// Website login
		LoginPage.using(driver)
				 .login(TestData.userName, TestData.userPassword);

		// Open Companies page
		companies.enterCompaniesPage();// Page load delay

		// Fill all fields and submit the form for new company
		companies.fillAllFieldsForCompany(hashMap.get("title"), hashMap.get("country"), hashMap.get("city"), hashMap.get("phone"));

		// Check whether a new company has been created
		companies.findNewCompany(hashMap.get("title"));

		logger.info("Comparing the entered value and created parameters in the table on the companies page using the assertion methods");

		// Comparing the entered value and created parameters in the table on the companies page using the assertion methods
		Assert.assertEquals(driver.findElement(СompaniesPage.title).getText(), hashMap.get("title"));
		Assert.assertEquals(driver.findElement(СompaniesPage.country).getText(), hashMap.get("country"));
		Assert.assertEquals(driver.findElement(СompaniesPage.city).getText(), hashMap.get("city"));
		Assert.assertEquals(driver.findElement(СompaniesPage.phone).getText(), hashMap.get("phone"));

		logger.info("Comparing was successfully passed, entered value match created parameters in the table");

		// Page load delay
		GlobalHelpers.sleepWait(5000);

		logger.info("Comparing the created parameters and DB parameters in the table on the companies page using the assertion methods");

		// Comparing the created parameters and DB parameters in the table on the companies page using the assertion methods
		Assert.assertEquals(newCompany.companyTitle(selectCompanyTitle), newCompanyTitle);
		Assert.assertEquals(newCompany.companyCountry(selectCompanyCountry), newCompanyCountry);
		Assert.assertEquals(newCompany.companyCity(selectCompanyCity), newCompanyCity);
		Assert.assertEquals(newCompany.companyPhone(selectCompanyPhone), newCompanyPhone);

		logger.info("Comparing was successfully passed, created parameters match DB parameters in the table");

		logger.info("The test was successfully passed, entered value match created parameters in the table," +
				"created parameters match DB parameters in the table");
	}
}
