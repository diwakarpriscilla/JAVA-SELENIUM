package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton_Assignment1f {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();

		// Are you enjoying the classes?
		driver.findElement(By.id("yes")).click();

		// Find default selected radio button
		WebElement checkedElement = driver.findElement(By.name("news"));
		boolean selected = checkedElement.isSelected();
		if (selected == true) {
			System.out.println("The default selected radio button is Unchecked");
		} else
			System.out.println("The default selected radio button is Checked");

		// Select your age group (Only if choice wasn't selected)
		WebElement ageGroup = driver
				.findElement(By.xpath("//input[@type='radio' and @class='myradio' and @name='age' and @value='1']"));
		boolean enabled = ageGroup.isEnabled();
		if (enabled == true) {
			System.out.println("Age group enabled is 21-40");
		} else {
			ageGroup.click();
		}

	}

}
