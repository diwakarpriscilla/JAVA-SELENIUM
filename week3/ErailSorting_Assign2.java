package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSorting_Assign2 {
	/*
	 * ErailSorting
	 * 
	 * 1.Launch the browser
	 * 
	 * 2.Launch the URL - https://erail.in/
	 * 
	 * 3.Uncheck the check box - sort on date
	 * 
	 * 4.clear and type in the source station
	 * 
	 * 5.clear and type in the destination station
	 * 
	 * 6.Find all the train names using xpath and store it in a list
	 * 
	 * 7.Use Java Collections sort to sort it and then print it
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// 3. Un-check the check box - sort on date
		WebElement sortOnDate = driver.findElement(By.id("chkSelectDateOnly"));
		boolean enabledsortOnDate = sortOnDate.isEnabled();
		if (enabledsortOnDate == true) {
			System.out.println("Unchecking the sort on Date");
			sortOnDate.click();
		} else {
			System.out.println("Sort on Date is already Unchecked");
		}

		// 4. clear and type in the source station
		WebElement sourceStation = driver.findElement(By.id("txtStationFrom"));
		sourceStation.clear();
		sourceStation.sendKeys("Chennai Eg", Keys.ENTER, Keys.TAB, Keys.TAB);
		
		//5.clear and type in the destination station
		WebElement destinationStation = driver.findElement(By.id("txtStationTo"));
		destinationStation.clear();
		destinationStation.sendKeys("Delhi",Keys.ENTER);
		Thread.sleep(2000);
		
		//6.Find all the train names using xpath and store it in a list
		List<WebElement> trainDetails = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[@data-id]"));
		System.out.println("No. of trains returned via search is "+ trainDetails.size());
		Thread.sleep(2000);
		
		List<WebElement> trainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[@data-id]/td[2]"));
		System.out.println("Printing Train Names : ");
		Thread.sleep(2000);
		
		List<String> toAddTrainNames = new ArrayList<String>();
		
		for (WebElement webElement : trainName) 
		{
			String train_name = webElement.getText();
			System.out.println(train_name);
			  toAddTrainNames.add(train_name);    
			}
		 
		//7.Use Java Collections sort to sort it and then print it
		Collections.sort(toAddTrainNames);
		System.out.println("The sorted list is :" + toAddTrainNames);
	}
}
