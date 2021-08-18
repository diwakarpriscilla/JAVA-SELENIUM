package step;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClass1 {

	@Given ("Click the link Create Lead")
	public void clickCreateLead() {
	driver.findElement(By.linkText("Create Lead")).click();	
	}
	
	@Given ("Enter Company name {string}")
	public void companyName(String compName) throws InterruptedException {
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);	
	Thread.sleep(2000);
	}
	@Given ("Click find Leads")
	public void findLeadsLink() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(1000);
	}
	@Given ("Enter First Name {string}")
	public void fNme(String fName) throws InterruptedException {
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	Thread.sleep(1000);
	}
	
	@Given ("Enter Last Name {string}")
	public void lastName(String lastName) throws InterruptedException {	
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	Thread.sleep(2000);
	}
	
	@Given ("Enter Phone Name {string}")
	public void phonrNumber(String pNumber) {
	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNumber);	
	}

	@When ("Click SUBMIT button")
	public void Submit() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then ("View Leads page should be displayed")
	public void verifyLeadsPage() {
	String titleViewLeadPage = "View Lead | opentaps CRM";
	
	String pageTitle2 = driver.getTitle();
	if (titleViewLeadPage.equals(pageTitle2)) {
		System.out.println("We have landed to correct View Lead page");
	} else {
		System.out.println(pageTitle2);
		System.out.println("Incorrect page");
	}
	}
	
}
