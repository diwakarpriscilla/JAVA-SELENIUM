package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage_Assignment1b {
//Complete all the 4 activities in Button Page: http://leafground.com/pages/Button.html
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		
		//Find position of button (x,y)
		WebElement positionOfButton = driver.findElement(By.id("position"));
		Point location = positionOfButton.getLocation();
		System.out.println("The position of the button is " + location);
		
		//Find button color
		WebElement findColor = driver.findElement(By.id("color"));
		String cssValue = findColor.getCssValue("background-color");
		System.out.println("The color of the button is " + cssValue);
		
		//Find the height and width
		WebElement findHeightWidth = driver.findElement(By.id("size"));
		Dimension size = findHeightWidth.getSize();
		System.out.println("The size of the button is " + size);
		
		//Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		//Close browser
		driver.close();


	}

}
