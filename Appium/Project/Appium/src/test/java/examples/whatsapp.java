package examples;
	import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

	public class whatsapp {
	    @Test
	    public void calc() throws InterruptedException, IOException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceId", "62bc3088");
	       // caps.setCapability("deviceName", "mobileSimulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.whatsapp");
	        caps.setCapability("appActivity", ".HomeActivity");
	        caps.setCapability("noReset", true);
	        // Instantiate Appium Driver
	        AppiumDriver<MobileElement> driver = null;
	        try {
	            // Initialize driver
	            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	         
	            driver.findElement(By.xpath("//android.widget.TextView[@text='QA Idea 42']")).click();
	            List<MobileElement> ele = driver.findElements(By.id("message_text"));
	            for (MobileElement e:ele) {
	            	System.out.println(e.getText());
	            }
	            
	            
	        } catch (MalformedURLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}


