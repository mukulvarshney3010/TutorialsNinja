package TestNG1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	WebDriver driver;
	@BeforeSuite
	public void setup()
	{
		System.out.println("setup system property for chrome");
	}
//	public void setUp()
//	{
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.google.com");
//	}
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("Launch the Chrome Browser");
	}
	@BeforeClass
	public void login()
	{
		System.out.println("Login in app");
	}
	
	@BeforeMethod
	public void enterURL()
	{
		System.out.println("Enter the URL");
	}
	
	
//	@Test()
//	public void googleTitleTest()
//	{
//		System.out.println("Google Title Test");
//	}
//	
//	@Test()
//	public void searchtext()
//	{
//		System.out.println("Searched");
//	}
	
	@Test()
	public void MethodA()
	{
		System.out.println("Method A");
	}
//	
//	@Test()
//	public void MethodB()
//	{
//		System.out.println("Method B");
//	}
	

	@AfterMethod
	public void logout()
	{
		System.out.println("Logout from app");
	}
	@AfterClass  
	public void deleteCookies()
	{
		System.out.println("Delete all cookies");
	}
	@AfterTest 
	public void CloseBrowser()
	{
		System.out.println("Close the Browser");
	}
//	@AfterSuite
//	public void generateTestReport()
//	{
//		System.out.println("Generate test Report");
//	}
}


