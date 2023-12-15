package com.ecommerce.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecommerce.qa.steps.TestBase;



public class SubscribePage extends TestBase {
	
	
	 WebDriver driver;
	 @FindBy(xpath="//input[@type='email']")
	 WebElement email;
	 
	 @FindBy(xpath="//input[@type='submit']")
	 WebElement subscribe;
	 
	 

	 @FindBy(css = ".notification > p")
	    WebElement confirmationMessage;
	 public SubscribePage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }
			 // public void emailoption(String emailAddress)
	// {
	//	 email.sendKeys(emailAddress);
	// }
	 
	
	 public void subscribebtn()
	 {
		 subscribe.click();
		 
	 } 
	 
	 public void enterdata(String user) {
		 email.sendKeys(user);
	 }
	
	 
	 
	 
	 //public void subscribepage(String message) {
		
		 //Assert.assertNotNull(confirmationMessage);
		 // Assert.assertTrue(confirmationMessage.isEnabled()&& confirmationMessage.isDisplayed());
	      //  confirmationMessage.sendKeys(message);
	       
	// }
	
	
	 
	 public boolean isConfirmationMessageDisplayed() throws InterruptedException {
	    	
	    	Thread.sleep(5000);
	        boolean isDisplayed = confirmationMessage.isDisplayed();
	        Assert.assertTrue(isDisplayed, "Confirmation message is not displayed!");
	        return isDisplayed;
	        
	        

	        
		   
		}

}
