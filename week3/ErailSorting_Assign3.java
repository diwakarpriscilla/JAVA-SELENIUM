package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSorting_Assign3 {
	//Assignment 3:  Assignment 3:Erail-get unique train list
               
	/*
	 * 1.Launch the URL - https://erail.in/
	 * 
	 * 2.Click the 'sort on date' checkbox
	 * 
	 * 3.clear and type in the from station text field
	 * 
	 * 4.clear and type in the to station text field
	 * 
	 * 5.Add a java sleep for 2 seconds
	 * 
	 * 6.Store all the train names in a list
	 * 
	 * 7.Get the size of it
	 * 
	 * 8.Add the list into a new Set
	 * 
	 * 9.And print the size of it
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
		
		//Sleep for 2 seconds
		Thread.sleep(2000);
		
		//6.Store all the train names in a list
		List<WebElement> trainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[@data-id]/td[2]"));
		System.out.println("No. of trains returned via search is "+ trainName.size());
		System.out.println("Printing Train Names : ");
		Thread.sleep(2000);
	
		//Add the list into a new Set
		
		
		List<String> toAddTrainNames = new ArrayList<String>();
		for (WebElement webElement : trainName) 
		{
			String train_name = webElement.getText();
			System.out.println(train_name);
			toAddTrainNames.add(train_name);
			}
		
		Set<String> hSet = new HashSet<String>(toAddTrainNames);
		
		//And print the size of it
		System.out.println("The size of the set is " + hSet.size());

	}
}
