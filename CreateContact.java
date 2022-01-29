package week5.assignments;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateContact extends BaseClass123 {
@Test
	public void createContact() {
		
		driver.findElement(By.className("crmsfa")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
        driver.findElement(By.id("firstNameField")).sendKeys("Aniveshu");
		driver.findElement(By.id("lastNameField")).sendKeys("Karanam");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("ABCD");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("DEF");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("CSE");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Selenium createcontact information");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("anuvesh159@gmail.com");
		
		WebElement drop = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select createContactForm_generalStateProvinceGeoId = new Select(drop);
		createContactForm_generalStateProvinceGeoId.selectByVisibleText("New York");
		
        
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important Note");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		WebElement title = driver.findElement(By.tagName("View Contact | opentaps CRM"));
		title.getText();
		System.out.println(title.getText());
		
		

	}

}
