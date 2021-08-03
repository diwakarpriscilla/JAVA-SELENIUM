package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow_Frames_Assign2 {
	/*
	 * Step1: Load ServiceNow application https://dev113545.service-now.com/ 
	 * Step2: Enter username as admin 
	 * Step3: Enter password as m3GkKEKU8atr 
	 * Step4: Click Login 
	 * Step5: Search “incident “ Filter Navigator 
	 * Step6: Click “All” 
	 * Step7: Click New button
	 * Step8: Select a value for Caller and Enter value for short_description 
	 * Step9: Read the incident number and save it a variable 
	 * Step10: Click on Submit button 
	 * Step 11: Search the same incident number in the next search screen as below 
	 * Step12: Verify the incident is created successful
	 */
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Logging in to Service now
		WebElement moveToframe1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(moveToframe1);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("m3GkKEKU8atr");
		driver.findElement(By.id("sysverb_login")).click();
		
		//Step5: Search “incident “ Filter Navigator 
		Thread.sleep(3000);
		driver.findElement(By.id("filter")).sendKeys("incident");
		
		//Step6: Click “All”
		driver.findElement(By.id("b55b4ab0c0a80009007a9c0f03fb4da9")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		//Step7: Click New button
		WebElement frame1 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(3000);
		System.out.println("The page title name is " +driver.getTitle());
		Thread.sleep(1000);
		//Not working
		
		//Step8: Select a value for Caller and Enter value for short_description
		WebElement caller = driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']"));
		caller.click();
		Thread.sleep(2000);
		caller.sendKeys("A", Keys.ARROW_DOWN, Keys.ENTER);
		
		Thread.sleep(1000);
		WebElement shortDescription = driver.findElement(By.id("incident.short_description"));
		shortDescription.sendKeys("Entering shorting Description", Keys.ENTER);
		Thread.sleep(1000);
		
		//Step9: Read the incident number and save it a variable
		WebElement incidentNumber = driver.findElement(By.id("incident.number"));
		String incident_Number = incidentNumber.getAttribute("value");
		System.out.println("New incident number is:" +incident_Number);
		Thread.sleep(1000);
		
		//Step10: Click on Submit button 
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(1000);
		
		//Step 11: Search the same incident number in the next search screen as below 
		WebElement searchIncNum = driver.findElement(By.xpath("//input[@class='form-control']"));
		Thread.sleep(1000);
		searchIncNum.sendKeys(incident_Number,Keys.ENTER);
		Thread.sleep(1000);
		
		String getIncNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println("The Incident number getting displayed is "+getIncNumber);
		
		//Step12: Verify the incident is created successful
		if(getIncNumber .equals(incident_Number)) {
			System.out.println("The Incident is created successfully");
		}
		else {
			System.out.println("Please re-verify the Incident status manually");
		}
		
	}
}
