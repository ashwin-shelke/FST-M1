import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
public static void main(String[] args) throws InterruptedException {
	//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.training-support.net");
	Thread.sleep(10000);
	driver.close();
}
}
