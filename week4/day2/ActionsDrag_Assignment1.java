package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDrag_Assignment1 {

	/*
	 * Complete all the 5 tasks in 
	 * 1.http://www.leafground.com/pages/sortable.html
	 * 2.http://www.leafground.com/pages/selectable.html
	 * 3.http://www.leafground.com/pages/drag.html
	 * 4.http://www.leafground.com/pages/drop.html
	 * 5.http://www.leafground.com/pages/mouseOver.html
	 */	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		WebElement dragMeAround = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		builder.dragAndDropBy(dragMeAround, 300, 220).perform();
		System.out.println("Completed Drag");
	
	}
}

