package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead_Assignment2b {
	/*
	 * http://leaftaps.com/opentaps/control/main
	 * 
	 * Delete Lead: 1 Launch the browser 2 Enter the username 3 Enter the password 4
	 * Click Login 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8
	 * Click on Phone 9 Enter phone number 10 Click find leads button 11 Capture
	 * lead ID of First Resulting lead 12 Click First Resulting lead 13 Click Delete
	 * 14 Click Find leads 15 Enter captured lead ID 16 Click find leads button 17
	 * Verify message "No records to display" in the Lead List. This message
	 * confirms the successful deletion 18 Close the browser (Do not log out)
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		// Login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Phone
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();

		// Enter phone number
		driver.findElement(By.xpath("//input[@type='text' and @name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@type='text' and @name='phoneCountryCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@type='text' and @name='phoneAreaCode']")).sendKeys("44");
		driver.findElement(By.xpath("//input[@type='text' and @name='phoneNumber']")).sendKeys("24992961");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		System.out.println("Completed Phone number");
		Thread.sleep(5000);

		// Capture lead ID of First Resulting lead and click it
		WebElement element1 = driver.findElement(
				By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a[1]"));
		String firstLeadId = element1.getText();
		System.out.println("Picked first lead ID : " + firstLeadId);
		element1.click();

		// Click Delete
		System.out.println("Clicking Delete button");
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		Thread.sleep(5000);

		// Click Find leads
		System.out.println("Clicking FindLead button");
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);

		// Send the Deleted LeadId
		System.out.println("Sending Deleted leadid");
		driver.findElement(By.xpath("//input[@class=' x-form-text x-form-field' and @name = 'id']"))
				.sendKeys(firstLeadId);
		Thread.sleep(5000);

		// Click Find Lead button
		System.out.println("Clicking FindLead button to confirm deletion");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String confirmationTextExpected = "No records to display";
		Thread.sleep(3000);
		String confirmationTextActual = driver.findElement(By.xpath("//div[@class = 'x-paging-info']")).getText();
		System.out.println("Message displayed is: " + confirmationTextActual);
		if (confirmationTextExpected .equals(confirmationTextActual)) {
		System.out.println("Confirmed LeadId is deleted: " + firstLeadId);
				}
		else {
			System.out.println("Deletion confirmation message not displayed");
		}
	
	}

}
