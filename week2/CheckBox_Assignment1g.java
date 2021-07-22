package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox_Assignment1g {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/checkbox.html");
	driver.manage().window().maximize();
	
	//Select the languages that you know?
	driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	
	//Confirm Selenium is checked
	WebElement elementSelenium = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));
	boolean seleniumChecked = elementSelenium.isSelected();
	
	if(seleniumChecked == true) {
		System.out.println("The Selenium is selected");
	} else {
		System.out.println("The Selenium is unchecked");
		}
	
	//DeSelect only checked
	WebElement elementDeselect = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
	boolean checkboxDeselect = elementDeselect.isSelected();
	if(checkboxDeselect == true) {
		elementDeselect.click();
		System.out.println("Not selected is Deselcted" );
	}
	else {
		WebElement elementDeselect2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		elementDeselect2.click();
		System.out.println("I am selected is Deselcted" );
	}
	
	//Select all below checkboxes
	driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
	driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
	driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
	driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
	driver.findElement(By.xpath("(//input[@type='checkbox'])[13]")).click();
	}

}
