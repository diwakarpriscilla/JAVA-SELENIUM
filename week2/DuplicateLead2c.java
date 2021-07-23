package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead2c {
	/*http://leaftaps.com/opentaps/control/main
	 
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	
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

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click on Email
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
		
		//Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("jpris@yahoo.com");
		
		//Click find leads button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//	Capture name of First Resulting lead and Click First Resulting lead
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(
				By.xpath("//td[@class= 'x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a[1]"));
		String firstName = element1.getText();
		System.out.println("Picked first Name displayed is : " + firstName);
		element1.click();
		
		//Clicking Duplicate Lead button
		System.out.println("Clicking Duplicate button");
		driver.findElement(By.xpath("//a[@class= 'subMenuButton'][1]")).click();
		Thread.sleep(5000);
		
		//Verify the title as 'Duplicate Lead'
		String actualTitle = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		String originalTitle = "Duplicate Lead";
		if(originalTitle .equals(actualTitle)) {
			System.out.println("The title is displayed correctly");
		}
		else {
			System.out.println("Please check the page you have landed");
		}
		Thread.sleep(3000);
		
		//Click Create Lead
		driver.findElement(By.xpath("//input[@name ='submitButton']")).click();
		
		//Confirm the duplicated lead name is same as captured name
		String actualFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("The First name of the lead created is "+actualFirstName);
		if (firstName .equals(actualFirstName)) {
			System.out.println("Duplicate lead name is same as captured lead name");
		}
		else {
			System.out.println("Duplicate lead name is different");
		}

	}

}
