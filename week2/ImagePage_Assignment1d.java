package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage_Assignment1d {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		// Click on this image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();

		// Am I Broken Image?
		// article:
		// https://www.lambdatest.com/blog/find-broken-images-using-selenium-webdriver/

		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		WebElement image = driver.findElement(By.xpath("//label[@for='position']/following-sibling::img"));
		if (image.getAttribute("naturalWidth").equals("0")) {
			System.out.println(image.getAttribute("outerHTML") + " is broken.");
		} else {
			System.out.println("Image is not broken");
		}

		// Use Keyboard and Mouse

		WebElement image2 = driver.findElement(By.xpath("(//label[@for='position'])[2]/following-sibling::img"));

		Actions actions = new Actions(driver);
		actions.doubleClick(image2).build().perform();

	}

}
