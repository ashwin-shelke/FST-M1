package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleKeep {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "mobileSimulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 20);
	}

	@Test(dataProvider = "Data")
	public void createNote(String title, String desc) throws InterruptedException {
		boolean flag = false;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("new_note_button")).click();
		driver.findElement(By.id("editable_title")).sendKeys(title);
		driver.findElement(By.id("edit_note_text")).sendKeys(desc);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		// String
		// getActualNote=driver.findElement(By.xpath("//androidx.cardview.widget.CardView[@content-desc='"+title+".
		// "+desc+".']/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
		Thread.sleep(5000);
		List<MobileElement> ele = driver.findElements(By.id("index_note_text_description"));
		for (MobileElement el : ele) {
			System.out.println(el.getText());
			if (el.getText().equals(desc)) {
				flag = true;
				break;
			}

		}
		Assert.assertTrue(flag);

		// System.out.println();
		// Assert.assertEquals(getActualNote, title+" "+desc);
	}

	
	 @AfterClass
	    public void close() {
	    	driver.quit();
	    }
	 
	@DataProvider(name = "Data")
	public static Object[][] credentials() {
		return new Object[][] { { "First Title", "Next Description" } };
	}

}
