package Activities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity5 extends base implements objectRepository{
/*Description
Goal: Goal: Edit a user’s information
*/
	Functions fn=new Functions();
	Activity3 at = new Activity3();
	@BeforeClass
	public void load() throws IOException {
		loadProperties();
	}
	@Test(dataProvider = "Authentication")
	public void addEmployee(String username,String password,String firstname,String lastname,String nationality,String Month,String Year,String date) throws InterruptedException {
		driver=at.login(username, password);
		Thread.sleep(15000);
		//fn.WebDriverwait(driver, "id", objectRepository.myInfo);
		//Find the “My Info” menu item and click it.
		fn.clickElement(driver, "id", objectRepository.myInfo);
		//click on Edit button
		Thread.sleep(10000);
		fn.clickElement(driver, "id", objectRepository.saveBtn);
		//Fill in the Name, Gender, Nationality, and the DOB fields.
		fn.clearText(driver, "name", objectRepository.editFirstName);
		fn.enterInput(driver, "name", objectRepository.editFirstName, firstname);
		fn.clearText(driver, "name", objectRepository.editLastName);
		fn.enterInput(driver, "name", objectRepository.editLastName, lastname);
		fn.clickElement(driver, "id", objectRepository.editGender);
		fn.selectDropdownValue(driver, "id", objectRepository.nationality, nationality);
		//select date
		fn.clickElement(driver, "name", objectRepository.dob);
		Thread.sleep(5000);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calMonth, Month);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calYear, Year);
		List<WebElement> rows=fn.getElements(driver, "xpath", objectRepository.calRow);
		List<WebElement> col=fn.getElements(driver, "xpath", objectRepository.calCol);
		
		for (int i=1;i<=rows.size();i++) {
			for (int j=1;j<=col.size();j++) {
				String dateApp=fn.getElementText(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
				System.out.println(dateApp);
				if(dateApp.equals(date)) {
					fn.clickElement(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
					break;
				}
			}
		}
		
		Thread.sleep(5000);
		fn.clickElement(driver, "id", objectRepository.saveBtn);
		
		
	}
	@AfterClass
	public void close() {
		closeDriver();
	}
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
	    return new Object[][] { { "orange", "orangepassword123","Bill","Bush","Indian","Feb","1947","15" }};
	}
}
