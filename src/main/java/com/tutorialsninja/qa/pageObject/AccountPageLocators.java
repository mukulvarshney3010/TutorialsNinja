package com.tutorialsninja.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPageLocators {
	
	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	public AccountPageLocators(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDisplayStatusOfEditYourAccountInformationOption()
	{
		boolean displaystatus = editYourAccountInformationOption.isDisplayed();
		return displaystatus;
	}
}
