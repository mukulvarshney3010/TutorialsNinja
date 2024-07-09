package com.roksaanadmin.practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class MainClass extends LoginAdmin{
	
	@Test
	public void execution() throws IOException, InterruptedException {
		
		launchbrowser("chrome");
		validLoginCreds("admin@yopmail.com", "Qwerty@123");
		clickOrders();
		
		
		launchbrowser("chrome");
		invalidLoginCreds("adm@yopmail.com", "Qwerty@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		takescreenshot("invalidemail");
		
		
		launchbrowser("chrome");
		invalidLoginCreds("  ", "");
		takescreenshot("emptyfields");
		
		
		launchbrowser("chrome");
		invalidLoginCreds("admin@yopmail.com", "qwerty@123");
		takescreenshot("invalidpassword");
		
		
		
	}

	}

