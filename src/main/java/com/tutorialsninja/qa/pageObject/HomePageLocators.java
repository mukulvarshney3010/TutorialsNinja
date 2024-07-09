package com.tutorialsninja.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocators {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton; 
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement validHPProduct;
	
	public HomePageLocators(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount()
	{
		myAccountDropDown.click();
	}
	
	public LoginPageLocators selectLoginOption()
	{
		loginOption.click();
		return new LoginPageLocators(driver);
	}
	
	public RegisterPageLocators selectRegisterOption()
	{
		registerOption.click();
		return new RegisterPageLocators(driver);
	}
	
	public void enterProductNameIntoSearchBoxField(String productText)
	{
		searchBoxField.sendKeys(productText);
	}
	
	public SearchPageLocators clickOnSearchButton()
	{
		searchButton.click();
		return new SearchPageLocators(driver);
	}

	
	 

}