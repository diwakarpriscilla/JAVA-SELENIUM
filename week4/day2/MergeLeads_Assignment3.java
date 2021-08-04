package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeads_Assignment3 {
	
	/*
	 * Assignment 3: (Window Handling) ============= MergeLeads Application :
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * 1. Launch the browser 
	 * 2. Enter the username 
	 * 3. Enter the password 
	 * 4. Click Login 
	 * 5. Click crm/sfa link 
	 * 6. Click Leads link 
	 * 7. Click Merge leads 
	 * 8. Click on Icon near From Lead 
	 * 9. Move to new window 
	 * 10. Enter Lead ID 
	 * 11. Click Find Leads button 
	 * 12. Click First Resulting lead 
	 * 13. Switch back to primary window
	 * 14. Click on Icon near To Lead 
	 * 15. Move to new window 
	 * 16. Enter Lead ID 
	 * 17. Click Find Leads button 
	 * 18. Click First Resulting lead 
	 * 19. Switch back to primary window 
	 * 20. Click Merge 
	 * 21. Accept Alert 
	 * 22. Click Find Leads link 
	 * 23. Enter From Lead ID 
	 * 24. Click Find Leads button 
	 * 25. Verify message "No records to display" in the Lead List. This message confirms that the
	 * successful merge of leads 
	 * 26. Close the browser (Do not log out)
	 */

	public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.manage().window().maximize();

			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			
			//7. Click Merge leads
			driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
			
			// 8. Click on Icon near From Lead 
			driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
			
			// 9. Move to new window 
			//9a : Get all the window handles in a set
			Set<String> windowHandlesSet = driver.getWindowHandles();
			
			//9b : Move the Set of window handles into a list so that each of the window handle
			//     can be accessed using the index value which is not possible with the set
			List<String> winList = new ArrayList<String>(windowHandlesSet);
			
			//9c: Switch the control to the specific window by selecting the required window handle
			driver.switchTo().window(winList.get(1));
			System.out.println("Step 9c : " +driver.getTitle());
			Thread.sleep(1000);
			
			// 10. Enter Lead ID 
			WebElement leadId = driver.findElement(By.xpath("//a[@class='linktext']"));
			String lead_Id = leadId.getText();
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(lead_Id);
			
			
			// 11. Click Find Leads button 
			driver.findElement(By.xpath("//td[@class='x-btn-center']")).click();
			Thread.sleep(1000);
			
			// 12. Click First Resulting lead
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			Thread.sleep(1000);
			
			//13. Switch back to primary window
			driver.switchTo().window(winList.get(0));
			Thread.sleep(1000);
			
			//14. Click on Icon near To Lead 
			driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
			
			//15. Move to new window 
			//15a : Get all the window handles in a set
			Set<String> windowHandlesSet1 = driver.getWindowHandles();
			
			//15b : Move the Set of window handles into a list so that each of the window handle
			//     can be accessed using the index value which is not possible with the set
			List<String> winList1 = new ArrayList<String>(windowHandlesSet1);
			
			//15c: Switch the control to the specific window by selecting the required window handle
			driver.switchTo().window(winList1.get(1));
			System.out.println("Step 15c : " +driver.getTitle());
			Thread.sleep(1000);
			
			// 16. Enter Lead ID 
			WebElement leadIdTo = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]"));
			String lead_Id_To = leadIdTo.getText();
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(lead_Id_To);
			Thread.sleep(1000);
			
		    //17. Click Find Leads button 
			driver.findElement(By.xpath("//td[@class='x-btn-center']")).click();
			Thread.sleep(1000);
			
			//18. Click First Resulting lead 
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			Thread.sleep(1000);
			
			//19. Switch back to primary window 
			driver.switchTo().window(winList1.get(0));
						
			//20. Click Merge
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			System.out.println("Done");
			
			//21. Accept Alert
			Alert alert1 = driver.switchTo().alert();
			alert1.accept();
			
			//22. Click Find Leads link 
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			Thread.sleep(1000);
			
			//23. Enter From Lead ID 
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(lead_Id);
			
			//24. Click Find Leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(1000);
			
			//25.Verification
			String expected = "No records to display";
			String actual = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
			if(expected .equals(actual)) {
				System.out.println("Leads are merged successfully");
			}
			
			else {
				System.out.println("Leads are not merged. Please check");
			}
			
			//26. Close the browser (Do not log out)
			driver.close();

	}

}
