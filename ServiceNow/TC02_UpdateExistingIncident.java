package ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC02_UpdateExistingIncident extends TC01_CreateNewIncident{

	@Test
	public void updateIncident() throws InterruptedException {
		
		//4. Search for the existing incident and click on the incident
	WebElement frame1 = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frame1);
		
	WebElement search_inc_num = driver.findElement(By.xpath("//input[@id='incident_table_header_search_control']"));
	Thread.sleep(1000);
	System.out.println("TC02 Incident number is " +incident_Number1);
	search_inc_num.sendKeys(incident_Number1, Keys.ENTER);
	
	driver.findElement(By.xpath("//a[text()='"+incident_Number1+"']")).click();
	
	//5. Update the incidents with Urgency as High and State as In Progress
	WebElement priority = driver.findElement(By.id("incident.urgency"));
	Select dropDown1 = new Select(priority);
	dropDown1.selectByValue("1");

	WebElement progress = driver.findElement(By.id("incident.state"));
	Select dropDown2 = new Select(progress);
	dropDown2.selectByValue("2");
	
	driver.findElement(By.xpath("//button[@text()='Update']")).click();
	
	//6.Verify
	driver.findElement(By.xpath("//a[text()='"+incident_Number1+"']")).click();
	
	
	//6. Verify the priority and state 
	}
}
