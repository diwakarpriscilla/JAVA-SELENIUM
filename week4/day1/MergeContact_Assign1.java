package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact_Assign1 {
	/*
	 * //Pseudo Code
	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 
	 * 2. Enter UserName and Password Using Id Locator
	 * 
	 * 3. Click on Login Button using Class Locator
	 * 
	 * 4. Click on CRM/SFA Link
	 * 
	 * 5. Click on contacts Button
	 * 	
	 * 6. Click on Merge Contacts using Xpath Locator
	 * 
	 * 7. Click on Widget of From Contact
	 * 
	 * 8. Click on First Resulting Contact
	 * 
	 * 9. Click on Widget of To Contact
	 * 
	 * 10. Click on Second Resulting Contact
	 * 
	 * 11. Click on Merge button using Xpath Locator
	 * 
	 * 12. Accept the Alert
	 * 
	 * 13. Verify the title of the page
	 */

	public static void main(String[] args) {
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator"
		driver.findElement(By.className("decorativeSubmit")).click();
		 
		//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		 
		//5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		  	
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		System.out.println("Step 6 : " + driver.getTitle());
		
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		
		//7a : Get all the window handles in a set
		Set<String> windowHandlesSet = driver.getWindowHandles();
		
		//7b : Move the Set of window handles into a list so that each of the window handle
		//     can be accessed using the index value which is not possible with the set
		List<String> winList = new ArrayList<String>(windowHandlesSet);
		
		//7c: Switch the control to the specific window by selecting the required window handle
		driver.switchTo().window(winList.get(1));
		System.out.println("Step 7c : " +driver.getTitle());
		
		//8. Click on First Resulting Contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		//Change to Main window
		driver.switchTo().window(winList.get(0));
		System.out.println("Step 8 : " +driver.getTitle());
		
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
		System.out.println("Step 9 : " +driver.getTitle());
		
		//9a : Get all the window handles in a set
				Set<String> windowHandlesSet2 = driver.getWindowHandles();
				
		//9b : Move the Set of window handles into a list so that each of the window handle
		//     can be accessed using the index value which is not possible with the set
				List<String> winList2 = new ArrayList<String>(windowHandlesSet2);
				
		//9c: Switch the control to the specific window by selecting the required window handle
				driver.switchTo().window(winList2.get(1));
				System.out.println("Step 9c : " +driver.getTitle());
		
		//10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		
		//10a: Switch the control back to main window
		driver.switchTo().window(winList2.get(0));
		System.out.println("Step 10a : " +driver.getTitle());
		
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//12. Accept the Alert
		 Alert alertMergeCOntact = driver.switchTo().alert();
		 alertMergeCOntact.accept();
			 
		
		//13. Verify the title of the page
				String actualTitle = driver.getTitle();
		System.out.println("Step 13 : " +actualTitle);
		
		String expectedTitle = "View Contact | opentaps CRM";
		
		if(actualTitle .equals(expectedTitle)) {
			System.out.println("Test Has Passed - Contact has been Merged");
		}
		else {
			System.out.println("Test Has Failed functionally - Contact NOT Merged. Please check");
		}
	}

}
