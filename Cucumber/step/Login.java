package step;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass1 {
	
	
	@Given ("Enter Username {string}")
	public void enterUserName(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);	
	}
	
	@Given ("Enter Password {string}")
	public void enterPassword(String pWord) {
		driver.findElement(By.id("password")).sendKeys(pWord);
	}
	
	@When ("Click Login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	
	@Then ("Homepage should be displayed")
	public void homePage() {
		String originalTitle = "Leaftaps - TestLeaf Automation Platform";
		String pageTitle = driver.getTitle();
		if (originalTitle.equals(pageTitle)) {
			System.out.println("We have landed to correct page");
		} else
			System.out.println("Incorrect page");
	}
	
	@Given("Click CRMandSFA link")
	public void crm_sfalink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@Given ("Click the Leads Tab")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}
	
}
