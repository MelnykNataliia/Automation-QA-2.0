package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GlobalHelpers;

import java.util.List;
import java.util.logging.Logger;

public class TicketsPage extends BasePage {
	public TicketsPage(WebDriver driver) {
		super(driver);
	}

	Logger logger = Logger.getLogger(TicketsPage.class.getName());

	// Locators for tickets field
	By ticketsList = By.id("menu-tickets");
	By createNewTicketButton = By.id("create-new-ticket");
	By createNewInnerTicketButton = By.id("new-inner-ticket");
	By ticketInnerTitle = By.id("title");
	By ticketTitle = By.id("title");
	By ticketCategory = By.id("categoryId");
	By ticketStage = By.id("stageId");
	By ticketCompany = By.id("company");
	By ticketContact = By.id("contactId");
	By ticketPriority = By.id("priority");
	By submitNewTicketButton = By.id("submit-btn");
	By submitNewInnerTicketButton = By.id("submit-btn");
	By searchTicket = By.id("search-bar");
	By searchButton = By.xpath("//button[@id='search-bar-submit']");
	By checkNewInnerTicket = By.partialLinkText("Test inner ticket");
	By editTicketButton = By.id("ticket-edit-btn");

	// Locators for title names and values of columns
	public static By titles = By.xpath("//tbody/tr[1]/th[contains(text(),'  ')]");
	public static By valuesID = By.xpath("//tbody/tr/td[2]");
	public static By valuesTitle = By.xpath("//tbody/tr/td[3]/a[1]");
	public static By valuesAssignee = By.xpath("//tbody/tr/td[6]");
	public static By valuesStage = By.xpath("//tbody/tr/td[7]");

	// Method to enter tickets page
	public void enterTicketsPage() {
		logger.info("Navigating to the Tickets page");

		driver.findElement(ticketsList).click();

		logger.info("Navigation to the Tickets page successfully completed");
	}

	// Methods describe actions with elements
	public void fillAllFieldsForTicket(String newTicketTitle, String newTicketCategory, String newTicketStage, String newTicketCompany, String newTicketContact, String newTicketPriority) {
		logger.info("Opening a form to create a new ticket, filling in all fields to create a new ticket and submitting the form");

		driver.findElement(createNewTicketButton).click();
		driver.findElement(ticketTitle).sendKeys(newTicketTitle);
		driver.findElement(ticketCategory).sendKeys(newTicketCategory);
		driver.findElement(ticketStage).sendKeys(newTicketStage);
		driver.findElement(ticketCompany).sendKeys(newTicketCompany);
		driver.findElement(ticketContact).sendKeys(newTicketContact);
		driver.findElement(ticketPriority).sendKeys(newTicketPriority);
		driver.findElement(submitNewTicketButton).click();

		logger.info("New ticket form successfully submitted");
	}

	// Methods describe actions with elements
	public void fillTheFormForInnerTicket(String newInnerTicketTitle) {
		logger.info("Filling in all fields to create a new Inner ticket and submitting the form");

		driver.findElement(createNewTicketButton).click();
		driver.findElement(createNewInnerTicketButton).click();
		driver.findElement(ticketInnerTitle).sendKeys(newInnerTicketTitle);
		driver.findElement(submitNewInnerTicketButton).click();

		logger.info("New Inner ticket form successfully submitted");
	}

	// Method finds the created ticket
	public void findNewTicket(String newTicketTitle) {
		logger.info("Searching for a created ticket");

		driver.findElement(searchTicket).sendKeys(newTicketTitle);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(searchButton).click();

		logger.info("A new ticket was successfully found in the tickets list");
		;
	}

	// Method finds the created Inner ticket
	public void findNewInnerTicket() {
		logger.info("Searching for a created Inner ticket");

		driver.findElement(checkNewInnerTicket).click();

		logger.info("A new Inner ticket was successfully found in the tickets list");
	}

	// Getting list of elements and printing to the console
	public void getAllTitlesAndValues(By webElements) {
		List<WebElement> titleNames = driver.findElements(webElements);
		for (int i = 1; i < titleNames.size(); i++) {
			System.out.println(titleNames.get(i).getText());
		}
	}

	// Method edits the created ticket
	public void editCratedTicket(String newTitle, String newCategory, String newStage) {
		logger.info("Editing a created ticket");

		driver.findElement(editTicketButton).click();
		driver.findElement(ticketTitle).clear();
		driver.findElement(ticketTitle).sendKeys(newTitle);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(ticketCategory).click();
		driver.findElement(ticketCategory).sendKeys(newCategory);
		GlobalHelpers.sleepWait(3000);
		driver.findElement(ticketStage).click();
		driver.findElement(ticketStage).sendKeys(newStage);
		driver.findElement(submitNewTicketButton).click();

		logger.info("The ticket was successfully edit");
	}
}






