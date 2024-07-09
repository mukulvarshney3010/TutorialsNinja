package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObject.AccountPageLocators;
import com.tutorialsninja.qa.pageObject.HomePageLocators;
import com.tutorialsninja.qa.pageObject.LoginPageLocators;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{
	
	LoginPageLocators loginPageLocators;
	public WebDriver driver;
	
	public LoginTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
	//	loadPropertiesFile();(we directly call the method from the base class or can create constructor and use the super() to call properties method)
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
		HomePageLocators homePageLocators= new HomePageLocators(driver);
		homePageLocators.clickOnMyAccount();
		loginPageLocators = homePageLocators.selectLoginOption();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@Test(priority = 1, dataProvider = "supplyTestData")
	public void verifyLoginWithValidCredentials(String Email, String Password)
	{
		loginPageLocators.enterEmailAddress(Email);
		loginPageLocators.enterPassword(Password);
		AccountPageLocators accountPageLocators = loginPageLocators.clickOnLoginButton();
		
		org.testng.Assert.assertTrue(accountPageLocators.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your account information option is not displayed");
	}
	
	@DataProvider
	public Object [][] supplyTestData()
	{
		Object [][] data= Utilities.getTestDataFromExcel("Sheet1");
		return data;		
	}
	
	@Test(priority = 2)
	public void verifyLoginwithInvalidCredentials()
	{
		loginPageLocators.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPageLocators.enterPassword(testProp.getProperty("invalidPassword"));
		loginPageLocators.clickOnLoginButton();
		
		String actualWarningMessage= loginPageLocators.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
		org.testng.Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
	}
	@Test(priority = 3)
	public void verifyLoginWithInValidEmailAndValidPassword()
	{
		loginPageLocators.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPageLocators.enterPassword(prop.getProperty("validPassword"));
		loginPageLocators.clickOnLoginButton();
		
		String actualWarningMessage= loginPageLocators.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
		org.testng.Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
	}
	
	@Test(priority = 4)
	public void verifyLoginWithValidEmailandInvalidPassword()
	{
		loginPageLocators.enterEmailAddress(prop.getProperty("validEmail"));
		loginPageLocators.enterPassword(testProp.getProperty("invalidPassword"));
		loginPageLocators.clickOnLoginButton();
		
		String actualWarningMessage= loginPageLocators.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
		org.testng.Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
	}
	
	@Test(priority = 5)
	public void verifyLoginWithoutEmailandPassword()
	{
		loginPageLocators.clickOnLoginButton();
	
		String actualWarningMessage= loginPageLocators.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
		org.testng.Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning Message is not displayed");
		
	}
}
//1. when any test case is fail then driver is not automatically close. For this we have to use method in @AfterMethod and remove driver.quit from
//   all the test cases.
//2. We have create a static method in Utilities layer class of Utils package to call directly by class name wherever we have to use it.(Utilities.generateEmailWithTimeStamp())