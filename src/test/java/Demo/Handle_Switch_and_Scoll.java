package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class Handle_Switch_and_Scoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

			// Scroll to an element and retrieve its text
			String scrollToText = "Switches"; // Text to scroll to
			WebElement switchElement = driver
					.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
							+ ".scrollIntoView(new UiSelector().text(\"" + scrollToText + "\"));"));
			switchElement.click();

			// On Monitored Switch
			driver.findElement(By.id("io.appium.android.apis:id/monitored_switch")).click();

			// Simulate pressing the back button to return to the previous screen
			((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));

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
