package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public static LoginPage using(WebDriver driver) {
		return new LoginPage(driver);
	}

	// Locators for login fields
	By loginName = By.id("username");
	By password = By.id("password");
	By signInButton = By.id("login-signin");

	// Method to enter login
	public LoginPage enterUsername(String userName) {
		driver.findElement(loginName).sendKeys(userName);
		return this;
	}

	// Method to enter password
	public LoginPage enterPassword(String userPassword) {
		driver.findElement(password).sendKeys(userPassword);
		return this;
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

