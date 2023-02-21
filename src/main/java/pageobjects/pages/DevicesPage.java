package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GlobalHelpers;

import java.util.logging.Logger;

public class DevicesPage extends BasePage {
	public DevicesPage(WebDriver driver) {
		super(driver);
	}

	public static DevicesPage using(WebDriver driver) {
		return new DevicesPage(driver);
	}

	// Locators for devices fields
	By devices = By.id("menu-device-list");
	By newDevice = By.id("device-list-new-device");
	By title = By.id("name");
	By ip = By.id("ip");
	By port = By.id("port");
	By password = By.id("password");
	By contact = By.id("device-form-contact-select");
	By company = By.id("device-form-company-select");

	// Method to enter devices page
	public DevicesPage enterDevicesPage() {
		driver.findElement(devices).click();
		return this;
	}

	public DevicesPage newDeviceButton() {
		driver.findElement(newDevice).click();
		return this;
	}

	public static class Builder {
		public DevicesPage newDevice;

		public Builder() {
			newDevice = new DevicesPage(driver);
		}

		public Builder withTitle(String name) {
			driver.findElement(newDevice.title).sendKeys(name);
			return this;
		}

		public Builder withIp(String deviceIp) {
			driver.findElement(newDevice.ip).sendKeys(deviceIp);
			return this;
		}

		public Builder withPort(String devicePort) {
			GlobalHelpers.sleepWait(3000);
			driver.findElement(newDevice.port).sendKeys(devicePort);
			return this;
		}

		public Builder withPassword(String devicePassword) {
			driver.findElement(newDevice.password).sendKeys(devicePassword);
			return this;
		}

		public Builder withContact(String deviceContact) {
			driver.findElement(newDevice.contact).sendKeys(deviceContact);
			return this;
		}

		public Builder withCompany(String deviceCompany) {
			driver.findElement(newDevice.company).sendKeys(deviceCompany);
			return this;
		}

		public DevicesPage build() {
			return newDevice;
		}
	}
}
