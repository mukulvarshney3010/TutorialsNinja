package TestNG1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
WebDriver driver;
	
//	@BeforeMethod
//	public void setUp()
//	{
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.google.com");
//	}
	@Test(enabled = false, priority = 8)
	public void googleTitleTest()
	{											
		String title= driver.getTitle();		
		System.out.println(title);
		
	org.testng.Assert.assertEquals(title, "Google", "Title is not matched"); 
	}
	
	@Test(enabled = false, priority = 9)
	public void googleLogotest()
	{
		boolean b=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		
		org.testng.Assert.assertTrue(b);
	//	org.testng.Assert.assertEquals(b, true);
	}
//	@AfterMethod
//	public void close()
//	{
//		driver.quit();
//	}

}



