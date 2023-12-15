package com.ecommerce.qa.steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.qa.pages.SubscribePage;
import com.ecommerce.qa.utilities.ExcelDataProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Subscribes {
	public String expectedUrlSubstring = "challenge";
	public WebDriverWait Wait =new WebDriverWait(TestBase.driver,Duration.ofSeconds(120000));
		
	SubscribePage sp = new SubscribePage(TestBase.driver);
	
	@Given("user is on landing page")
	 public void user_is_on_landing_page() {
	//	  driver = new ChromeDriver();
		//   driver.manage().window().maximize();
		  // sp = PageFactory.initElements(driver,SubscribePage.class);
			//driver.get("https://www.chilternoakfurniture.co.uk/");
			
			String Expected_title = "chiltern oak furniture";
			String Actual_title = "chiltern oak furniture";
			
			Assert.assertEquals(Actual_title, Expected_title);	
		
			 }
	
	@Given("the user is on the subscription page")
	public void the_user_is_on_the_subscription_page() {
		System.out.println("The user is on the subscription page");
		
		
		
	
	}

	@When("the user enters thier {string}")
	public void the_user_enters_thier_email(String email) throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		List<Map<String,String>> testdata = ExcelDataProvider.getTestData("Subscribe1");
		for(Map<String , String>e : testdata) {
			email =String.valueOf(e.get("Email"));	
			sp.enterdata(email);
		 Thread.sleep(3000);
		}
	    
	}

	@When("clicks on the subscribe button")
	public void clicks_on_the_subscribe_button() throws InterruptedException{
	   sp.subscribebtn();
		
	}
	@Then("they should see a confirmation message")
	public void they_should_see_a_confirmation_message() {
		System.out.println("They should see a confirmation message");
		   Wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(expectedUrlSubstring)));	   
	}
	@When ("the user enters their Invalid {string}")
		 public void the_user_enter_thier_Invalid_email(String email) throws InterruptedException, EncryptedDocumentException, IOException {
			
			 List<Map<String,String>> testdata = ExcelDataProvider.getTestData("Subscribe2");
				for(Map<String , String>e : testdata) {
					email =String.valueOf(e.get("Email"));	
					
					
					sp.enterdata(email);
					
					Thread.sleep(2000);
					
		}
				}	

     @Then("system shows fill the requirement")
    
     public void system_shows_fill_the_requirement() throws InterruptedException {
 
	   System.out.println("System shows fill the requirement");
		Thread.sleep(2000);
}

	    
		
}

	
	

		
	

