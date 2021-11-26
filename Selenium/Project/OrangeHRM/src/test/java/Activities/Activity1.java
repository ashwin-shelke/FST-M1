package Activities;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 extends base {

/*Description - 
1. Verify the website title
Goal: Read the title of the website and verify the text
a. Open a browser.
b. Navigate to ‘http://alchemy.hguy.co/orangehrm’.
c. Get the title of the website.
d. Make sure it matches “OrangeHRM” exactly.
e. If it matches, close the browser.
*/
Functions fn=new Functions();
@BeforeClass
public void load() throws IOException {
	loadProperties();
	
}
@Test
public void getTitle()  {
	String applicationUrl=pro.getProperty("orangehrm_url");
	//System.out.println(applicationUrl);
	launchApp(applicationUrl);
	String actualTitle=fn.getTitle(driver);
	String expectedTitle="OrangeHRM";
	Assert.assertEquals(actualTitle, expectedTitle);
	closeDriver();
}

	
}
