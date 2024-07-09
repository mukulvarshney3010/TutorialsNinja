package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* Sequence of executing the test cases.
 * @BeforeMethod
 * @Test-- 1
 * @AfterMethod
 * @BeforeMethod
 * @Test-- 2
 * @AfterMethod
 */
public class TestNGBasics {
    //Pre-conditions annotations--starting with @before
	@BeforeSuite //1
	public void setup()
	{
		System.out.println("setup system property for chrome");
	}
	@BeforeTest //2
	public void launchBrowser()
	{
		System.out.println("Launch the Chrome Browser");
	}
	@BeforeClass //3
	public void login()
	{
		System.out.println("Login in app");
	}
	
	
	
	@BeforeMethod //4
	public void enterURL()
	{
		System.out.println("Enter the URL");
	}
	
	//Test cases--starting with @Test
	@Test(priority = 1) //5
	public void googleTitleTest()
	{
		System.out.println("Google Title Test");
	}
	
	@Test(priority = 2)
	public void searchtext()
	{
		System.out.println("Searched");
	}
	
	//post condition annotations-- starting with @After
	@AfterMethod //6
	public void logout()
	{
		System.out.println("Logout from app");
	}
	@AfterClass  //7
	public void deleteCookies()
	{
		System.out.println("Delete all cookies");
	}
	@AfterTest //8
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
