package com.tutorialsninja.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPageLocators {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccesPageHeading;

	public AccountSuccessPageLocators(WebDriver driver)
	{ 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveAccountSuccessPageHeading()
	{
		String accountSuccesPageHeadingText= accountSuccesPageHeading.getText();
		return accountSuccesPageHeadingText;
	}
}
