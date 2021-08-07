package week4.day2;
/*Assignment 4:
=============
1) Go to https://www.nykaa.com/
2) Mouseover on Brands and Mouseover on Popular
3) Click L'Oreal Paris
4) Go to the newly opened window and check the title contains L'Oreal Paris
5) Click sort By and select customer top rated
6) Click Category and click Shampoo
7) check whether the Filter is applied with Shampoo
8) Click on L'Oreal Paris Colour Protect Shampoo
9) GO to the new window and select size as 175ml
10) Print the MRP of the product
11) Click on ADD to BAG
12) Go to Shopping Bag 
13) Print the Grand Total amount
14) Click Proceed
15) Click on Continue as Guest
16) Check if this grand total is the same in step 13
17) Close all windows*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//2) Mouseover on Brands and Mouseover on Popular
		Actions builder = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
		
		WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		builder.moveToElement(popular).perform();
		
		//	3) Click L'Oreal Paris
		WebElement Loreal = driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']"));
		builder.moveToElement(Loreal).click().perform();
		
		//4) Go to the newly opened window and check the title contains L'Oreal Paris
		//4a : Get all the window handles in a set
		Set<String> windowHandlesSet = driver.getWindowHandles();
				
		//4b : Move the Set of window handles into a list so that each of the window handle
		//can be accessed using the index value which is not possible with the set
		List<String> winList = new ArrayList<String>(windowHandlesSet);
				
		//4c: Switch the control to the specific window by selecting the required window handle
		driver.switchTo().window(winList.get(1));
		System.out.println("Step 4c : " +driver.getTitle());
		
		String actualTitle = driver.getTitle();
		
		//Splitting Title by space
		String[] splitTitle = actualTitle.split("\\s");
		
		int len = splitTitle.length;
		boolean lorealFlag = false;
		String titleContains = "L'Oreal";
		
		for (int i=0; i<len; i++) {
			String splitStringTitle = splitTitle[i];
			System.out.println(splitStringTitle);
	
			if(splitStringTitle .equals(titleContains)) {
				lorealFlag = true;
				System.out.println("The title contains L'Oreal and flag is true");
				break;
			}
		}
			if(lorealFlag == false) {
				System.out.println("Please check page you have landed");
				}

		//5) Click sort By and select customer top rated
			driver.findElement(By.id("sortComponent")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='control control--radio text-capitalize' and @for='3']")).click();
			Thread.sleep(1000);
			
		//6) Click Category and click Shampoo
			driver.findElement(By.xpath("//div[text()='Category']")).click(); //Category
			driver.findElement(By.xpath("//span[text()='Hair']")).click();   //hair
			driver.findElement(By.xpath("//span[text()='Hair Care']")).click();  //hair care
			Thread.sleep(1000);
			driver.findElement(By.xpath("//label[@for='chk_Shampoo_undefined']/div")).click();
			System.out.println("Done");
			
		//7) check whether the Filter is applied with Shampoo
			String filterText = driver.findElement(By.xpath("//li[text()='Shampoo']")).getText();
			System.out.println("Print filter Text = "+filterText);
			String expectedFilterText = "Shampoo";
			if(filterText.contains(expectedFilterText)) {
				System.out.println("Filter applied is Shampoo");
			}
			else{
				System.out.println("Filter is Not applied correctly");
			}
			
		//8) Click on L'Oreal Paris Colour Protect Shampoo
			driver.findElement(By.xpath("//span[contains(text(), 'Oreal Paris Colour Protect Shampoo')]")).click();
			
		//9) GO to the new window and select size as 175ml
			//9a : Get all the window handles in a set
			Set<String> windowHandlesSet1 = driver.getWindowHandles();
					
			//9b : Move the Set of window handles into a list so that each of the window handle
			//can be accessed using the index value which is not possible with the set
			List<String> winList1 = new ArrayList<String>(windowHandlesSet1);
					
			//9c: Switch the control to the specific window by selecting the required window handle
			driver.switchTo().window(winList1.get(2));
			System.out.println("Step 9c : " +driver.getTitle());
			
			driver.findElement(By.xpath("//span[text()='175ml']")).click();
			
			
		//10) Print the MRP of the product
			String mrpProduct = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
			System.out.println("The price of the product is"+ mrpProduct);
			Thread.sleep(1000);
			
		//11) Click on ADD to BAG
			driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
			Thread.sleep(1000);
			
		//12) Go to Shopping Bag 
			driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
			Thread.sleep(3000);
			
		//13) Print the Grand Total amount
			String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
			System.out.println("Grand Total is "+grandTotal);
			String grandTotal2 = grandTotal.replaceAll("[\\D]", "");  //replaces non digit
			System.out.println("Grand Total is "+grandTotal2);
			Thread.sleep(2000);
			
		//14) Click Proceed
		Actions act = new Actions(driver);
		WebElement proceed = driver.findElement(By.xpath("//div[@class='second-col']"));
		act.moveToElement(proceed).click(proceed).perform();
		Thread.sleep(2000);
			
		//15) Click on Continue as Guest
			driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
			Thread.sleep(1000);
			
		//16) Check if this grand total is the same in step 13
			String grandTotal1 = driver.findElement(By.xpath("(//div[@class='value'])[2]/span")).getText();
			System.out.println("The Grand Total is "+grandTotal1);
		
			if(grandTotal1.equals(grandTotal2)) {
				System.out.println("The total printed are right");
			}
			else {
				System.out.println("The total printed is not right");
			}
			
	}
		
}
