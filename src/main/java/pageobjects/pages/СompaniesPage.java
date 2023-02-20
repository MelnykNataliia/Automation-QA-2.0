package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GlobalHelpers;

public class СompaniesPage extends BasePage {
	public СompaniesPage(WebDriver driver) {
		super(driver);
	}

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

	// Method to enter companies page
	public void enterCompaniesPage() {
		driver.findElement(companiesList).click();
	}

	// Methods describe actions with elements
	public void fillAllFieldsForCompany(String newCompanyTitle, String newCompanyCountry, String newCompanyCity, String newCompanyPhone) {
		driver.findElement(createNewCompanyButton).click();
		driver.findElement(companyTitle).sendKeys(newCompanyTitle);
		driver.findElement(companyAddInfo).click();
		driver.findElement(companyCountry).sendKeys(newCompanyCountry);
		driver.findElement(companyCity).sendKeys(newCompanyCity);
		driver.findElement(companyPhone).sendKeys(newCompanyPhone);
		driver.findElement(companyServiceProgram).click();
		driver.findElement(submitNewCompanyButton).click();
	}

	// Method finds the created company
	public void findNewCompany(String newCompanyTitle) {
		driver.findElement(checkNewCompany).sendKeys(newCompanyTitle);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(searchButton).click();
		driver.findElement(By.partialLinkText(newCompanyTitle)).click();
	}
}

