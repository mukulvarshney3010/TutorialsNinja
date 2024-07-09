package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest extends ExceptionTimeOutTest{
	
	WebDriver driver;
	
	@Test(priority = 11)
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
