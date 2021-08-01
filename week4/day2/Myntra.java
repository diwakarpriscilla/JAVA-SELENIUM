package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	/*
	 * *Project :Myntra* 
	 * 1) Open https://www.myntra.com/ 
	 * 2) Mouse hover on MeN 
	 * 3) Click Jackets 
	 * 4) Find the total count of item 
	 * 5) Validate the sum of categories count matches 
	 * 6) Check jackets 
	 * 7) Click + More option under BRAND
	 * 8) Type Duke and click checkbox 
	 * 9) Close the pop-up x 
	 * 10) Confirm all the Coats are of brand Duke Hint : use List 
	 * 11) Sort by Better Discount 
	 * 12) Find the price of first displayed item Click on the first product 
	 * 13) Take a screen shot 
	 * 14) Click on WishList Now 
	 * 15) Close Browser
	 */

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//2) Mouse hover on MeN
		Actions builder = new Actions(driver);
		WebElement elementMen = driver.findElement(By.xpath("//a[text()='Men']"));
		builder.moveToElement(elementMen).perform();
		
		//3. Click Jacket
		WebElement elementJacket = driver.findElement(By.linkText("Jackets"));
		elementJacket.click();
		
		//4) Find the total count of item 
		String textItemCount1 = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println(textItemCount1);
		
		String textItemCount1a = textItemCount1.replaceAll("[\\D]", "");
		System.out.println(textItemCount1a);
		int totalJacket = Integer.parseInt(textItemCount1a);
		
		String textItemCount2 = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println(textItemCount2);
		String textItemCount2a = textItemCount2.replaceAll("[\\D]", "");
		System.out.println(textItemCount2a);
		int jacket = Integer.parseInt(textItemCount2a);
		
		String textItemCount3 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println(textItemCount3);
		String textItemCount3a = textItemCount3.replaceAll("[\\D]", "");
		System.out.println(textItemCount3a);
		int rainJacket = Integer.parseInt(textItemCount3a); 
		
		//5) Validate the sum of categories count matches 
		
		int sum = jacket + rainJacket;
		
		if(sum == totalJacket) {
			System.out.println("Total Jacket counts is equal to Jacket and RainJacket");
		}
		else {
			System.out.println("Total Jacket counts is NOT equal to Jacket and RainJacket");
		}
		
		//6) Check jackets 
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		
		//7) Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(3000);
		
		//8) Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke", Keys.ENTER);
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		
		//9) Close the pop-up x 
	    driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	    
	    //10) Confirm all the Coats are of brand Duke Hint : use List 
	    List<WebElement> elementDuke = driver.findElements(By.xpath("//h3[contains(text(),'Duke')]"));
	    String compText = "Duke";
		  
		  boolean dukeFlag = false;
		  
		  for (WebElement ele : elementDuke) {
		  String text2 = ele.getText();
		  if (text2 .equals(compText)) {
			dukeFlag = true;  
		  }
		  else {
			  dukeFlag = false;  
			  System.out.println("Missing Duke ");
			  break;
		  } 
		  }
		  
		  System.out.println("Printing dukeFlag, true meaning all are Duke: " + dukeFlag);
		  
		  //11) Sort by Better Discount
		  Actions builder1 = new Actions(driver);
		  WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		  builder1.moveToElement(sortBy).perform();
		  System.out.println("Mouse Hover to Sort by completed");
		  
		  WebElement betterdiscount = driver.findElement(By.xpath("//div[@class='sort-sortBy']/ul/li[3]/label"));
		  builder1.click(betterdiscount).perform();
		  System.out.println("Mouse Hover to betterdiscount by completed");
		  Thread.sleep(1000);
		  
		  //12) Find the price of first displayed item Click on the first product 
		  String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		  System.out.println("Price is " +price);
		  
		  driver.findElement(By.xpath("//picture[@class='img-responsive']")).click();
		  System.out.println("Clicked first item");
		  
		  //13) Take a screen shot 
		  
		  Set<String> windowHandlesSet = driver.getWindowHandles();
		  List<String> winList = new ArrayList<String>(windowHandlesSet);
		  driver.switchTo().window(winList.get(1));
		  
		  
			File src1 = driver.getScreenshotAs(OutputType.FILE); // the page that has to be taken screen shot
			File dst = new File("./snaps/duke1.png");
			FileUtils.copyFile(src1, dst);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
			driver.close();
			
	}

}
