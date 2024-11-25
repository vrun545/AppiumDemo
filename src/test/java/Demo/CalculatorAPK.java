package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorAPK {
	public static void main(String[] args) {
		// Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "14"); // Replace with your device version
		caps.setCapability("deviceName", "5DYXLFEECUPRFA69"); // Replace with your device ID
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.oneplus.calculator"); // Verify your app package
		caps.setCapability("appActivity", "com.android.calculator2.Calculator"); // Verify your app activity
		caps.setCapability("noReset", true); // To keep the app in its current state

		AppiumDriver driver = null;

		try {
			// Initialize Appium Driver
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

			System.out.println("Calculator app launched!");
			System.out.println("Application Started");

			// Element locators (constants)
			String digit8Id = "com.oneplus.calculator:id/digit_8";
			String opAddId = "com.oneplus.calculator:id/op_add";
			String digit2Id = "com.oneplus.calculator:id/digit_2";
			String equalId = "com.oneplus.calculator:id/img_eq";
			String resultId = "com.oneplus.calculator:id/result";

			// Interact with the calculator
			driver.findElement(By.id(digit8Id)).click();
			driver.findElement(By.id(opAddId)).click();
			driver.findElement(By.id(digit2Id)).click();
			driver.findElement(By.id(equalId)).click();

			// Fetch and print the result
			WebElement result = driver.findElement(By.id(resultId));
			System.out.println("Result: " + result.getText());

		} catch (MalformedURLException e) {
			System.out.println("Invalid Appium server URL");
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found. Please check your element locators.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred while automating the Calculator app");
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
				System.out.println("Driver closed successfully.");
			}
		}
	}
}
