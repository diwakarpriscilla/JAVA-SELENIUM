package week6.day2;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
 public ChromeDriver driver;
 public String excelFileName;
 
 @Parameters({"url", "username", "password"}) //name should be exactly matching with the testng.xml
  @BeforeMethod
  public void preCondition(String url, String uName, String pwd) {
	  	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
  }
 
 @DataProvider(name="fetchData") 
 public String[][] sendData() throws IOException {
 ReadExcelDataProvider excel = new ReadExcelDataProvider(); 
 return excel.readData(excelFileName);
 }

	
	  @AfterMethod 
	  public void postCondition() { 
		  driver.close(); }
	 
}
