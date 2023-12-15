package com.ecommerce.qa.steps;

import com.ecommerce.qa.pages.ContactUsPage;
import com.ecommerce.qa.utilities.ExcelDataProvider;
import com.ecommerce.qa.utilities.ScreenshotUtil;

import io.cucumber.java.en.*;
import org.junit.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsTest {

    ContactUsPage Contact = new ContactUsPage(TestBase.driver);
    public static final Logger logger = LogManager.getLogger(ContactUsTest.class);
	public String expectedUrlSubstring = "challenge";
	public WebDriverWait Wait =new WebDriverWait(TestBase.driver,Duration.ofSeconds(120000));
	
    @Given("User navigates to the Contact Us page")
    public void userNavigatesToContactUsPage() {
        try {
            TestBase.driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();
        } catch (Exception e) {
            logger.error("Error navigating to Contact Us page: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(TestBase.driver, "NavigationError");
            Assert.fail("Error navigating to Contact Us page: " + e.getMessage());
        }
    }

    @When("User fills in the contact form")
    public void userFillsInContactForm() throws EncryptedDocumentException, IOException, InterruptedException {
        try {
            List<Map<String, String>> testdata = ExcelDataProvider.getTestData("ContactUsData");

            for (Map<String, String> e : testdata) {

                String name = String.valueOf(e.get("name"));
                String email = String.valueOf(e.get("email"));
                String phone = String.valueOf(e.get("phone"));
                String message = String.valueOf(e.get("message"));

                Contact.fillContactForm(name, email, phone, message);

                Thread.sleep(1000);

            }

        } catch (Exception e) {
            logger.error("Error filling the contact form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(TestBase.driver, "FormFillError");
            Assert.fail("Error filling the contact form: " + e.getMessage());
        }
    }

    @When("User fills in the contact form With Invalid Data")
    public void userFillsInContactFormInValid() throws EncryptedDocumentException, IOException, InterruptedException {
        try {
            List<Map<String, String>> testdata = ExcelDataProvider.getTestData("ContactUsInvalidData");

            for (Map<String, String> e : testdata) {

                String name = String.valueOf(e.get("name"));
                String email = String.valueOf(e.get("email"));
                String phone = String.valueOf(e.get("phone"));
                String message = String.valueOf(e.get("message"));

                Contact.fillContactForm(name, email, phone, message);

                Thread.sleep(1000);

            }

        } catch (Exception e) {
            logger.error("Error filling the contact form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(TestBase.driver, "FormFillError");
            Assert.fail("Error filling the contact form: " + e.getMessage());
        }
    }

    @When("User submits the form")
    public void userSubmitsForm() {
        try {
            Contact.submitForm();
            Wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(expectedUrlSubstring)));

        } catch (Exception e) {
            logger.error("Error submitting the form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(TestBase.driver, "FormSubmitError");
            Assert.fail("Error submitting the form: " + e.getMessage());
        }
    }
    @When("User submits the form Invalid Data")
    public void userSubmitsFormInvalid() {
        try {
            Contact.submitForm();
            Assert.assertEquals("https://www.chilternoakfurniture.co.uk/pages/contact", TestBase.driver.getCurrentUrl());

        } catch (Exception e) {
            logger.error("Error submitting the form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(TestBase.driver, "FormSubmitError");
            Assert.fail("Error submitting the form: " + e.getMessage());
        }
    }

    @Then("User should see a confirmation message")
    public void userShouldSeeConfirmationMessage() {
        try {
            logger.info(Contact.isConfirmationMessageDisplayed());
            ScreenshotUtil.captureScreenshot(TestBase.driver, "FormSubmit Confirmation Message");

        } catch (Exception e) {
            logger.error("Error verifying confirmation message: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(TestBase.driver, "ConfirmationError");
            Assert.fail("Error verifying confirmation message: " + e.getMessage());
        }
    }
}
