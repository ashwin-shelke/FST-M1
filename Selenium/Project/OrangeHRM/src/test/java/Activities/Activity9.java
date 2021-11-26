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

public class Activity9 extends base implements objectRepository{
/*Description
Goal: Login and retrieve the emergency contacts for the user
*/
	Functions fn=new Functions();
	Activity3 at = new Activity3();
	@BeforeClass
	public void load() throws IOException {
		loadProperties();
	}
	@Test(dataProvider = "Authentication")
	public void getEmergencyContacts(String username,String password) throws InterruptedException {
		driver=at.login(username, password);
		Thread.sleep(10000);
		fn.clickElement(driver, "id", objectRepository.myInfo);
		
		Thread.sleep(10000);
		
		WebElement lst=fn.getElement(driver, "id", objectRepository.infoList);
		List<WebElement>listItems=lst.findElements(By.tagName("li"));
		for (WebElement ele:listItems) {
			System.out.println(ele.getText());
			if (ele.getText().equals("Emergency Contacts")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(10000);
		
		List<WebElement> rows=fn.getElements(driver, "xpath", objectRepository.emerRw);
		List<WebElement> col=fn.getElements(driver, "xpath", objectRepository.emerCl);
		
		for (int i=1;i<=rows.size();i++) {
			for (int j=2;j<=col.size();j++) {
				String dateApp=fn.getElementText(driver, "xpath", objectRepository.emerRw+"["+i+"]/td["+j+"]");
				System.out.println(dateApp);
				
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
