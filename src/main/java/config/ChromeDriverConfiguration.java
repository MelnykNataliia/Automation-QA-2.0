package config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.BasePage;
import pageobjects.pages.LoginPage;
import testdata.TestData;

import static pageobjects.pages.BasePage.driver;

public class ChromeDriverConfiguration {
	public static WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	protected BasePage basePage = new BasePage(driver);
	protected LoginPage userName = new LoginPage(driver);
	protected LoginPage userPassword = new LoginPage(driver);
	protected TestData testData = new TestData();

	@BeforeEach
	public void open() {
		// Navigate to url
		basePage.open("http://176.36.27.131:8180/#/login");

		//Initialise Elements
		PageFactory.initElements(driver, userName);
		PageFactory.initElements(driver, userPassword);

		// Open login page
		userName.userName(testData.getUsername());
		userPassword.userPassword(testData.getPassword());
	}

	@AfterEach
	public void close() {
		try {
			Thread.sleep(5000);
		} catch (
				InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

