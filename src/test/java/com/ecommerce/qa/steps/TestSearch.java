package com.ecommerce.qa.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.testng.asserts.SoftAssert;
import com.ecommerce.qa.pages.TestSearchPage;
import com.ecommerce.qa.utilities.ExcelDataProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class TestSearch {
	
	SoftAssert sa = new SoftAssert();
	
	TestSearchPage obj = new TestSearchPage(TestBase.driver);
	
	@Then("User enters product")
	public void user_enters_product() throws InterruptedException, EncryptedDocumentException, IOException {
		List<Map<String,String>>testdata = ExcelDataProvider.getTestData("Search1");
		
		for(Map<String, String>e : testdata) {
			
			String Searchbox =String.valueOf(e.get("Search"));
			
			obj.enterTheproduct(Searchbox);
			
	     }
		
		}

	@Then("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
	   obj.clickOnSearchbtn();
//	   String Expected_title = "Search: 388 results found for \"Table\" – Chiltern Oak Furniture";
//	   String Actual_title = bt.driver.getTitle();
//	   Assert.assertEquals(Expected_title, Actual_title);
	}

	@Then("User Enters maximun price")
	public void user_enters_maximun_price() throws InterruptedException, EncryptedDocumentException, IOException {
		List<Map<String,String>>testdata = ExcelDataProvider.getTestData("Filter");
		
		for(Map<String, String>e : testdata) {
			
			String maxprice =String.valueOf(e.get("max_price"));
			
			obj.maximumprice(maxprice);
	}
	}
//
	@Then("Choose the colour")
	public void choose_the_colour() throws InterruptedException {
	    obj.choosecolor();
	}
//
	@Then("User added Product1 to cart")
	public void user_added_product1_to_cart() throws InterruptedException {
	    obj.addproduct1();
	}
	@Then("User click on continue shopping1")
	public void user_click_on_continue_shopping1() throws InterruptedException {
	    obj.continueshopping();
	}
//
//
//	    
	@Then("User added Product2 to cart")
	public void user_added_product2_to_cart() throws InterruptedException {
	    obj.addproduct2();
	}
//	
	@Then("User click on continue shopping2")
	public void user_click_on_continue_shopping2() throws InterruptedException {
	    obj.continueshopping();
	}

	@Then("User added Product3 to cart")
	public void user_added_product3_to_cart() throws InterruptedException {
	    obj.addproduct3();
	}
	
//	
	@Then("User click on continue shopping3")
	public void user_click_on_continue_shopping3() throws InterruptedException {
	    obj.continueshopping();
	}
	
	@Given("User enters Wrong product")
	public void user_enters_wrong_product() throws EncryptedDocumentException, IOException, InterruptedException {
		List<Map<String,String>>testdata = ExcelDataProvider.getTestData("Search2");
		
		for(Map<String, String>e : testdata) {
			
			String Searchbox =String.valueOf(e.get("Wrong"));
			
			obj.enterTheproduct(Searchbox);
			
	     }
	}
	@Then("User click on search button1")
	public void user_click_on_search_button1() throws InterruptedException {
	    obj.clickOnSearchbtn();
	    
	   
	}
	 
	@Then("User checks for Display message")
	public void user_checks_for_display_message() {
		 sa.assertEquals(obj.invalidmsg.getText(), "No search results");
	}
}
