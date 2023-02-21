package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GlobalHelpers;

import java.util.logging.Logger;

public class СompaniesPage extends BasePage {
	public СompaniesPage(WebDriver driver) {
		super(driver);
	}

	Logger logger = Logger.getLogger(СompaniesPage.class.getName());

	// Locators for companies field
	By companiesList = By.id("menu-companies");
	By createNewCompanyButton = By.id("new-company");
	By companyTitle = By.id("name");
	By companyAddInfo = By.id("company-additional-information");
	By companyCountry = By.id("company-country");
	By companyCity = By.id("company-city");
	By companyPhone = By.id("company.phone");
	By companyServiceProgram = By.id("company-sla-level-1");
	By submitNewCompanyButton = By.id("company-submit-btn");
	By checkNewCompany = By.id("name");
	By searchButton = By.id("search-company-submit");

	public static By title = By.xpath("//div[contains(text(),'Company name:')]/following-sibling::div");
	public static By country = By.xpath("//div[contains(text(),'Country:')]/following-sibling::div");
	public static By city = By.xpath("//div[contains(text(),'City:')]/following-sibling::div");
	public static By phone = By.xpath("//div[contains(text(),'Phone:')]/following-sibling::div");

	// Method to enter companies page
	public void enterCompaniesPage() {
		logger.info("Navigating to the Companies page");

		driver.findElement(companiesList).click();

		logger.info("Navigation to the Companies page successfully completed");
	}

	// Methods describe actions with elements
	public void fillAllFieldsForCompany(String newCompanyTitle, String newCompanyCountry, String newCompanyCity, String newCompanyPhone) {
		logger.info("Opening a form to create a new company, filling in all fields to create a new company and submitting the form");

		driver.findElement(createNewCompanyButton).click();
		driver.findElement(companyTitle).sendKeys(newCompanyTitle);
		driver.findElement(companyAddInfo).click();
		driver.findElement(companyCountry).sendKeys(newCompanyCountry);
		driver.findElement(companyCity).sendKeys(newCompanyCity);
		driver.findElement(companyPhone).sendKeys(newCompanyPhone);
		driver.findElement(companyServiceProgram).click();
		driver.findElement(submitNewCompanyButton).click();

		logger.info("New company form successfully submitted");
	}

	// Method finds the created company
	public void findNewCompany(String newCompanyTitle) {
		logger.info("Searching for a created company");

		driver.findElement(checkNewCompany).sendKeys(newCompanyTitle);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(searchButton).click();
		driver.findElement(By.partialLinkText(newCompanyTitle)).click();

		logger.info("A new company was successfully found in the companies list");
	}
}

