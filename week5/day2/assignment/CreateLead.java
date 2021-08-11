package week5.day2.assignment;

import java.io.IOException;

import org.openqa.selenium.By;
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
  }
  @DataProvider(name="fetchData")
  public String[][] sendData() throws IOException {
	  
	  ReadExcelDataProvider excel = new ReadExcelDataProvider();
	  //String[][] readData = excel.readData("CreateLead");
	  return excel.readData("CreateLead");
  }
}