package com.tutorialsninja.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageLocators {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement validHPProduct;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product ')]")
	private WebElement noProductMessage;
	
	public SearchPageLocators(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfHPProduct()
	{
		boolean displayStatus= validHPProduct.isDisplayed();
		return displayStatus;
	}
	
	public String retrieveNoProductMessage()
	{
		String noProductMessageText=noProductMessage.getText();
		return noProductMessageText;
	}

}
