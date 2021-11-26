package Activities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity3 extends base implements objectRepository{
/*Description
Goal: Open the site and login with the credentials provided
a. Open the browser to the login page of OrangeHRM site.
b. Find and select the username and password fields
c. Enter login credentials into the respective fields
d. Click login
e. Verify that the homepage has opened.
f. Close the browser.
*/
	Functions fn=new Functions();
	@BeforeClass
	public void load() throws IOException {
		loadProperties();
	}
	@Test(dataProvider = "Authentication")
	public void callLogin(String username,String password) {
		driver=login(username,password);
	}
	
	//@Test(priority=1,dataProvider = "Authentication")
	public WebDriver login(String username,String password) {
	String applicationUrl=pro.getProperty("orangehrm_url");
	String expectedResult=pro.getProperty("expectedDashTxt");
	launchApp(applicationUrl);
	
	fn.enterInput(driver, "id", objectRepository.loginUser, username);
	fn.enterInput(driver, "id", objectRepository.loginPassword, password);
	fn.clickElement(driver, "name", objectRepository.submitBtn);
	if(fn.getElementText(driver, "xpath", objectRepository.dashbord).equals(expectedResult)) {
		System.out.println("User login sucessful");
	}else {
		System.out.println("User login is NOT sucessful");
	}
	return driver;
	}
	@AfterClass
	public void close() {
		closeDriver();
	}
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
	    return new Object[][] { { "orange", "orangepassword123" }};
	}
}
