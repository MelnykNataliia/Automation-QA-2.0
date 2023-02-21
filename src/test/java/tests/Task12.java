package tests;

import config.ChromeDriverConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.WebDriver;
import pageobjects.pages.LoginPage;
import pageobjects.pages.ManagersPage;
import testdata.TestData;
import utils.GlobalHelpers;
import utils.RandomGenerator;

import java.util.HashMap;

public class Task12 extends ChromeDriverConfiguration {
    protected WebDriver driver = ChromeDriverConfiguration.createDriver();
    protected LoginPage login = new LoginPage(driver);
    protected ManagersPage managers = new ManagersPage(driver);

    @RepeatedTest(5)
    public void testManager() {
        HashMap<String, String> hashMap = new HashMap<>();
        RandomGenerator randomManager = new RandomGenerator();

        // Test data
        String firstName = randomManager.getRandomString(7);
        String lastName = randomManager.getRandomString(9);
        String email = randomManager.getRandomEmail(4);
        String department = "Managers";
        int phoneNumber = randomManager.getRandomNumber(10);
        String skype = randomManager.getRandomSkype(11);

        // Website login
        login.login(TestData.userName, TestData.userPassword);

        // Open Managers page
        managers.enterManagersPage();

        // Page load delay
        GlobalHelpers.sleepWait(5000);

        // Saves generated data
        hashMap.put("firstName", firstName);
        hashMap.put("lastName", lastName);
        hashMap.put("email", email);
        hashMap.put("department", department);
        hashMap.put("phoneNumber", Integer.toString(phoneNumber));
        hashMap.put("skype", skype);

        // Fills all fields and submit the form for new manager
        managers.fillAllFieldsForManager(hashMap.get("firstName"), hashMap.get("lastName"), hashMap.get("email"), hashMap.get("department"), hashMap.get("phoneNumber"), hashMap.get("skype"));

        // Finds the created manager and open information
        managers.searchManager(hashMap.get("firstName"));

        // Comparing saved data with field values
        Assertions.assertEquals(driver.findElement(ManagersPage.name).getText(), hashMap.get("firstName") + " " + hashMap.get("lastName"));
        Assertions.assertEquals(driver.findElement(ManagersPage.phone).getText(), hashMap.get("phoneNumber"));
        Assertions.assertEquals(driver.findElement(ManagersPage.skype).getText(), hashMap.get("skype"));
        Assertions.assertEquals(driver.findElement(ManagersPage.department).getText(), hashMap.get("department"));
        Assertions.assertEquals(driver.findElement(ManagersPage.email).getText(), hashMap.get("email"));
    }
}

