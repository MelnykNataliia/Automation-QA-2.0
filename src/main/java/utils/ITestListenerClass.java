package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pageobjects.pages.BasePage.driver;

public class ITestListenerClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		Method method = result.getMethod().getConstructorOrMethod().getMethod();
		Test test = method.getAnnotation(Test.class);
		String testName = test.testName();

		captureScreenshot(testName + "_");
	}

	private void captureScreenshot(String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("src/main/java/captureScreenshot/" + fileName + timestamp() + ".png");
		try {
			FileUtils.copyFile(src, destFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
	}

	private static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd; HH-mm-ss").format(new Date());
	}
}