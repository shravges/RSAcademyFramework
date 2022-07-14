package com.qa.RSAcademy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.RSAcademy.base.BaseClass;

public class TestUtil extends BaseClass
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String inputDataFile = "C:\\MyFrameworkDesignPractice\\RSAcademyTest\\src\\main\\java\\com\\qa\\RSAcademy\\testdata\\RSAcademy_TestData.xlsx";
	public static String outputFilePath = "C:\\RSAcademyTest_Output\\";
	
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(inputDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}
	
	public static String captureScreenshot(WebDriver driver)
	{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = currentScreenshotPath + "/TestExecution_" +getCurrentDateTime()+".png";
			try
			{
				FileHandler.copy(src, new File(screenshotPath));
				System.out.println("Screenshot captured successfully");
			}
			catch(IOException e)
			{
				System.out.println("Unable to capture screenshot" +e.getMessage());
			}
			return screenshotPath;
		
	}
	
	
	
}
