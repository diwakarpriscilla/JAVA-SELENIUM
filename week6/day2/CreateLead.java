  package week6.day2;
  
  import java.io.IOException;
  
  import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
  import org.testng.annotations.Test;
  
  public class CreateLead extends BaseClass{
  
  @Test (dataProvider = "fetchData") 
  
  public void runCreateLead(String company, String fName, String lName, String PNumber) {
  driver.findElement(By.linkText("Leads")).click();
  driver.findElement(By.linkText("Create Lead")).click();
  driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
  driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
  driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
  driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(PNumber); 
  driver.findElement(By.name("submitButton")).click();
  System.out.println("Create Lead Executed");
  }
  
  @BeforeClass
  public void setFileName() {
	  excelFileName = "CreateLead";
  }

  }
 