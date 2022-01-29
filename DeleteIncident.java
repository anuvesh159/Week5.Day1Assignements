package week5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident {

	public static void main(String[] args) throws InterruptedException {
		
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev51595.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Aniveshu@#$22");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		Thread.sleep(3000);
		
		WebElement filter = driver.findElement(By.xpath("//input[@id='filter']"));
		filter.sendKeys("incident");
		Thread.sleep(3000);
		filter.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		WebElement iframe0 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		
		driver.switchTo().frame(iframe0);
		
		driver.findElement(By.xpath("//th[@name='priority']"));
		Actions builder = new Actions(driver);
		builder.doubleClick();	
		driver.findElement(By.xpath("//td[@class='vt']/a")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		String verify = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr")).getText();
		System.out.println(verify);
	}

}
