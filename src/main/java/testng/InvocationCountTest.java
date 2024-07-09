package testng;

import org.testng.annotations.Test;



public class InvocationCountTest {
	
	@Test(enabled=false, invocationCount = 5)  //InvocationCount method is particularly used to execute same test case multiple times.
	public void sum()
	{
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println("Sum of a and b is--" + c);
	}

}
