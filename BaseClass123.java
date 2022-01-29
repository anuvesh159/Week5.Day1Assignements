package week5.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass123 {

	public ChromeDriver driver;
	
	  @Parameters({"url","username","password"})
	  @BeforeMethod
	  
	  public void beforeMethod(String url, String username, String password) {
		    WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.className("decorativeSubmit")).click();
		
	
}
	  @AfterMethod
	  public void aftermethod() {
		  driver.close();
	  }
}
