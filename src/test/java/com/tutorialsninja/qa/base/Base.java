package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties testProp;
	
	public Base() {
		prop= new Properties();
		File file= new File("C:\\Users\\admin\\eclipse-workspace\\maven\\mavensample\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
	
		testProp= new Properties();
		File testFile= new File("C:\\Users\\admin\\eclipse-workspace\\maven\\mavensample\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		
		try {
		FileInputStream testFIS= new FileInputStream(testFile);
		testProp.load(testFIS);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		FileInputStream fis= new FileInputStream(file);
		prop.load(fis);
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
