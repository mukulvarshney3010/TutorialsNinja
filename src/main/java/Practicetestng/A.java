package Practicetestng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class A {
	
	@BeforeSuite
	public void setup()
	{
		System.out.println("setup confirmed.");
	}
//	@BeforeTest
//	public void launchbrowser()
//	{
//		System.out.println("launched");
//	}
	
	@BeforeMethod
	public void enterURL()
	{
		System.out.println("URL entered");
	}
	@Test(priority = 2)
	public void login()
	{
		System.out.println("Logged in successful");
	}
//	@Test()
//	public void Homepage()
//	{
//		System.out.println("Homepage");
//	}
//	@Test
//	public void logout()
//	{
//		System.out.println("Logout successful");
//	}
	
	@AfterMethod
	public void close()
	{
		System.out.println("close the browser");
	}
	
	@AfterSuite
	public void complete()
	{
		System.out.println("completed");
	}

}
