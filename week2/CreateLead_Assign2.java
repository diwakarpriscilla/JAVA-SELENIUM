package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead_Assign2 {
	
	/*
	 * Assignment: 2 Create Lead in Leaftaps Application
	 * ================================================== 1. Launch URL
	 * "http://leaftaps.com/opentaps/control/login"
	 * 
	 * 2. Enter UserName and Password
	 * 
	 * 3. Click on Login Button
	 * 
	 * 4. Click on CRM/SFA Link
	 * 
	 * 5. Click on Leads Button
	 * 
	 * 6. Click on create Lead Button
	 * 
	 * 7. Enter all the text fields(alone) in CreateLead page
	 ** 
	 * Note 1. Donot work on Parent Account Field 2.Enter the Birthdate using
	 * SendKeys
	 * 
	 * 8. Enter all the text fields(alone) in contact information
	 * 
	 * 9. Enter all the text fields(alone) in primary address
	 * 
	 * 10. Get the Firstname and print it
	 * 
	 * 11. Click on create Lead Button
	 * 
	 * 12. Get and Verify the Title of the resulting Page(View Lead)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String originalTitle = "Leaftaps - TestLeaf Automation Platform";
		String pageTitle = driver.getTitle();
		if (originalTitle.equals(pageTitle)) {
			System.out.println("We have landed to correct Home page");
		} else
			System.out.println("Incorrect page");
		driver.findElement(By.linkText("CRM/SFA")).click();
//		driver.findElement(By.name("inputBox")).sendKeys("demosalesmanager");
//		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("FirstNameP");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("LastNameJ");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("FirstLocalNameP");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("LastNameLocalJ");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mrs");	
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Finance");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("07/19/17");	
				driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("200000");
				driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("8729");
				driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("982");
				driver.findElement(By.id("createLeadForm_description")).sendKeys("Writing Description");
				driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("importantNote");
				
				//Contact Information
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();		
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");		
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("44");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("24992961");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("4532");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Pris");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("jpris@yahoo.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testleaf.com");
		
		//Primary address
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("ToName:PJ");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("AttnName:Pris");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("80");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Bishop Street");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600004");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("09");
		
		//State
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dropdown1 = new Select(state);
		dropdown1.selectByVisibleText("Alabama");
		
		//Click Submit		
		driver.findElement(By.name("submitButton")).click();
		
		//Verifying Title of the landed page
		String titleViewLeadPage = "View Lead | opentaps CRM";
									
		String pageTitle2 = driver.getTitle();
		if (titleViewLeadPage.equals(pageTitle2)) {
			System.out.println("We have landed to correct View Lead page");
		} else {
			System.out.println(pageTitle2);
			System.out.println("Incorrect page");
		}
		driver.close();
	}
}
