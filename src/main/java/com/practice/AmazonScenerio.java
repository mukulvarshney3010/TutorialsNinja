package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AmazonScenerio {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=674842289437&hvpos=&hvnetw=g&hvrand=17607221583556019648&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302611&hvtargid=kwd-10573980&hydadcr=14453_2316415&gad_source=1");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		driver.findElement(By.xpath("//button[@id='a-autoid-1-announce']")).click();
		//Thread.sleep(2000);
		
		String actualText="Item Added";
		
		String expectedText= driver.findElement(By.xpath("//strong[text()='Item Added']")).getText();
		
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Pass");
		

		
//		Actions actions= new Actions(driver);
//		WebElement element= driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']"));
//		actions.moveToElement(element).click().perform();
//		String expectedText= driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
//		
//		
//		String actualText = "Apple iPhone 15 (128 GB) - Black";
//		Assert.assertEquals(actualText, expectedText);
//		
//		System.out.println("Pass");
		

		driver.quit();
		
	}

}
