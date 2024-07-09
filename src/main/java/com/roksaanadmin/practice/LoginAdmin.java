package com.roksaanadmin.practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class LoginAdmin {
	
	WebDriver driver=null;
	
	public void launchbrowser(String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://devadmin.roksaan.com/");

	}
	
	
	public void validLoginCreds(String email, String password)
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		
	}
	
	
	public void invalidLoginCreds(String email, String password)
	{
		 driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		 
		 driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(password);
		 
		 driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		
	}
	
	public void takescreenshot(String Screenshots) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File fs=ts.getScreenshotAs(OutputType.FILE);
		File f1=new File(Screenshots+".png");
		Files.copy(fs, f1);
	}
	
	public void clickOrders() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[text()='Orders']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[text()=' #RK004312 ']//following-sibling::td//img[@height=\"15px\"]")).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='Mark as Fulfilled']")).click();
		
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("mjdjcn98983");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Mark as Fulfilled']")).click();
		driver.findElement(By.xpath("//button[text()='Fulfill']")).click();
	}
	

}
	
	


