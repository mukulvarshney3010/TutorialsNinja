package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testng.GoogleTitleTest;

public class ParameterTest{
	
	WebDriver driver;
	
	@Test(enabled = false, priority = 10)
	@Parameters({"url", "emailid", "password"})
	public void RoksaanAdminLogin(String url, String emailid, String password)
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	}


}
