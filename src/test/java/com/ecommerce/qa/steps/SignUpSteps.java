package com.ecommerce.qa.steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.ecommerce.qa.pages.SignUpPageObjects;
import com.ecommerce.qa.utilities.ExcelDataProvider;




public class SignUpSteps {
	
	SoftAssert soft = new SoftAssert();
	//public String expectedUrlSubstring = "challenge";
	//public WebDriverWait Wait =new WebDriverWait(TestBase.driver,Duration.ofSeconds(120000));
	
	static String email;
	SignUpPageObjects sob = new SignUpPageObjects(TestBase.driver);
		
	@When("User click on Admin logo")
	public void user_click_on_admin_logo() {
	    
		sob.clickAccount();
		
		String Expected_title = "Account – Chiltern Oak Furniture";
		String Actual_title = TestBase.driver.getTitle();
		
		soft.assertEquals(Actual_title, Expected_title);
	}
	
	@Then("User click on Signup")
	public void user_click_on_signup() {
	    
		sob.clickSignupLink();
		
		String Expected_URL = "https://www.chilternoakfurniture.co.uk/account/register";
		String Actual_URL = sob.validate_CurrentURL();
		
		soft.assertEquals(Actual_URL, Expected_URL);	
	}
	
	@When("User enters data from {string} and {int}")
	public void user_enters_data_from_and(String SheetName, Integer RowNumber) throws EncryptedDocumentException, IOException, InterruptedException {
	    
		List<Map<String,String>> testdata = ExcelDataProvider.getTestData(SheetName);
		
		String fname = testdata.get(RowNumber).get("Firstname");
		String lname = testdata.get(RowNumber).get("Lastname");
		email = testdata.get(RowNumber).get("Email");
		String pass = testdata.get(RowNumber).get("Password");
		
		sob.enterData(fname, lname, email, pass);
		Thread.sleep(1000);	
	}
	
	@Then("User click on create account")
	public void user_click_on_create_account() throws InterruptedException, IOException {
	   	
		soft.assertEquals(true,sob.validate_createBtn());
		
		try{
			
  			sob.clickCreateBtn();
			//Wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(expectedUrlSubstring)));
			Thread.sleep(120000);
			boolean val = sob.validationDemo(email, sob.validate_Email());	
			soft.assertEquals(true, val);
				
			sob.signOut();
		}
		catch(Exception e) {
			
			soft.fail("Signout is not present");
		}
		soft.assertAll();
		
		/*String Actual_mail = sob.validate_Email();
		String Expected_mail = email;
		Assert.assertEquals(Actual_mail, Expected_mail);*/
	}
	
	
	@Then("User try to click on create account")
	public void user_try_to_click_on_create_account() throws InterruptedException, IOException {
	   	
		soft.assertEquals(true,sob.validate_createBtn());
		
		try{
			
			sob.clickCreateBtn();
			
			boolean val = sob.validationDemo(email, sob.validate_Email());	
			soft.assertEquals(true, val);
				
			sob.signOut();
		}
		catch(Exception e) {
			
			soft.fail("Signout is not present");
		}
		soft.assertAll();
	}
	
}
