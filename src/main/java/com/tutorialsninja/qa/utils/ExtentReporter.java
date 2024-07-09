package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport= new ExtentReports();
		File newReportFile= new File("C:\\Users\\admin\\eclipse-workspace\\maven\\mavensample\\mavensample\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(newReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results Report");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties prop= new Properties();
		File configFileProp= new File("C:\\Users\\admin\\eclipse-workspace\\maven\\mavensample\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
				FileInputStream configFis= new FileInputStream(configFileProp);
				prop.load(configFis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application url", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
		extentReport.setSystemInfo("Email Adress", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", prop.getProperty("validPassword"));
		
		
		// System.getProperties().list(System.out);  This is used to get the properties of System.
		
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
		
		return extentReport;
	}

}
