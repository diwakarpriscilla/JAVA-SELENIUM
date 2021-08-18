package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLead extends BaseClass1 {
		
	@Given ("Enter First Name in Lead page {string}")
	public void firstNameLeadPage(String fName1) throws InterruptedException {
		driver.findElement(By.xpath("(//input[@type='text' and @name='firstName'])[3]")).sendKeys(fName1);
		Thread.sleep(3000);
			}

	@Given ("Pick the first Lead")
	public void firstLead() throws InterruptedException {
		driver.findElement(
				By.xpath("//td[@class= 'x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a[1]")).click();
		Thread.sleep(2000);
	}
	
	@Given ("click Find Lead button")
	public void clickFindLead() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}
	
	@Given ("Click Edit")
	public void editLead() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='subMenuButton' and text()='Edit']")).click();
		Thread.sleep(2000);
	}
	
	@Given ("change company name {string}")
	public void changeCompanyName(String newCompanyName) {
		WebElement elementCompany = driver.findElement(By.id("updateLeadForm_companyName"));
		elementCompany.clear();
		elementCompany.sendKeys(newCompanyName);
	}
	@When ("Clicked submit Update button")
	public void clickUpdateButton() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
		Thread.sleep(1000);
	}
	@Then ("Confirm the changed name is displayed {string}")
	public void changedName(String newCompanyName) {
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Company name after updation is " + updatedCompanyName);
		
		//if(newCompanyName .equals(updatedCompanyName)) 
		if (updatedCompanyName .startsWith(newCompanyName)){
			System.out.println("Company name is updated");
		}
		else {
			System.out.println("Company name is not updated");
		}
	}
	
}
