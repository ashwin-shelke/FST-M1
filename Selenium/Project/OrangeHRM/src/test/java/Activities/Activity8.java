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

public class Activity8 extends base implements objectRepository{
/*Description
Goal - Add qualification
*/
	Functions fn=new Functions();
	Activity3 at = new Activity3();
	@BeforeClass
	public void load() throws IOException {
		loadProperties();
	}
	@Test(dataProvider = "Authentication")
	public void applyLeave(String username,String password,String leavetype,String fromMonth,String fromDate,String fromYear,String toMonth,String toDate,String toYear) throws InterruptedException {
		driver=at.login(username, password);
		Thread.sleep(10000);
		fn.clickElement(driver, "xpath", objectRepository.applyLeave);
		fn.selectDropdownValue(driver, "id", objectRepository.leaveType, leavetype);
		
		//click on Edit button
		Thread.sleep(10000);
		
		//select from date
		fn.clickElement(driver, "id",objectRepository.leaveFrom);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calMonth, fromMonth);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calYear, fromYear);
		List<WebElement> rows=fn.getElements(driver, "xpath", objectRepository.calRow);
		List<WebElement> col=fn.getElements(driver, "xpath", objectRepository.calCol);
		
		for (int i=1;i<=rows.size();i++) {
			for (int j=1;j<=col.size();j++) {
				String dateApp=fn.getElementText(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
				System.out.println(dateApp);
				if(dateApp.equals(fromDate)) {
					fn.clickElement(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
					break;
				}
			}
		}
		
		fn.clickElement(driver, "id",objectRepository.leaveTo);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calMonth, toMonth);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calYear, toYear);
		List<WebElement> ro=fn.getElements(driver, "xpath", objectRepository.calRow);
		List<WebElement> co=fn.getElements(driver, "xpath", objectRepository.calCol);
		for (int x=1;x<=ro.size();x++) {
			for (int y=1;y<=co.size();y++) {
				String dateApp=fn.getElementText(driver, "xpath", objectRepository.calRow+"["+x+"]/td["+y+"]");
				System.out.println(dateApp);
				if(dateApp.equals(toDate)) {
					fn.clickElement(driver, "xpath", objectRepository.calRow+"["+x+"]/td["+y+"]");
					break;
				}
			}
		}
		
		fn.clickElement(driver, "id", objectRepository.applyBtn);
		
		fn.clickElement(driver, "id", objectRepository.myleaves);
		//search leave period
		fn.clickElement(driver, "id", objectRepository.cFrom);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calMonth, fromMonth);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calYear, fromYear);
		List<WebElement> r=fn.getElements(driver, "xpath", objectRepository.calRow);
		List<WebElement> c=fn.getElements(driver, "xpath", objectRepository.calCol);
		
		for (int i=1;i<=r.size();i++) {
			for (int j=1;j<=c.size();j++) {
				String dateApp=fn.getElementText(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
				System.out.println(dateApp);
				if(dateApp.equals(fromDate)) {
					fn.clickElement(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
					break;
				}
			}
		}
		
		fn.clickElement(driver, "id", objectRepository.cTo);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calMonth, toMonth);
		fn.selectDropdownValue(driver, "xpath", objectRepository.calYear, toYear);
		List<WebElement> rc=fn.getElements(driver, "xpath", objectRepository.calRow);
		List<WebElement> cc=fn.getElements(driver, "xpath", objectRepository.calCol);
		
		for (int i=1;i<=rc.size();i++) {
			for (int j=1;j<=cc.size();j++) {
				String dateApp=fn.getElementText(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
				System.out.println(dateApp);
				if(dateApp.equals(toDate)) {
					fn.clickElement(driver, "xpath", objectRepository.calRow+"["+i+"]/td["+j+"]");
					break;
				}
			}
		}
		//search
		fn.clickElement(driver, "id", objectRepository.search);
		//check in the result grid
		List<WebElement> num=fn.getElements(driver, "xpath", objectRepository.tblRw);
		for (int i=1;i<num.size();i++) {
			String status=fn.getElementText(driver, "xpath", objectRepository.tblRw+"["+i+"]/td[6]");
			System.out.println("Leave status "+status);
		}
		
		
	}
	@AfterClass
	public void close() {
		closeDriver();
	}
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
	    return new Object[][] { { "orange", "orangepassword123","privilege leaves","Oct","25","2021","Oct","28","2021" }};
	}
}
