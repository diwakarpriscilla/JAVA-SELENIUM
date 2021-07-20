package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage_Assignment1a {
	// Complete all the 5 activities in Edit Page:
	// http://leafground.com/pages/Edit.html

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");

		// Enter your email address
		driver.findElement(By.id("email")).sendKeys("priscilla@testleaf.com");

		// Append a text and press keyboard tab
		WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		String text1 = element1.getAttribute("value");
		element1.clear();
		element1.sendKeys(text1 + "Diwa", Keys.TAB);

		// Get default text entered
		WebElement element2 = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		String text2 = element2.getAttribute("value");
		System.out.println("The default text entered is " + text2);

		// clear the Text
		WebElement element3 = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		element3.clear();
		
		//Confirm that edit field is disabled
		WebElement element4 = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		boolean edit_field = element4.isEnabled();
		
		if(edit_field == true)
			System.out.println("Edit field is enabled");
		else
			System.out.println("Edit field is disabled");
	}
}
