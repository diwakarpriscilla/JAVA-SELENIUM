package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperlinkPage_Assignment1c {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		//Find where am supposed to go without clicking me?
		WebElement element1 = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
		String attribute1 = element1.getAttribute("href");
		System.out.println("Find where am supposed to go without clicking me? navigates to "+ attribute1);
		
		//Verify am I broken?
		WebElement element2 = driver.findElement(By.linkText("Verify am I broken?"));
		String attribute2 = element2.getAttribute("href");
		System.out.println("The link for broken link verification is "+ attribute2);
		element2.click();
		Thread.sleep(5000);
		String pageTitleExpected = "HTTP Status 404 – Not Found";
		String titleActual = driver.getTitle();
		if (pageTitleExpected .equals(titleActual)) {
			System.out.println("Error Page is displayed");
		}
		else {
			System.out.println("Landed Page is displayed correctly");
		}

				
		//Go To Home page
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		//How many Links are available in this webpage?
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	    //Using tagname with anchor
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	     System.out.println("The number of links is "+ links.size());

	}

}
