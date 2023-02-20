package tests;

import config.ChromeDriverConfiguration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.pages.DashboardPage;
import pageobjects.pages.LoginPage;
import pageobjects.pages.TicketsPage;
import testdata.TestData;
import utils.GlobalHelpers;


public class Task9 extends ChromeDriverConfiguration {
    protected WebDriver driver = ChromeDriverConfiguration.createDriver();
    protected LoginPage login = new LoginPage(driver);
    protected TicketsPage tickets = new TicketsPage(driver);
    protected DashboardPage dashboard = new DashboardPage(driver);


    @Test
    // Test prints to console title names and values of columns
    public void printTitleNamesAndValues() {

        // Website login
        login.login(TestData.userName, TestData.userPassword);

        // Prints to the console all title names
        tickets.getAllTitlesAndValues(TicketsPage.titles);

        // Prints to the console values of ID column
        tickets.getAllTitlesAndValues(TicketsPage.valuesID);

        // Prints to the console values of Title column
        tickets.getAllTitlesAndValues(TicketsPage.valuesTitle);

        // Prints to the console values of Assignee column
        tickets.getAllTitlesAndValues(TicketsPage.valuesAssignee);

        // Prints to the console values of Stage column
        tickets.getAllTitlesAndValues(TicketsPage.valuesStage);
    }

    @Test
    // Test prints to console title names for category Development and Finance
    public void printTitleNamesAndID() {
        // Website login
        login.login(TestData.userName, TestData.userPassword);

        // Test data
        String development = "РАЗРАБОТКА";
        String finance = "ФИНАНСЫ";

        // Open Dashboard page (Deadline is over)
        dashboard.getDeadLineIsOver();

        // Page load delay
        GlobalHelpers.sleepWait(3000);

        // Prints to the console all title names for Category = "Разработка"
        System.out.println("РАЗРАБОТКА:");
        dashboard.getTitleNamesAndId(DashboardPage.categories, DashboardPage.titleNames, development);

        // Prints to the console all title names for Category = "Финансы"
        System.out.println("ФИНАНСЫ:");
        dashboard.getTitleNamesAndId(DashboardPage.categories, DashboardPage.titleNames, finance);
    }

    @Test
    // Test prints to console ID for Priority P3
    public void printTitleNamesAndIDForP3() {
        // Website login
        login.login(TestData.userName, TestData.userPassword);

        // Test data
        String priorityP3 = "P3";

        // Open Dashboard page (Deadline is over)
        dashboard.getDeadLineIsOver();

        // Page load delay
        GlobalHelpers.sleepWait(5000);

        // Prints to the console all ID of Priority = P3
        System.out.println("P3:");
        dashboard.getTitleNamesAndId(DashboardPage.priority, DashboardPage.id, priorityP3);
    }
}