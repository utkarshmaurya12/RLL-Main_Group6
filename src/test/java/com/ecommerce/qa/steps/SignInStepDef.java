package com.ecommerce.qa.steps;
 
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
 
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import org.testng.asserts.SoftAssert;

import com.ecommerce.qa.pages.SignInPage;
import com.ecommerce.qa.utilities.ExcelDataProvider;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
 
 
 
public class SignInStepDef {
	SoftAssert sa = new SoftAssert();
	SignInPage sp = new SignInPage(TestBase.driver);
	public String expectedUrlSubstring = "challenge";
	public WebDriverWait Wait =new WebDriverWait(TestBase.driver,Duration.ofSeconds(120000));
	
	
	@Given("I am on the Furniture Website HomePage")
	public void i_am_on_the_furniture_website_home_page() {
		sp = PageFactory.initElements(TestBase.driver, SignInPage.class);
		TestBase.driver.get("https://www.chilternoakfurniture.co.uk/");
	}
 
	@When("I click on Sign In icon")
	public void i_click_on_sign_in_icon() {
	   sp.clickSignInIcon();
	   String Expected_title = "Account – Chiltern Oak Furniture";
	   String Actual_title = TestBase.driver.getTitle();
	   sa.assertEquals(Expected_title, Actual_title);
	}
	
    
	@When("I enter EmailId and Password")
	public void i_enter_email_id_and_password() throws InterruptedException, EncryptedDocumentException, IOException {
        List<Map<String,String>>testdata = ExcelDataProvider.getTestData("SignIn1");
		
		for(Map<String, String>e : testdata) {
			
			
			String Txtbox_Emailid =String.valueOf(e.get("EmailId"));
			
			String Txtbox_Password =String.valueOf(e.get("Password"));
			
			sp.enterSignInDetails(Txtbox_Emailid, Txtbox_Password);
			
	     }
	}
	
 
	@Then("I click on Sign In button")
	public void i_click_on_sign_in_button()  {
	    sp.clickSignInSubmitButton();
	    Wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(expectedUrlSubstring)));
	    String expectedURL = "https://www.chilternoakfurniture.co.uk/account";
	    String Actual_URL = sp.validateURL();
	    sa.assertEquals(expectedURL, Actual_URL);
	   
	}
	
	@When("I enter wrong EmailId and Password")
	public void i_enter_wrong_email_id_and_password() throws EncryptedDocumentException, IOException {
List<Map<String,String>>testdata = ExcelDataProvider.getTestData("SignIn2");
		
		for(Map<String, String>e : testdata) {
			
			
			String Txtbox_Emailid =String.valueOf(e.get("EmailId"));
			
			String Txtbox_Password =String.valueOf(e.get("Password"));
			
			sp.enterSignInDetails(Txtbox_Emailid, Txtbox_Password);
			
			
		    
			
	     }
		
	}
	
	@Then("click on Sign In button")
	public void click_on_sign_in_button() throws InterruptedException {
		sp.clickSignInSubmitButton();
		
		Wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(expectedUrlSubstring)));
	    String actualMessage = sp.message_validation.getText();
	    sa.assertEquals("Incorrect email or password.", actualMessage);
	   
	    
	    sa.assertAll();
     
	
	
	}

}

