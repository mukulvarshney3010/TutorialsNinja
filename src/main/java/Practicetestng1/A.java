package Practicetestng1;

import org.testng.annotations.Test;

import Practicetestng.B;

public class A extends B{

	@Test(priority = 4)
	public void test1()
	{
		System.out.println("test 1");
	}
}
