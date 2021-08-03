package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_Assign5 {
	/*
	 * Assignment 5: ------------ 
	 * http://leafground.com/pages/frame.html 
	 * Find the number of frames - 
	 * find the Elements by tagname - iframe - 
	 * Store it in a list
	 * - Get the size of the list. (This gives the count of the frames visible to the main page)
	 */
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		int iframe_count = iframe.size();
		System.out.println("Visible frames for the main page = " +iframe_count);
		
	}

}
