package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest_Assignment1 {
	
	/*
	 * 1. Load url "https://acme-test.uipath.com/login" 
	 * 2. Enter email as "kumar.testleaf@gmail.com" 
	 * 3. Enter Password as "leaf@12" 
	 * 4. Click login button 
	 * 5. Get the title of the page and print 
	 * 6. Click on Log Out 
	 * 7. Close the browser (use -driver.close())
	 */
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		
		//Enter Email
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		
		//Enter Password
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
		//Click login button
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		
		//Get the title of the page and print 
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is " + pageTitle);
		
		//Click on Log Out 
		driver.findElement(By.linkText("Log Out")).click();
		
		//CloseBrowser
		driver.close();
	
	}

}
