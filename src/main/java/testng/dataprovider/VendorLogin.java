package testng.dataprovider;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.collections.ArrayIterator;

import testng.utility.TestUtil;

public class VendorLogin {
	
	WebDriver driver;
	
	@BeforeMethod()
	public void setup()
	{
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://devvendor.roksaan.com/");
	}
	
	@DataProvider()
	public void getdata() throws IOException
	{
		
		  TestUtil.getDataFromExcel();
	}
	
	@Test(dataProvider = "getdata")
	public void vendorlogin(String Emailid, String Password)
	{
		driver.findElement(By.xpath("//input[@placeholder='email address']")).sendKeys(Emailid);
		driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	}
	
	@AfterMethod()
	public void TearDown() {
		driver.quit();
	}
}
