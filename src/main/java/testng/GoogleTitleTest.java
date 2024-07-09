package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class GoogleTitleTest extends GoogleTest{
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
	}
	@Test(priority = 8)
	public void googleTitleTest()
	{											//Assertion is used to validate the test case where it compares actual and expected result.
		String title= driver.getTitle();		//Here actual result=title and expected result=Google1(the text which is in string.)
		System.out.println(title);
		
	org.testng.Assert.assertEquals(title, "Google", "Title is not matched");  //when actual is not match with expected than message shows.
	}
	
	@Test(priority = 9)
	public void googleLogotest()
	{
		boolean b=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		
		org.testng.Assert.assertTrue(b);
	//	org.testng.Assert.assertEquals(b, true);
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
