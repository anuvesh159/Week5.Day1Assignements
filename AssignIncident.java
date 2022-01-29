package week5.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://dev51595.service-now.com");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Admin",Keys.TAB);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Aniveshu@#$22");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident",Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		WebElement frame0 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame0);
		WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search= new Select(filter);
		search.selectByValue("number");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0010032",Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("Software",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		Thread.sleep(3000);
		driver.switchTo().window(windows.get(0));
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		WebElement sd = driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']"));
		sd.clear();
		sd.sendKeys("Changed the group");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		String verify = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[10]")).getText();
		System.out.println(verify);
		if(verify.equalsIgnoreCase("software"))
				{
			System.out.println("Valid");}
		else System.out.println("Invalid");
		

	}

}
