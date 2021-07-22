package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact_Assignment2a {
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
	 * 6. Click on Create Contact
	 *  
	 * 7. Enter FirstName Field Using id Locator
	 * 
	 * 8. Enter LastName Field Using id Locator
	 * 
	 * 9. Enter FirstName(Local) Field Using id Locator
	 * 
	 * 10. Enter LastName(Local) Field Using id Locator
	 * 
	 * 11. Enter Department Field Using any Locator of Your Choice
	 * 
	 * 12. Enter Description Field Using any Locator of your choice 
	 * 
	 * 13. Enter your email in the E-mail address Field using the locator of your choice
	 * 
	 * 14. Select State/Province as NewYork Using Visible Text
	 * 
	 * 15. Click on Create Contact
	 * 
	 * 16. Click on edit button 
	 * 
	 * 17. Clear the Description Field using .clear
	 * 
	 * 18. Fill ImportantNote Field with Any text
	 * 
	 * 19. Click on update button using Xpath locator
	 * 
	 * 20. Get the Title of Resulting Page.
     */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on Contact
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Name
		driver.findElement(By.id("firstNameField")).sendKeys("firstName");
		driver.findElement(By.id("lastNameField")).sendKeys("lastName");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("firstNameLocal");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("lastNameLocal");
		
		//Department
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("DepartmentName");
		
		//Description
		driver.findElement(By.id("createContactForm_description")).sendKeys("Populating Description");
		
		//Email
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("diwakarpriscilla@gmail.com");
	
		//Select State/Province as NewYork Using Visible Text
		WebElement element1 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropdownState = new Select(element1);
		dropdownState.selectByVisibleText("New York");
		
		//Click on Create Contact
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on Edit button
		driver.findElement(By.linkText("Edit")).click();
		
		//Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		  
		// Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important Notes");
		 
	    //Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
		
		//20. Get the Title of Resulting Page.
		//String title = "View Contact | opentaps CRM";
		String title2 = driver.getTitle();
		System.out.println("The title of the Resulting page is : "+ title2);

	}
	

}
