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

public class Amazon {
	
	/*
	 * Amazon: 
	 * ======== 
	 * //Load the uRL https://www.amazon.in/ 
	 * //search as oneplus 9 pro
	 * //Get the price of the first product 
	 * // Print the number of customer ratings for the first displayed product 
	 * // Mouse Hover on the stars 
	 * // Get the percentage of ratings for the 5 star. 
	 * // Click the first text link of the first image 
	 * // Take a screen shot of the product displayed 
	 * // Click 'Add to Cart' button 
	 * // Get the cart subtotal and verify if it is correct.
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Get the price of the first product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The price of the first product is "+ price);
		String price_amount = price.replaceAll("[\\D]", "");
		System.out.println(price_amount);
		int price_amount_com = Integer.parseInt(price_amount);
		System.out.println("Price is "+price_amount_com);
		Thread.sleep(1000);
		
		// Print the number of customer ratings for the first displayed product 
		String review = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
		System.out.println("The review count of the first product is "+ review);
		Thread.sleep(1000);
		
		// Mouse Hover on the stars
		Actions builder = new Actions(driver);
		WebElement star = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom']"));
		builder.moveToElement(star).click().perform();
		Thread.sleep(1000);
		
		// Get the percentage of ratings for the 5 star.
		String percentage = driver.findElement(By.xpath("(//td[@class='a-text-right a-nowrap']/span)[2]")).getText();
		System.out.println("Percentage of rating for 5 star is "+ percentage);
		Thread.sleep(1000);
		
		// Click the first text link of the first image
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(winList.get(1));
		  
		// Take a screen shot of the product displayed
		File src1 = driver.getScreenshotAs(OutputType.FILE); // the page that has to be taken screen shot
		File dst = new File("./snaps/phone.png");
		FileUtils.copyFile(src1, dst);
		Thread.sleep(2000);
			
		 
		// Click 'Add to Cart' button 
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		System.out.println("Item added to cart");
		Thread.sleep(1000);
		
		//"*********Not Working******"
		
		// Get the cart sub-total and verify if it is correct.
		/*
		 * Actions builder2 = new Actions(driver); WebElement subTotalElement =
		 * driver.findElement(By.
		 * xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']/span"));
		 * builder2.moveToElement(subTotalElement).perform(); String subTotal
		 * =subTotalElement.getText();
		 */
		
		String subTotal = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']/span")).getText();
		
		
		System.out.println("The Price as String with comma" +subTotal);
		String subTotal_amount = subTotal.replaceAll("[\\D]", "");
		System.out.println("The Price as String with digits alone" +subTotal_amount);
		int subTotal_amount_com = Integer.parseInt(subTotal_amount);
		System.out.println("The Price as Integer" +subTotal_amount_com);
		
		if(price_amount_com == subTotal_amount_com) {
			System.out.println("Prices are same");
		}
		else
		{
			System.out.println("Prices are different");
		}
	}

}
