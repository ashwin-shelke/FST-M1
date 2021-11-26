package Activities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	
	public WebDriver driver;
	public static Properties pro;
	public WebDriver initialiseDriver() {
		driver=new FirefoxDriver();
		return driver;
	}

	public void launchApp(String url) {
		driver = initialiseDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public void loadProperties() throws IOException {
		pro=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//config//app.properties");
		pro.load(fis);
	}
	
	public void closeDriver() {
		driver.close();
	}
}
