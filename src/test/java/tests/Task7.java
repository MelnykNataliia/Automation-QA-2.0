package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Task7 {
	@Test
	// Login to the website in Chrome browser using XPath locators
	public void testLoginWebsiteInChromeBrowser() throws IOException {
		File src = new File("src/main/java/pageobjects/repo/Object_Repo.properties");
		FileInputStream objfile = new FileInputStream(src);
		Properties obj = new Properties();
		obj.load(objfile);

		InputStream input = new FileInputStream("src/main/java/config/config.properties");
		Properties prop = new Properties();
		prop.load(input);

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		WebElement username = driver.findElement(By.xpath(obj.getProperty("loginUsername")));
		WebElement password = driver.findElement(By.xpath(obj.getProperty("loginPassword")));
		WebElement signIn = driver.findElement(By.xpath(obj.getProperty("buttonSignIn")));

		username.sendKeys(prop.getProperty("login"));
		password.sendKeys(prop.getProperty("password"));
		signIn.click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

	@Test
	// Login to the website in Firefox browser using XPath locators
	public void testLoginWebsiteInFirefoxBrowser() throws IOException {
		File src = new File("src/main/java/pageobjects/repo/Object_Repo.properties");
		FileInputStream objfile = new FileInputStream(src);
		Properties obj = new Properties();
		obj.load(objfile);

		InputStream input = new FileInputStream("src/main/java/config/config.properties");
		Properties prop = new Properties();
		prop.load(input);

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		WebElement username = driver.findElement(By.xpath(obj.getProperty("loginUsername")));
		WebElement password = driver.findElement(By.xpath(obj.getProperty("loginPassword")));
		WebElement signIn = driver.findElement(By.xpath(obj.getProperty("buttonSignIn")));

		username.sendKeys(prop.getProperty("login"));
		password.sendKeys(prop.getProperty("password"));
		signIn.click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

