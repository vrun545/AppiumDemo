package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class BrowserApp {

	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "14"); // Replace with your device version
		caps.setCapability("deviceName", "5DYXLFEECUPRFA69"); // Replace with your device ID
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("chromedriverExecutable", "C:\\Users\\varunbajpai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");;

		AppiumDriver driver = null;
		try {
			// Initialize Appium Driver
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
			System.out.println("Chrome App launched!");
			
			//chrome://inspect/#devices    -> for inspect element on Real Mobile Device   
					
			driver.get("https://www.google.com/");
			Thread.sleep(2000);
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Nifty 50");
			searchBox.sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()=\"Compare\"]")).click();
			Thread.sleep(2000);
			

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
