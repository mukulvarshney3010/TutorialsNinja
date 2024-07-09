package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest extends TestNGFeatures{
	
	WebDriver driver;
	
	//1 //4 //7
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
	}
	
 	//2				(Test cases are executed randomly but if we set the priority keyword and it executes according the priority sequence)
	//				(groups keyword--eg. Let suppose there are 10 test cases of Title test case then we make a group of title testcase so all test
	//				cases are shown in title test case group in index.html(Refresh the project>>Copy the link of index.html>>paste it on browser))
	@Test(priority = 4,groups = "Title")
	public void googleTitleTest()
	{
		String title= driver.getTitle();
		System.out.println(title);
	}
	//8
	@Test(priority = 5,groups = "Logo")
	public void googleLogotest()
	{
		boolean b=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
	}
	
	//5
	@Test(priority = 6,groups = "Link")
	public void mailpartiallink()
	{
		boolean b= driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	@Test(priority = 7,groups = "Test")
	public void test1()
	{
		System.out.println("Test1");
	}
	
	//3 //6 //9
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
