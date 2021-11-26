package examples;
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
	import java.net.URL;

	import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

	public class real {
	    @Test
	    public void calc() throws InterruptedException, IOException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceId", "62bc3088");
	       // caps.setCapability("deviceName", "mobileSimulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.coloros.calculator");
	        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
	        caps.setCapability("noReset", true);
	        // Instantiate Appium Driver
	        AppiumDriver<MobileElement> driver = null;
	        try {
	            // Initialize driver
	            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	            System.out.println("Calculator is open");
	            driver.findElement(By.id("digit_7")).click();
	            driver.findElementByAccessibilityId("Multiply").click();
	            driver.findElement(By.id("digit_9")).click();
	            driver.findElement(By.id("eq")).click();
	            String result =driver.findElement(By.id("result")).getText();
	            System.out.println("This is the result "+result);
	            
	        } catch (MalformedURLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}


