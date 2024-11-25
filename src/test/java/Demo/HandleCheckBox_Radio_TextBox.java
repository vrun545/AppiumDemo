package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HandleCheckBox_Radio_TextBox {
	public static void main(String[] args) {
		// Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "14"); // Replace with your device version
		caps.setCapability("deviceName", "5DYXLFEECUPRFA69"); // Replace with your device ID
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "io.appium.android.apis"); // Verify your app package
		caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos"); // Verify your app activity
		caps.setCapability("noReset", true); // To keep the app in its current state

		AppiumDriver driver = null;
		try {
			// Initialize Appium Driver
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

			System.out.println("Demo App launched!");
			System.out.println("Application Started");

			// click on views
			driver.findElements(By.id("android:id/text1")).get(11).click();
			// click on controls
			driver.findElements(By.id("android:id/text1")).get(4).click();
			// click on light theme
			driver.findElements(By.id("android:id/text1")).get(0).click();
			// text box
			driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Varun Bajpai");
			// click checkbox
			driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
			// click Radio button
			driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();
			// click Star button
			driver.findElement(By.id("io.appium.android.apis:id/star")).click();
			// click Toggle button
			driver.findElement(By.id("io.appium.android.apis:id/toggle2")).click();
			// click Dropdown button
			driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
			Thread.sleep(2000);
			// Select Mars button
			driver.findElements(By.id("android:id/text1")).get(3).click();

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
