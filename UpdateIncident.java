package week5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClassServiceNow {
	@Test
	public void update() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		WebElement iframe0 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		
		driver.switchTo().frame(iframe0);
		
		Thread.sleep(1000);
		
		WebElement filter1 = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search= new Select(filter1);
		search.selectByValue("number");
			
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0010001",Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();	
		
		driver.findElement(By.xpath("//th[@name='priority']"));
		Actions builder = new Actions(driver);
		builder.doubleClick();
		
		
		driver.findElement(By.xpath("//td[@class='vt']/a")).click();
		
		WebElement select = driver.findElement(By.xpath("//div[@id='element.incident.urgency']/div[2]/select"));
		
		Select urgency =new Select(select);
		
		urgency.selectByValue("1");
		
		WebElement select1 = driver.findElement(By.xpath("//div[@id='element.incident.state']/div[2]/select"));
		
		Select state= new Select(select1);
		state.selectByValue("2");
		String incidentno = driver.findElement(By.xpath("//div[@id='element.incident.number']/div[2]")).getText();
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentno,Keys.ENTER);
				
		String result = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr")).getText();
		System.out.println(result);
		
		
		
		
	}

}
