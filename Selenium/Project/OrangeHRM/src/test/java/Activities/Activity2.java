package Activities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 extends base implements objectRepository{
/*Description
Goal: Print the url of the header image to the console
a. Open a browser.
b. Navigate to ‘http://alchemy.hguy.co/orangehrm’.
c. Get the url of the header image.
d. Print the url to the console.
e. Close the browser.
*/
	Functions fn=new Functions();
	@BeforeClass
	public void load() throws IOException {
		loadProperties();
	}
	@Test
	public void getHeaderUrl() {
	String applicationUrl=pro.getProperty("orangehrm_url");
	launchApp(applicationUrl);
	WebElement logo=fn.getElement(driver, "xpath", objectRepository.img);
	String destURL=logo.getAttribute(objectRepository.srcAttr);
	System.out.println(destURL);
	closeDriver();
	}
}
