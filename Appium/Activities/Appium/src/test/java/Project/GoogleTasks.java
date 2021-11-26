package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class GoogleTasks {
	 WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;

	    @BeforeTest
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "mobileSimulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, 20);
	    }
	    
	    @Test(dataProvider = "Data")
	    public void createTask(String task) {
	    	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	driver.findElement(By.id("tasks_fab")).click();
	    	driver.findElement(By.id("add_task_title")).sendKeys(task);
	    	driver.findElement(By.id("add_task_done")).click();
	    	//get the added activity and get's it's text and compare with the taskname
	    	String Actual=driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='"+task+"']/android.view.ViewGroup/android.widget.TextView")).getText();
	    	Assert.assertEquals(task, Actual);
	    	
	    	
	    }
	    
	    @AfterClass
	    public void close() {
	    	driver.quit();
	    }
	    
	    
	    @DataProvider(name = "Data")
		public static Object[][] credentials() {
		    return new Object[][] { { "Complete Activity with Google Tasks" },{ "Complete Activity with Google Keep" },{ "Complete the second Activity Google Keep" }};
		}

}
