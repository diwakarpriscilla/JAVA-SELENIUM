package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_Assign3 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//Entering Text in Topics field
	WebElement frame1 = driver.findElement(By.id("frame1"));
	driver.switchTo().frame(frame1);
	WebElement topic = driver.findElement(By.xpath("//input[@type='text']"));
	topic.sendKeys("Topic Displayed");
		
	//Clicking Inner frame Check box
	WebElement frame3 = driver.findElement(By.id("frame3"));
	driver.switchTo().frame(frame3);
	WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	checkbox.click();
	driver.switchTo().defaultContent();

	//Selecting from dropdown
	WebElement frame2 = driver.findElement(By.id("frame2"));
	driver.switchTo().frame(frame2);
	WebElement dropDownElement = driver.findElement(By.id("animals"));
	Select dropDown = new Select (dropDownElement);
	dropDown.selectByValue("avatar");
	
	}

}
