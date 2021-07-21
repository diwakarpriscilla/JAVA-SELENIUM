package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_Assignment1e {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//Select training program using Index
		WebElement element1 = driver.findElement(By.id("dropdown1"));
		Select indexDropDown = new Select(element1);
		indexDropDown.selectByIndex(2);   
		
		//Select training program using Name
		WebElement element2 = driver.findElement(By.name("dropdown2"));
		Select dropDown2 = new Select(element2);
		dropDown2.selectByVisibleText("Appium"); 		
		
		//Select training program using Value
		WebElement element3 = driver.findElement(By.name("dropdown3"));
		Select dropDown3 = new Select(element3);
		dropDown3.selectByValue("2");
		
		//You can also use sendKeys to select
		driver.findElement(By.xpath("//div[@class='example'][5]/select")).sendKeys("Appium");
		
		//Select your program
		driver.findElement(By.xpath("//div[@class='example'][6]/select/option[3]")).click();
			
	}

}
