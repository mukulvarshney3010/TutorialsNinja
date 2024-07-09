package testng;

import org.testng.annotations.Test;

public class TestNGFeatures extends TestNGBasics {
	
	@Test(priority = 3)									//dependsOnMethods depends on the other test case like HomePageTest test case is depends on loginTest
	public void loginTest()					//test case so if loginTest fails then all other test cases are skipped. As i have take int i=9/0 so it	
	{										//fails and gives Arithmetic Exception so other three cases are skipped because it depends on loginTest.	
		System.out.println("Login test");
		int i=9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void HomePageTest()
	{
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void SearchPageTest()
	{
		System.out.println("Search Page Test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void RegistrationTest()
	{
		System.out.println("Registration page test");
	}

}
