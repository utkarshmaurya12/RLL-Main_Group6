package com.ecommerce.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.qa.steps.TestBase;
public class TestSearchPage extends TestBase {
	
	WebDriver driver;
	
	
	//Actions a = new Actions(driver);
	
	@FindBy(xpath = "(//input[@class = 'main-search__input'])[1]")
	WebElement Searchbox;
	
	@FindBy(xpath = "(//button [@type = 'submit'])[1]")
	WebElement Searchbutton;
	
//	@FindBy(xpath = "//input[@id = 'CCPriceRangeMin']")
//	WebElement minprice;
//	
	@FindBy(xpath = "//input[@id = 'CCPriceRangeMax']")
	WebElement maxprice;
//	
	@FindBy(xpath = "//label[@data-value = 'Blue']")
	WebElement mycolor;
//	
	@FindBy(xpath = "(//button[@name='add'])[1]")
	WebElement product1;

	@FindBy(xpath = "(//button[@name='add'])[2]")
	WebElement product2;
	
	@FindBy(xpath = "(//button[@name='add'])[3]")
	WebElement product3;
	
	@FindBy(xpath = "//span[contains(.,'Continue shopping')]")
	WebElement continueshop;

	@FindBy(xpath = "//div[@class ='cc-animate-init -in cc-animate-complete']/descendant::p")
	public  WebElement invalidmsg;
	
	public TestSearchPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
public void enterTheproduct(String user1) throws InterruptedException
{
	Searchbox.sendKeys(user1);
	 Thread.sleep(1500);
}

public void enterTheWrongproduct(String user1) throws InterruptedException
{
	Searchbox.sendKeys(user1);
	 Thread.sleep(1500);
}

public void clickOnSearchbtn() throws InterruptedException
{
	Searchbutton.click();
	Thread.sleep(3000);
}
//	public void minimumprice() throws InterruptedException
//	{
//		minprice.sendKeys("0");
//		
//		Thread.sleep(3000);
//		
//	}
//	
	public void maximumprice(String user1) throws InterruptedException
	{
		maxprice.sendKeys(user1);
		Thread.sleep(3000);
	}
//	
	public void choosecolor() throws InterruptedException
	{
		mycolor.click();
		
		Thread.sleep(3000);
	}
//	
	public void addproduct1() throws InterruptedException
	
	{
		product1.click();
		Thread.sleep(3000);
	}
	public void addproduct2() throws InterruptedException
	{
		product2.click();
		Thread.sleep(3000);
	}
	public void addproduct3() throws InterruptedException
	{
		product3.click();
		Thread.sleep(3000);
	}
	public void continueshopping() throws InterruptedException
	{
		continueshop.click();
		Thread.sleep(3000);
	}
	
}
