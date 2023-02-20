package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GlobalHelpers;

import java.util.List;

public class TicketsPage extends BasePage {
	public TicketsPage(WebDriver driver) {
		super(driver);
	}

	// Locators for tickets field
	By ticketsList = By.id("menu-tickets");
	By createNewTicketButton = By.id("create-new-ticket");
	By ticketTitle = By.id("title");
	By ticketCategory = By.id("categoryId");
	By ticketStage = By.id("stageId");
	By ticketCompany = By.id("company");
	By ticketContact = By.id("contactId");
	By ticketPriority = By.id("priority");
	By submitNewTicketButton = By.id("submit-btn");
	By searchTicket = By.id("search-bar");
	By searchButton = By.xpath("//button[@id='search-bar-submit']");

	// Locators for title names and values of columns
	public static By titles = By.xpath("//tbody/tr[1]/th[contains(text(),'  ')]");
	public static By valuesID = By.xpath("//tbody/tr/td[2]");
	public static By valuesTitle = By.xpath("//tbody/tr/td[3]/a[1]");
	public static By valuesAssignee = By.xpath("//tbody/tr/td[6]");
	public static By valuesStage = By.xpath("//tbody/tr/td[7]");

	// Method to enter tickets page
	public void enterTicketsPage() {
		driver.findElement(ticketsList).click();
	}

	// Methods describe actions with elements
	public void fillAllFieldsForTicket(String newTicketTitle, String newTicketCategory, String newTicketStage, String newTicketCompany, String newTicketContact, String newTicketPriority) {
		driver.findElement(createNewTicketButton).click();
		driver.findElement(ticketTitle).sendKeys(newTicketTitle);
		driver.findElement(ticketCategory).sendKeys(newTicketCategory);
		driver.findElement(ticketStage).sendKeys(newTicketStage);
		driver.findElement(ticketCompany).sendKeys(newTicketCompany);
		driver.findElement(ticketContact).sendKeys(newTicketContact);
		driver.findElement(ticketPriority).sendKeys(newTicketPriority);
		driver.findElement(submitNewTicketButton).click();
	}

	// Method finds the created ticket
	public void findNewTicket(String newTicketTitle) {
		driver.findElement(searchTicket).sendKeys(newTicketTitle);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(searchButton).click();
	}

	// Getting list of elements and printing to the console
	public void getAllTitlesAndValues(By webElements) {
		List<WebElement> titleNames = driver.findElements(webElements);
		for (int i = 1; i < titleNames.size(); i++) {
			System.out.println(titleNames.get(i).getText());
		}
	}
}






