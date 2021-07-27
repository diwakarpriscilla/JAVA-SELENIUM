package week3.day2;
/*1. Launch the URL https://www.ajio.com/
2. In the search box, type as "bags" and press enter
3. To the left  of the screen under " Gender" click the "Men"
4. Under "Category" click "Fashion Bags"
5. Print the count of the items Found. 
6. Get the list of brand of the products displayed in the page and print the list.
7. Get the list of names of the bags and print it*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class List_Ajio_Assign1 {
	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.ajio.com/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	//In the search box, type as "bags" and press enter
	WebElement searchBox = driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']"));
	searchBox.sendKeys("bags",Keys.ENTER);
	Thread.sleep(2000);
	
	//To the left  of the screen under " Gender" click the "Men"
	driver.findElement(By.xpath("//label[@for='Men']")).click();
	Thread.sleep(1000);
	
	//Under "Category" click "Fashion Bags"
	driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
	Thread.sleep(2000);
	
	//Print the count of the items Found
	WebElement itemCount = driver.findElement(By.xpath("//div[@class='length']"));
			String text = itemCount.getText();
	System.out.println("Number of items found = " +text);
	
	//Get the list of brand of the products displayed in the page and print the list.
	List<WebElement> bagBrandList = driver.findElements(By.xpath("//div[@class='brand']"));
	System.out.println("No. of brands Identified = "+bagBrandList.size());
	System.out.println("Printing Bag list");
	for (WebElement webElement : bagBrandList) {
		String text1 = webElement.getText();
		System.out.println(text1);
	}
	
	//Get the list of names of the bags and print it
	List<WebElement> bags = driver.findElements(By.xpath("//div[@class='name']"));
	Thread.sleep(2000);
	System.out.println("No. of bags displayed = "+bags.size());
	System.out.println("Printing the name of the bag");
	for (WebElement webElement : bags) {
		String text2 = webElement.getText();
		System.out.println(text2);
		
	}
	}

}
