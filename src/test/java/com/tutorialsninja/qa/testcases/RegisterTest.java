package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObject.AccountSuccessPageLocators;
import com.tutorialsninja.qa.pageObject.HomePageLocators;
import com.tutorialsninja.qa.pageObject.RegisterPageLocators;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base{
	
	RegisterPageLocators registerPageLocators;
	AccountSuccessPageLocators accountSuccessPageLocators;
	public WebDriver driver;
	
	public RegisterTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePageLocators homePageLocators= new HomePageLocators(driver);
		homePageLocators.clickOnMyAccount();
		registerPageLocators = homePageLocators.selectRegisterOption();
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields()
	{
		registerPageLocators.enterFirstName(testProp.getProperty("firstName"));
		registerPageLocators.enterLastName(testProp.getProperty("lastName"));
		registerPageLocators.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPageLocators.enterTelephone(testProp.getProperty("telephoneNumber"));
		registerPageLocators.enterPassword(prop.getProperty("validPassword"));
		registerPageLocators.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPageLocators.clickOnPrivacyPolicy();
		accountSuccessPageLocators = registerPageLocators.clickOnContinueButton();
		
		String actualSuccessHeading= accountSuccessPageLocators.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, testProp.getProperty("accountCreatedSuccessMessage"), "Account Success page is not displayed");

	}
	
	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields()
	{
		registerPageLocators.enterFirstName(testProp.getProperty("firstName"));
		registerPageLocators.enterLastName(testProp.getProperty("lastName"));
		registerPageLocators.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPageLocators.enterTelephone(testProp.getProperty("telephoneNumber"));
		registerPageLocators.enterPassword(prop.getProperty("validPassword"));
		registerPageLocators.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPageLocators.selectNewsLetterOption();
		registerPageLocators.clickOnPrivacyPolicy();
		accountSuccessPageLocators = registerPageLocators.clickOnContinueButton();
		
		String actualSuccessHeading= accountSuccessPageLocators.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, testProp.getProperty("accountCreatedSuccessMessage"), "Account Success page is not displayed");
	
	}
	
	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress()
	{	
		registerPageLocators.enterFirstName(testProp.getProperty("firstName"));
		registerPageLocators.enterLastName(testProp.getProperty("lastName"));
		registerPageLocators.enterEmail(prop.getProperty("validEmail"));
		registerPageLocators.enterTelephone(testProp.getProperty("telephoneNumber"));
		registerPageLocators.enterPassword(prop.getProperty("validPassword"));
		registerPageLocators.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPageLocators.selectNewsLetterOption();
		registerPageLocators.clickOnPrivacyPolicy();
		registerPageLocators.clickOnContinueButton();
		
		String actualWarningMessage= registerPageLocators.retrieveDuplicateEmailAddressWarning();
		Assert.assertTrue(actualWarningMessage.contains(testProp.getProperty("duplicateWarningMessage")),"existing email warning message is not correct");
	
	}
	
	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingDetails()
	{
		registerPageLocators.clickOnContinueButton();
		
		String actualPrivacyPolicyWarning= registerPageLocators.retrievePrivacyPolicyWarning();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(testProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning Message is not displayed");
		
		String actualFirstNameWarning= registerPageLocators.retrieveFirstNameWarning();
		Assert.assertTrue(actualFirstNameWarning.contains(testProp.getProperty("firstNameWarning")), "First name warning message is not displayed");
		
		String actualLastNameWarning= registerPageLocators.retrieveLastNameWarning();
		Assert.assertTrue(actualLastNameWarning.contains(testProp.getProperty("lastNameWarning")), "Last name warning message is not displayed");
		
		String actualEmailWarning= registerPageLocators.retrieveEmailWarning();
		Assert.assertTrue(actualEmailWarning.contains(testProp.getProperty("emailWarning")), "Email warning message is not displayed");
		
		String actualTelephoneWarning= registerPageLocators.retrieveTelephoneWarning();
		Assert.assertTrue(actualTelephoneWarning.contains(testProp.getProperty("telephoneWarning")), "Telephone warning message is not displayed");
		
		String actualPasswordWarning= registerPageLocators.retrievePasswordWarning();
		Assert.assertTrue(actualPasswordWarning.contains(testProp.getProperty("passwordWarning")), "Password warning message is not displayed");
	}
}
