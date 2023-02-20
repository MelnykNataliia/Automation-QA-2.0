package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketsPage extends BasePage {
	public TicketsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "menu-tickets")
	WebElement tickets;

	@FindBy(id = "OPEN")
	WebElement ticketsOpen;

	@FindBy(id = "IN PROGRESS")
	WebElement ticketsInProgress;

	@FindBy(id = "DONE")
	WebElement ticketsDone;

	@FindBy(id = "stage-total")
	WebElement ticketsTotal;

	@FindBy(id = "stage-closed")
	WebElement ticketsClosed;

	public void enterTickets() {
		tickets.click();
	}

	public void enterTicketsInProgress() {
		ticketsInProgress.click();
	}

	public void enterTicketsDone() {
		ticketsDone.click();
	}

	public void enterTicketsTotal() {
		ticketsTotal.click();
	}

	public void enterTicketsClosed() {
		ticketsClosed.click();
	}
}






