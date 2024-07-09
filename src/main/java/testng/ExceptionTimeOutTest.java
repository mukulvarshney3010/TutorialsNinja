package testng;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest extends GoogleTitleTest{
	
//	@Test(invocationTimeOut = 2)  //InvocationTimeOut is used to terminate the infinite loop.
//	public void InfiniteLoopTest() {
//		int i=1;
//		while(i==1)
//		{
//			System.out.println(i);
//		}
//	}
	
	@Test(priority = 10, expectedExceptions = NumberFormatException.class) //expectedExceptions is used to handle the exception without using try catch block
	public void test()										//whenever we know that their are exception.	
	{
		String s="100A";
	//	Integer.parseInt(s);
		System.out.println(s);
	}
	@Test(expectedExceptions = ArithmeticException.class)
	public void test1()
	{
		int i=9/0;
	}
}
