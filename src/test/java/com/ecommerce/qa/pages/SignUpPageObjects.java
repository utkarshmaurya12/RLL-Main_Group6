package com.ecommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.qa.steps.TestBase;


public class SignUpPageObjects extends TestBase {

	@FindBy(xpath = "//a[@class = 'toolbar-account']")
	WebElement Account;
	
	@FindBy(xpath = "(//a[@class = 'standard-link'])[2]")
	WebElement signuplink;
	
	@FindBy(xpath = "//input[@id = 'first_name']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@id = 'last_name']")
	WebElement lname;
	
	@FindBy(xpath = "//input[@id = 'email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id = 'password']")
	WebElement password;
		
	@FindBy(xpath = "(//input[@type = 'submit'])[1]")     
	WebElement createbtn;
	
	@FindBy(xpath = "//a[@class = 'toolbar-account']")
	WebElement inner;
	
	@FindBy(xpath = "//div[@id = 'customer_sidebar']/descendant::p")
	WebElement emailtext;
	
	@FindBy(xpath = "//a[@class = 'more-link']")
	WebElement signout;
	
	
	public SignUpPageObjects(WebDriver driver) {
		
		PageFactory.initElements(driver , this);
	}
	
	
	public void clickAccount() {
		
		Account.click();
	}
	
	public void clickSignupLink() {
		
		signuplink.click();
	}
	
	public void enterData(String user1, String user2 , String user3 , String user4) {
		
		fname.sendKeys(user1);
		lname.sendKeys(user2);
		email.sendKeys(user3);
		password.sendKeys(user4);	
	}
	
	public void clickCreateBtn() throws InterruptedException  {
		
		createbtn.click();
	}
	
	public boolean validate_createBtn() {
		
		return createbtn.isEnabled();
	}
	
	public String validate_CurrentURL() {
		
		return driver.getCurrentUrl();
	}
	
	public String validate_Email() throws InterruptedException {
		
		clickAccount();
		Thread.sleep(2000);
		return emailtext.getText();	
	}
	
	public void signOut() {
		
		signout.click();
	}
	
	public boolean validationDemo(String s1 , String s2) {
		
		if(s1.equalsIgnoreCase(s2)) {
			return true;
		}
		return false;
		
	}
	
}

