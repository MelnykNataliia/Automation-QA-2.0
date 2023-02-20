package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-signin")
	WebElement signInButton;

	public void userName(String userName) {
		username.sendKeys(userName);
	}

	public void userPassword(String userPassword) {
		password.sendKeys(userPassword);
		signInButton.click();
	}
}

