package ServiceNow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_SNOW {
	public ChromeDriver driver;
	public String incident_Number1;
	
	@Parameters ({"url", "username", "password"})
	@BeforeMethod
	public void login(String urla, String uname, String pword) {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get(urla);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	WebElement frame1 = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(frame1);
	driver.findElement(By.id("user_name")).sendKeys(uname);
	driver.findElement(By.id("user_password")).sendKeys(pword);
	driver.findElement(By.id("sysverb_login")).click();
		}
	
	@BeforeMethod (dependsOnMethods = "login")
	public void Incident() throws InterruptedException {
		//3. Enter Incident in filter navigator and press enter
		WebElement filter = driver.findElement(By.id("filter"));
		Thread.sleep(1000);
		filter.sendKeys("Incident",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		Thread.sleep(1000);
	}
		/*
		 * @AfterMethod public void postCondition() { driver.close(); }
		 */
}
