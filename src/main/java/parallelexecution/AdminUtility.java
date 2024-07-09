package parallelexecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminUtility {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) {
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
	
	}
		driver.get("http://devadmin.roksaan.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}
	
	@Test()
	public void username()
	{
		
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://devadmin.roksaan.com/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	//	driver.manage().window().maximize();
		WebElement element= driver.findElement(By.xpath("//input[@type='email']"));
		element.sendKeys("afadasda@dad");

		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Qwerty@123");
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	}
	@Test()
	public void password()
	{
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://devadmin.roksaan.com/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element= driver.findElement(By.xpath("//input[@type='email']"));
		element.sendKeys("afadasda@dad");
	
	//	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Qwerty@123");
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	}
//	@Test()
//	public void click() {
//	 WebElement element= driver.findElement(By.xpath("//button[text()='LOGIN']"));
//	{
//		element.click();
//	}}
	
//	@AfterMethod
//	public void close()
//	{
//		driver.quit();
//	}

}
