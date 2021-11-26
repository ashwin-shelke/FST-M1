package Activities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity4 extends base implements objectRepository{
/*Description
Goal: Add emplyee
*/
	Functions fn=new Functions();
	Activity3 at = new Activity3();
	@BeforeClass
	public void load() throws IOException {
		loadProperties();
	}
	@Test(dataProvider = "Authentication")
	public void addEmployee(String username,String password,String firstname,String lastname) throws InterruptedException {
		driver=at.login(username, password);
		/*String applicationUrl=pro.getProperty("orangehrm_url");
		String expectedResult=pro.getProperty("expectedDashTxt");
		launchApp(applicationUrl);
		fn.enterInput(driver, "id", objectRepository.loginUser, username);
		fn.enterInput(driver, "id", objectRepository.loginPassword, password);
		fn.clickElement(driver, "name", objectRepository.submitBtn);
		if(fn.getElementText(driver, "xpath", objectRepository.dashbord).equals(expectedResult)) {
			System.out.println("User login sucessful");
		}else {
			System.out.println("User login is NOT sucessful");
		}*/
		System.out.println("value of driver is "+driver);
		fn.clickElement(driver, "xpath", objectRepository.pim);
		fn.clickElement(driver, "xpath", objectRepository.addEmployee);
		fn.enterInput(driver, "id", objectRepository.firstName, firstname);
		fn.enterInput(driver, "id", objectRepository.lastName, lastname);
		fn.clickElement(driver, "id", objectRepository.saveBtn);
		//Navigate back to the PIM page (Employee List tab) and verify the creation of your	employee.
		fn.clickElement(driver, "id", objectRepository.employeeList);
		fn.enterInput(driver, "id", objectRepository.empName, firstname+" "+lastname);
		fn.clickElement(driver, "id", objectRepository.searchBtn);
		List<WebElement> rows=fn.getElements(driver, "xpath", objectRepository.tblRw);
		Thread.sleep(10000);
		for (int i=1;i<rows.size();i++) {
			String first=fn.getElementText(driver, "xpath", objectRepository.tblRw+"["+i+"]/td[3]");
			String last=fn.getElementText(driver, "xpath", objectRepository.tblRw+"["+i+"]/td[4]");
			if(first.equals(firstname)&&last.equals(lastname)) {
				System.out.println("Employee is available "+first+" "+last);
				Assert.assertTrue(true);
				break;
			}else {
				System.out.println("Employee is NOT available "+first+" "+last);
				Assert.assertTrue(false);
			}
			
		}
		
	}
	@AfterClass
	public void close() {
		closeDriver();
	}
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
	    return new Object[][] { { "orange", "orangepassword123","Sam","Dev" }};
	}
}
