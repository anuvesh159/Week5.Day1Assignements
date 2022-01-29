package week5.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CL extends BaseClass123 {
    @Test 
	public void createLead() {
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Aniveshu");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Karanam");
		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}

}
