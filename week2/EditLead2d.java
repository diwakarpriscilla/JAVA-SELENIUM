package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead2d {
	/*http://leaftaps.com/opentaps/control/main
	
	* 1	Launch the browser
	* 2	Enter the username
	* 3	Enter the password
	* 4	Click Login
	* 5	Click crm/sfa link
	* 6	Click Leads link
	* 7	Click Find leads
	* 8	Enter first name
	* 9	Click Find leads button
	* 10 Click on first resulting lead
	* 11 Verify title of the page
	* 12 Click Edit
	* 13 Change the company name
	* 14 Click Update
	* 15 Confirm the changed name appears
	* 16 Close the browser (Do not log out)
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
		
		//Enter first name and click Find Lead button
		driver.findElement(By.xpath("(//input[@type='text' and @name='firstName'])[3]")).sendKeys("FirstNameP");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//td[@class= 'x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a[1]")).click();
		Thread.sleep(2000);
		
		//Verify title of the page
		String pageTitle = "View Lead | opentaps CRM";
		String actualPageTitle = driver.getTitle();
		System.out.println("the page title is "+actualPageTitle);
		if(pageTitle .equals(actualPageTitle)) {
			System.out.println("We have landed at the correct page");
		}
		else {
			System.out.println("Please check the page you have landed");
		}
		
		//Click Edit and change company name
		driver.findElement(By.xpath("//a[@class='subMenuButton'][3]")).click();
		WebElement elementCompany = driver.findElement(By.id("updateLeadForm_companyName"));
		elementCompany.clear();
		String newCompanyName = "UpdatedTestLeafPJ";
		elementCompany.sendKeys(newCompanyName); 
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
		
		//Confirm the changed name appears
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Company name after updation is " + updatedCompanyName);
		
		//if(newCompanyName .equals(updatedCompanyName)) 
		if (updatedCompanyName .startsWith(newCompanyName)){
			System.out.println("Company name is updated");
		}
		else {
			System.out.println("Company name is not updated");
		}
	}

}
