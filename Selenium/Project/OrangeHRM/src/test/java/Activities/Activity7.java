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

public class Activity7 extends base implements objectRepository{
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
	public void updateQualification(String username,String password,String company,String job,String fromMonth,String fromDate,String fromYear,String toMonth,String toDate,String toYear) throws InterruptedException {
		driver=at.login(username, password);
		Thread.sleep(10000);
		fn.clickElement(driver, "id", objectRepository.myInfo);
		//click on Edit button
		Thread.sleep(10000);
		//fn.clickElement(driver, "id", objectRepository.saveBtn);
		WebElement lst=fn.getElement(driver, "id", objectRepository.infoList);
		List<WebElement>listItems=lst.findElements(By.tagName("li"));
		for (WebElement ele:listItems) {
			System.out.println(ele.getText());
			if (ele.getText().equals("Qualifications")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(10000);
		fn.clickElement(driver, "id", objectRepository.addWork);
		fn.enterInput(driver, "id", objectRepository.company, company);
		fn.enterInput(driver, "id", objectRepository.jobTitle, job);
		//select from date
		fn.clickElement(driver, "id",objectRepository.fromDate);
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
		
		fn.clickElement(driver, "id",objectRepository.toDate);
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
		
		fn.clickElement(driver, "id", objectRepository.saveExpBtn);
		
	}
	@AfterClass
	public void close() {
		closeDriver();
	}
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
	    return new Object[][] { { "orange", "orangepassword123","Infosy","TestAnalyst","Mar","3","2008","Dec","28","2020" }};
	}
}
