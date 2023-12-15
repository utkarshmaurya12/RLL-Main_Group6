package com.ecommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactUsPage {
    @FindBy(id = "contactFormName")
    WebElement contactFormName;

    @FindBy(id = "contactFormEmail")
    WebElement contactFormEmail;

    @FindBy(id = "contactFormTelephone")
    WebElement contactFormPhone;

    @FindBy(id = "contactFormMessage")
    WebElement contactFormMessage;

    @FindBy(id = "contactFormSubmit")
    WebElement contactFormSubmit;

    @FindBy(xpath = "//*[text() = 'Contact us']")
    public WebElement contact;

    @FindBy(css = ".notification > p")
	public WebElement confirmationMessage;

    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillContactForm(String name, String email, String phone, String message) {
        Assert.assertNotNull(contactFormName);
        Assert.assertNotNull(contactFormEmail);
        Assert.assertNotNull(contactFormPhone);
        Assert.assertNotNull(contactFormMessage);

        Assert.assertTrue(contactFormName.isEnabled() && contactFormName.isDisplayed());
        Assert.assertTrue(contactFormEmail.isEnabled() && contactFormEmail.isDisplayed());
        Assert.assertTrue(contactFormPhone.isEnabled() && contactFormPhone.isDisplayed());
        Assert.assertTrue(contactFormMessage.isEnabled() && contactFormMessage.isDisplayed());

        contactFormName.sendKeys(name);
        contactFormEmail.sendKeys(email);
        contactFormPhone.sendKeys(phone);
        contactFormMessage.sendKeys(message);
    }

    public void submitForm() {
        contactFormSubmit.click();
    }

    public boolean isConfirmationMessageDisplayed() {
        try {
            return confirmationMessage.isDisplayed();
        } catch (Exception e) {
            Assert.fail("Timeout waiting for confirmation message to be visible");
            return false;
        }
    }
}
