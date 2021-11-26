package Activities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity6 extends base implements objectRepository{
/*Description
Verify that the “Directory” menu item is visible and clickable
Goal: Verify that the “Directory” menu item is visible and clickable
*/
	Functions fn=new Functions();
	Activity3 at = new Activity3();
	@BeforeClass
	public void load() throws IOException {
		loadProperties();
	}
	@Test(dataProvider = "Authentication")
	public void directoryMenuCheck(String username,String password) throws InterruptedException {
		driver=at.login(username, password);
		Thread.sleep(10000);
		WebElement menu=fn.getElement(driver, "xpath", objectRepository.menu);
		List<WebElement> list=menu.findElements(By.tagName("li"));
		for( WebElement we:list){
			System.out.println(we.getText());
			if (we.getText().equals("Directory")) {
				if(we.isDisplayed()) {
					Assert.assertTrue(true);
					if(we.isEnabled()) {
						Assert.assertTrue(true);
						we.click();
						if(fn.getElementText(driver, "xpath", objectRepository.dashbord).equals("Search Directory")) {
							System.out.println("correct text is dialay");
							Assert.assertTrue(true);
							break;
						}else {
							Assert.assertTrue(false);
						}
					}else {
						Assert.assertTrue(false);
					}
				}else{
					Assert.assertTrue(false);
				}
			}
			
		}
		
		
		
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
