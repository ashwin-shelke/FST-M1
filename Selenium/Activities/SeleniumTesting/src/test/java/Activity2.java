import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is: " + pageTitle);
		WebElement aboutId = driver.findElement(By.id("about-link"));
		System.out.println("Text of the element is: " + aboutId.getText());
		WebElement aboutClassName = driver.findElement(By.className("green"));
		System.out.println("Text of the element is: " + aboutClassName.getText());
		WebElement cssLocator = driver.findElement(By.cssSelector(".green"));
		System.out.println("Text in element: " + cssLocator.getText());
		WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
		System.out.println("Text in element: " + linkTextLocator.getText());

		driver.close();
	}
}
