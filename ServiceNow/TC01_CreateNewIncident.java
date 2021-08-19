package ServiceNow;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TC01_CreateNewIncident extends BaseClass_SNOW {
	
	@Test
	public void CreateNewIncident() throws InterruptedException {

	
	//4. Click on Create new option and fill the mandatory fields	
	WebElement frame1 = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frame1);
	
	driver.findElement(By.id("sysverb_new")).click();
	Thread.sleep(1000);
	
	incident_Number1 = driver.findElement(By.id("incident.number")).getAttribute("value");
	System.out.println("The Incident number created is "+ incident_Number1);
	
	driver.findElement(By.id("incident.short_description")).sendKeys("Creating new Incident");
	driver.findElement(By.id("sysverb_insert_bottom")).click();
	
	//5. Verify the newly created incident
	//copy the incident number and paste it in search field and enter then verify the instance number created or not)
	WebElement search_inc_num = driver.findElement(By.id("incident_table_header_search_control"));
	Thread.sleep(1000);
	search_inc_num.sendKeys(incident_Number1, Keys.ENTER);
			
	String incident_Number2 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
	
	if(incident_Number1 .equals(incident_Number2))
	{
		System.out.println("Verified Incident creation " + incident_Number1);
	}
	else {
		System.out.println("Please check Incident creation " + incident_Number1);	
	}
	
	
	}
}
