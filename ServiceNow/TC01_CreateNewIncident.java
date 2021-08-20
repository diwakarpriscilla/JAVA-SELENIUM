package ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC01_CreateNewIncident extends BaseClass_SNOW {
@Test
	public void CreateNewIncident01() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		Thread.sleep(1000);
		
		//4. Click on Create new option and fill the mandatory fields	
		WebElement frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		Thread.sleep(1000);
		
		incident_Number1 = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The incident created is " +incident_Number1);
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("System Administrator", Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.id("incident.short_description")).sendKeys("Short description of New Incident "+incident_Number1+"");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		
		//Verification
		WebElement search_criteria = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select dropDown1a = new Select(search_criteria);
		dropDown1a.selectByVisibleText("Number");
		
		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input")).sendKeys(incident_Number1,Keys.ENTER);
		Thread.sleep(1000);
		
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
