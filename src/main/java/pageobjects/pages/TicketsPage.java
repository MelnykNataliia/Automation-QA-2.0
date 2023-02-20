package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TicketsPage extends BasePage {
	public TicketsPage(WebDriver driver) {
		super(driver);
	}

	// Locators for tickets field
	By ticketsList = By.id("menu-tickets");

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

	// Getting list of elements and printing to the console
	public void getAllTitlesAndValues(By webElements) {
		List<WebElement> titleNames = driver.findElements(webElements);
		for (int i = 1; i < titleNames.size(); i++) {
			System.out.println(titleNames.get(i).getText());
		}
	}
}






