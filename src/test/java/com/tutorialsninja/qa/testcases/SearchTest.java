package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObject.HomePageLocators;
import com.tutorialsninja.qa.pageObject.SearchPageLocators;

public class SearchTest extends Base{
	
	SearchPageLocators searchPageLocators;
	public WebDriver driver;
	HomePageLocators homePageLocators;
	
	public SearchTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homePageLocators= new HomePageLocators(driver);
	}
	
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifySearchWithValidProduct()
	{
		homePageLocators.enterProductNameIntoSearchBoxField(testProp.getProperty("validProduct"));
		SearchPageLocators searchPageLocators = homePageLocators.clickOnSearchButton();
		
		Assert.assertTrue(searchPageLocators.displayStatusOfHPProduct(), "Searched product is not available");
		
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() throws InterruptedException
	{
		Thread.sleep(3000);
		homePageLocators.enterProductNameIntoSearchBoxField(testProp.getProperty("invalidProduct"));
		SearchPageLocators searchPageLocators = homePageLocators.clickOnSearchButton();
	
		String actualSearchMessage= searchPageLocators.retrieveNoProductMessage();
		
			Assert.assertEquals(actualSearchMessage, "abcd", "NO product Search message is not displayed");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@Test(priority = 3, dependsOnMethods = {"verifySearchWithValidProduct", "verifySearchWithInvalidProduct"})
	public void verifySearchWithoutAnyProduct()
	{
		SearchPageLocators searchPageLocators = homePageLocators.clickOnSearchButton();
		
		String actualSearchMessage= searchPageLocators.retrieveNoProductMessage();
		Assert.assertEquals(actualSearchMessage, testProp.getProperty("noProductTextInSearchResult"), "NO product Search message is not displayed");
	}

}
