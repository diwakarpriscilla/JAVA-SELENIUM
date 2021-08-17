package week6.day2;
  import org.testng.annotations.BeforeClass;
  import java.io.IOException;
  
  import org.openqa.selenium.By; import org.testng.annotations.DataProvider;
  import org.testng.annotations.Test;
  
  public class EditLead extends BaseClass {
  
  @Test(dataProvider = "fetchData") 
  public void runEditLead(String phNum, String
  comName) throws InterruptedException {
  driver.findElement(By.linkText("Leads")).click();
  driver.findElement(By.linkText("Find Leads")).click();
  driver.findElement(By.xpath("//span[text()='Phone']")).click();
  driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNum);
  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
  Thread.sleep(2000); driver.findElement(By.
  xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
  driver.findElement(By.linkText("Edit")).click();
  driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(comName);
  driver.findElement(By.name("submitButton")).click();
  System.out.println("Edit Lead Executed");
  }
  
  @BeforeClass
	  public void setFileName() {
		  excelFileName = "EditLeadExcelData";
	  }
  }
  
  
  
  
  
  
 