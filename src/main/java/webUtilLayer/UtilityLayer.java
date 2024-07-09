package webUtilLayer;

import java.awt.event.ActionEvent;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class UtilityLayer {
	
	WebDriver driver=null;
	

	public WebDriver launchBrowser(String browser,String url)
	
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			 driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			 driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			 driver= new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void click(WebElement element)
	{
		 
		try {
		
		element.click();
		}catch(ElementNotInteractableException e) {
			Actions action=new Actions(driver);
			action.click(element).perform();
		}catch(Exception e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("argument[0].click;",element);
		}
		
	}
	
	public void sendkeys(WebElement element)
	{
		 
		try {
		element.sendKeys("Manual Testing");
		}catch(ElementNotInteractableException e) {
			Actions action=new Actions(driver);
			action.sendKeys(element, "Automation");
		}catch(Exception e)
		{
			String text="testing";
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("argument[0].value='"+ text + "';", element);
		}
	}
	
	public void text(WebElement element)
	{
		
			String s=element.getText();
			System.out.println(s);
	}
	
	public void gettitle()
	{
		String expectedtile="Google";
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		if(actualtitle.equalsIgnoreCase(expectedtile))
		{
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed.");
		}
	}
	public void display(WebElement element)
	{	
		if(element.isDisplayed())
		{
			System.out.println("Logo displayed");
		}else
		{
			System.out.println("Logo not displayed");
		}
		
	}
	public void selected(WebElement element)
	{
		element.click();
		if(element.isSelected())
		{
			System.out.println("Checkbox is selected");
		}
		else
		{
			System.out.println("Checkbox is not selected");
		}
	}
	public void enabled(WebElement element)
	{
		if(element.isEnabled())
		{
			System.out.println("Button is clickable");
		}
		else {
			System.out.println("Button is not clickable");
		}
	}
}
