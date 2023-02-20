package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locator for login field
	By loginName = By.id("username");

	// Locator for password field
	By password = By.id("password");

	// Locator for signIn button
	By signInButton = By.id("login-signin");

	// Method to enter login
	public void enterUsername(String userName) {
		driver.findElement(loginName).sendKeys(userName);
	}

	// Method to enter password
	public void enterPassword(String userPassword) {
		driver.findElement(password).sendKeys(userPassword);
	}

	// Method to click on signIn button
	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}

	public void login(String userName, String userPassword) {
		// Enter login & password
		this.enterUsername(userName);
		this.enterPassword(userPassword);

		// Click on signIn button
		this.clickSignIn();
	}
}

