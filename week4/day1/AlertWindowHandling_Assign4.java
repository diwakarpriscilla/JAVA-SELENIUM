package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWindowHandling_Assign4 {
	/*
	 * Alerts and Window handling --------------------------- 
	 * 1. Load https://www.irctc.co.in/ 
	 * 2. Click on OK button in the dialog 
	 * 3. Click on FLIGHTS link 
	 * 4. Go to the Flights tab 
	 * 5. Print the customer care email id 
	 * 6. Take a screenshot if this web page. 
	 * 7. Close the First tab(Train ticket booking) alone
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2. Click on OK button in the dialog 
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(1000);
		
		//3. Click on FLIGHTS link 
		WebElement flight = driver.findElement(By.xpath("(//li[@class='menu-list header-icon-menu'])[3]"));
		flight.click();
		Thread.sleep(1000);
		
		//4. Go to the Flights tab
		// How do I get into the new window
		// Step4.1 : Get all the window handles in a set
		Set<String> windowHandlesSet = driver.getWindowHandles();
		
		// Step4.2: Move the Set of window handles into a list so that each of the window handle
		//         can be accessed using the index value which is not possible with the set
		
		List<String> winList = new ArrayList<String>(windowHandlesSet);
		
		// Step4.3:
        // Switch the control to the specific window by selecting the required window handle
		driver.switchTo().window(winList.get(1));
		
		
		//5. Print the customer care email id 
		String email = driver.findElement(By.xpath("//a[@class='d-block font-weight-bold']")).getText();
		System.out.println("Customercare Email id is "+email);
		
		//6. Take a screenshot if this web page.
		File src1 = driver.getScreenshotAs(OutputType.FILE); // the page that has to be taken screen shot
		File dst = new File("./snaps/flighttab.png");
		FileUtils.copyFile(src1, dst);
		
		//7. Close the First tab(Train ticket booking) alone
		driver.switchTo().window(winList.get(0));
		driver.close();
		
	}

}
