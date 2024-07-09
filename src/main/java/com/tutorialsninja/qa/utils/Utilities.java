package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	public static final int IMPLICIT_WAIT=30;
	
	public static String generateEmailWithTimeStamp()
	{
		Date date=new Date();
		String timestamp= date.toString().replace(" ", "_").replace(":", "_");
		return "mukul"+timestamp+"@yopmail.com";
	}
	
	public static Object [][] getTestDataFromExcel(String SheetName)
	{
		XSSFWorkbook workbook = null;
		FileInputStream fisExcel=null;
		XSSFSheet sheet=null;
		Object [][] data= null;
		
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\maven\\mavensample\\tutorialsninja.xlsx");
		try 
		{
		fisExcel= new FileInputStream(file);
		workbook= new XSSFWorkbook(fisExcel);//Create a object of workbook and declare globally so that we can use the methods of workbook.
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	 sheet = workbook.getSheet(SheetName);
		
		  int rows = sheet.getLastRowNum(); // Get the number of rows
          int cols = sheet.getRow(0).getLastCellNum(); // Get the number of columns

          data = new Object[rows][cols];

          for (int i = 1; i <= rows; i++) {
              XSSFRow row = sheet.getRow(i);
              for (int j = 0; j < cols; j++) {
                  XSSFCell cell = row.getCell(j);
                  data[i-1][j] = cell.toString(); // Store the cell value as a string
              }
          }
          return data;
	}
	
	public static String captureScreenshot(WebDriver driver,String testName)
	{
		File srcScreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationScreenPath= testName+".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(srcScreenshot, new File(destinationScreenPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenPath;
	}
	
}


