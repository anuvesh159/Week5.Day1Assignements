package week5.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident {

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
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//tr[@class='list_row list_odd']/td[3]/a")).click();
		driver.switchTo().window(windows.get(0));
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Outlook Issue");
		
		WebElement incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String attribute = incidentNumber.getAttribute("value");
		System.out.println(attribute);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
		Thread.sleep(2000);
		
		String verifyIncident = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]")).getText();
		
		if(attribute.equals(verifyIncident))
			System.out.println("successful:"+verifyIncident);
		else
			System.out.println("Not Successful");
		

	}

}
