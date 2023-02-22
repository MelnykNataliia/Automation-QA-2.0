package pageobjects.pages.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.$;

public class BasePage_Selenide {
	public static final SelenideElement loginName = $("#username");
	public static final SelenideElement password = $("#password");
	public static final SelenideElement signInButton = $("#login-signin");


	public void setUp() {
		WebDriverManager.chromedriver().setup();
		Configuration.browser = "chrome";
		Configuration.driverManagerEnabled = true;
		Configuration.browserSize = "1366x768";
		Configuration.headless = false;
	}

	public static void open(){
		Selenide.open("http://176.36.27.131:8180/#/login");
	}

	public static void login(String userName, String userPassword) {
		loginName.sendKeys(userName);
		password.sendKeys(userPassword);
		signInButton.click();
	}

	@Before
	public void init(){
		setUp();
	}

	@After
	public void tearDown(){
		try {
			Thread.sleep(5000);
		} catch (
				InterruptedException e) {
			e.printStackTrace();
		}
		Selenide.closeWebDriver();
	}
}
