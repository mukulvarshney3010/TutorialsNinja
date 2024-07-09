package Practicetestng;

import org.testng.annotations.Test;

public class B extends A{
	
	@Test(priority = 1)
	public void Homepage()
	{
		System.out.println("Homepage");
	}
	@Test(priority = 3)
	public void logout()
	{
		System.out.println("Logout successful");
	}

}
