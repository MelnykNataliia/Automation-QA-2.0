package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "menu-dashboard")
	WebElement dashboard;

	@FindBy(id = "dashboard-reaction")
	WebElement dashboardReaction;

	@FindBy(id = "dashboard-done")
	WebElement dashboardDone;

	public void enterDashboardPage() {
		dashboard.click();
	}

	public void enterDashboardReaction() {
		dashboardReaction.click();
	}

	public void enterDashboardDone() {
		dashboardDone.click();
	}
}