package step;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

public class DuplicateLead extends BaseClass1 {
	
	@Given ("Click link {string}")
	public void clickLink(String link){
	driver.findElement(By.linkText(link)).click();	
	}
	@Given ("click phone tab")
	public void phonetab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		}
	
	@Given ("Enter phone number")
	public void phone() {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
	}
	
	@Given ("click Find Leads button")
	public void findLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	
	@Given ("click first result")
	public void firstResult() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	@Given ("click submit button")
	public void submitButton() {
		driver.findElement(By.name("submitButton")).click();
	}
}
