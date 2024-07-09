package webUtilLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainClass extends UtilityLayer{

	public static void main(String[] args) {
		
	MainClass m = new  MainClass();
	WebDriver driver= m.launchBrowser("firefox", "https://www.google.com/");
	
	m.click(driver.findElement(By.xpath("//a[text()='Gmail']")));
	driver.navigate().back();
	
	m.sendkeys(driver.findElement(By.xpath("//textarea[@class='gLFyf']")));
	driver.quit();
	
	WebDriver driver1=m.launchBrowser("firefox", "http://devadmin.roksaan.com/");
	driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	m.text(driver1.findElement(By.xpath("//button[text()='LOGIN']")));
//	m.gettitle();
//	driver.quit();

	
	WebDriver driver2=m.launchBrowser("chrome", "https://www.google.com/");
	driver2.manage().window().maximize();
	m.gettitle();
	m.display(driver2.findElement(By.xpath("//div[@class='k1zIA rSk4se']")));
	driver.quit();
	
	m.selected(driver1.findElement(By.xpath("//input[@class='form-check-input checkbox']")));
	
	m.enabled(driver1.findElement(By.xpath("//button[text()='LOGIN']")));
	
	
	}

}
