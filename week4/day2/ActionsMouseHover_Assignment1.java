package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsMouseHover_Assignment1 {

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
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Mouse Hover to Test Leaf courses and print all the links
		Actions builder = new Actions(driver);
		WebElement courses = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		builder.moveToElement(courses).perform();
		int iNumberOfLinks = driver.findElements(By.className("listener")).size();
		System.out.println("No. of links is "+iNumberOfLinks);
		List<WebElement> links = driver.findElements(By.className("listener"));
		for (WebElement webElement : links) {
			String linkText = webElement.getText();
			String url = webElement.getAttribute("href");
			System.out.println("The link text is "+ linkText);
			System.out.println("The URL is "+ url);
			
		}
		
		//MouseHoover on TestLeaf Courses and click on any course and handle the alert
		WebElement selenium = driver.findElement(By.xpath("//a[text()='Selenium']"));
		builder.moveToElement(courses).click(selenium).perform();
		
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		
		System.out.println("Completed MouseHover");
		driver.quit();
	
	}
}
