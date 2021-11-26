package examples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FirstProgram {
	AppiumDriver<MobileElement> driver=null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "mobileSimulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.calculator2");
	    caps.setCapability("appActivity", ".Calculator");
	    caps.setCapability("noReset", true);
	    URL appServer= new URL("http://0.0.0.0:4723/wd/hub");
	    driver = new AndroidDriver<MobileElement>(appServer,caps);
	}
	
	@Test
	public void addition() {
		MobileElement ele=driver.findElementById("digit_7");
		ele.click();
		MobileElement plus=driver.findElementByAccessibilityId("plus");
		plus.click();
		driver.findElementById("digit_9").click();
		MobileElement equal=driver.findElementById("eq");
		equal.click();
		MobileElement result=driver.findElementById("result");
		System.out.println("Result is "+result.getText());
	}
	
	@AfterClass
	public void afterClass() {
		//driver.close();
		driver.quit();
	}

}
