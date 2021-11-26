package examples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class practice {
AppiumDriver<MobileElement> driver=null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "mobileSimulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
	    caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	    caps.setCapability("noReset", true);
	    URL appServer= new URL("http://0.0.0.0:4723/wd/hub");
	    driver = new AndroidDriver<MobileElement>(appServer,caps);
	}
	
	@Test
	public void login() throws InterruptedException {
		driver.get("https://www.training-support.net/");
		Thread.sleep(15000);
		driver.findElementByXPath("//android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button").click();
		Thread.sleep(5000);
		MobileElement username=driver.findElementByXPath("//android.view.View/android.widget.EditText[1]");
		username.sendKeys("Ashwin");
		driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password");
		
	}

}
