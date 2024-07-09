package TestNG1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
WebDriver driver;
	
	
//	@BeforeMethod
//	public void setUp()
//	{
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.google.com");
//	}
	
	@Test(enabled = false, priority = 4)
	public void googleTitleTest()
	{
		String title= driver.getTitle();
		System.out.println(title);
	}
	
	@Test(enabled = false, priority = 5)
	public void googleLogotest()
	{
		boolean b=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
	}
	
	
	@Test(enabled = false, priority = 6)
	public void mailpartiallink()
	{
		boolean b= driver.findElement(By.linkText("Mail")).isDisplayed();
	}
	
	@Test(priority = 7)
	public void test1()
	{
		System.out.println("Test1");
	}
	
	
//	@AfterMethod
//	public void close()
//	{
//		driver.quit();
//	}
}


