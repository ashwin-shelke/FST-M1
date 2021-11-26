package Activities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions extends base {
public void enterInput(WebDriver driver,String locatorType,String locator,String input) {
	if(locatorType=="xpath") {
		driver.findElement(By.xpath(locator)).sendKeys(input);
	}else if (locatorType=="id") {
		driver.findElement(By.id(locator)).sendKeys(input);
	}else if(locatorType=="name") {
		driver.findElement(By.name(locator)).sendKeys(input);
	}
}
	public String getTitle(WebDriver driver) {
		String title=driver.getTitle();
		return title;
	}
	
	public WebElement getElement(WebDriver driver,String locatorType,String locator) {
		WebElement ele=null;
		if(locatorType=="xpath") {
			ele= driver.findElement(By.xpath(locator));
		}else if (locatorType=="id") {
			ele= driver.findElement(By.id(locator));
		}else if(locatorType=="name") {
			ele= driver.findElement(By.name(locator));
			
		}
		return ele;
		
		
	}
	
	public void clickElement(WebDriver driver,String locatorType,String locator) {
		if(locatorType=="xpath") {
			 driver.findElement(By.xpath(locator)).click();;
		}else if (locatorType=="id") {
			driver.findElement(By.id(locator)).click();;
		}else if(locatorType=="name") {
			driver.findElement(By.name(locator)).click();;
			
		}
	}
	
	public String getElementText(WebDriver driver,String locatorType,String locator) {
		implicitWait(driver);
		String text=null;
		if(locatorType=="xpath") {
			text= driver.findElement(By.xpath(locator)).getText();;
		}else if (locatorType=="id") {
			text=driver.findElement(By.id(locator)).getText();;
		}else if(locatorType=="name") {
			text=driver.findElement(By.name(locator)).getText();;
			
		}
		return text;
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public List<WebElement> getElements(WebDriver driver,String locatorType,String locator) {
		List<WebElement> ele=null;
		if(locatorType=="xpath") {
			ele= driver.findElements(By.xpath(locator));
		}else if (locatorType=="id") {
			ele= driver.findElements(By.id(locator));
		}else if(locatorType=="name") {
			ele= driver.findElements(By.name(locator));
			
		}
		return ele;
		
		
	}
	
	public void clearText(WebDriver driver,String locatorType,String locator) {
		if(locatorType=="xpath") {
			 driver.findElement(By.xpath(locator)).clear();
		}else if (locatorType=="id") {
			driver.findElement(By.id(locator)).clear();
		}else if(locatorType=="name") {
			driver.findElement(By.name(locator)).clear();
			
		}
	}
	public void selectDropdownValue(WebDriver driver,String locatorType,String locator,String value) {
		WebElement ele=null;
		if(locatorType=="xpath") {
			ele= driver.findElement(By.xpath(locator));
		}else if (locatorType=="id") {
			ele= driver.findElement(By.id(locator));
		}else if(locatorType=="name") {
			ele= driver.findElement(By.name(locator));
			
		}
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}
	
	public void WebDriverwait(WebDriver driver,String locatorType,String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		if(locatorType=="xpath") {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}else if(locatorType=="id") {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		}else if(locatorType=="name") {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		}
		
	}
}

