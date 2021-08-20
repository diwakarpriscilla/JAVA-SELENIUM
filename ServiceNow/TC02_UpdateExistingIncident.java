package ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC02_UpdateExistingIncident extends TC01_CreateNewIncident{

	@Test
	public void updateIncident() throws InterruptedException {
	
	driver.findElement(By.xpath("(//div[text()='All' and @class='sn-widget-list-title'])[2]")).click();
		
	//4. Search for the existing incident and click on the incident
	WebElement frame1 = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frame1);
	
	WebElement search_criteria = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
	Thread.sleep(1000);
	Select dropDown1a = new Select(search_criteria);
	dropDown1a.selectByValue("number");
	
	WebElement search_inc_num1 = driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input"));
	Thread.sleep(1000);
	System.out.println("TC02 Incident number is " +incident_Number1);
	
	search_inc_num1.sendKeys(incident_Number1, Keys.ENTER);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//a[text()='"+incident_Number1+"']")).click();
	Thread.sleep(1000);
	
	//5. Update the incidents with Urgency as High and State as In Progress
	
	WebElement urgency = driver.findElement(By.id("incident.urgency"));
	Thread.sleep(1000);
	Select dropDown1 = new Select(urgency);
	dropDown1.selectByValue("1");

	WebElement progress = driver.findElement(By.id("incident.state"));
	Thread.sleep(1000);
	Select dropDown2 = new Select(progress);
	dropDown2.selectByValue("2");
	
	driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).sendKeys("WorkNotes");
	
	driver.findElement(By.xpath("//button[text()='Update']")).click();

	//6.Verify - Go to the created incident
	driver.findElement(By.xpath("//a[text()='"+incident_Number1+"']")).click();
	  
	  
	//6a. Verify the state 
	  String actual_state = driver.findElement(By.xpath("//select[@id='incident.state']/option[@selected='SELECTED']")).getText();
	  String expected_state = "In Progress"; 
	  
	  if(actual_state.equals(expected_state)) { 
	  System.out.println("State is verified correctly" + actual_state);
	  }
	  
	  else { 
		  System.out.println("State is NOT captured correctly" +actual_state); 
		  }
	 
	// 6b. Verify the priority
	  String actual_urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']/option[@selected='SELECTED']")).getText();
	  String expected_urgency = "1 - High";
	  
	  if(actual_urgency .equals(expected_urgency))
	  { 
		  System.out.println("Priority is verified correctly " + actual_urgency);
	  }
		  
		  else { 
			  System.out.println("Priority is NOT captured correctly" +actual_urgency); 
			  }
	}
}
