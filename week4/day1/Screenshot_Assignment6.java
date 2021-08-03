package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot_Assignment6 {
	/*
	 * Assignment 6 
	 * Try it yourself: --------------- 
	 * 1. Load http://leafground.com/
	 * 2. Take the screenshot of a webElement "Button" in this page
	 */

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//6. Take a screenshot of a webElement "Button" in this page
		WebElement elementButton = driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[2]"));
		File src1 = elementButton.getScreenshotAs(OutputType.FILE); // the Element that has to be taken screen shot
		File dst = new File("./snaps/button.png");
		FileUtils.copyFile(src1, dst);
		
	}

}
