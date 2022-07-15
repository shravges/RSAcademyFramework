package com.qa.RSAcademy.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;
import com.qa.RSAcademy.util.TestUtil;
import com.qa.RSAcademy.util.WebEventListener;

public class BaseClass
{
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static String executionTmpstmp=null;
	public static String currentExecutionPath=null;
	public static String currentScreenshotPath=null;
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports extent = null;
			
	
	
	//base class constructor to get the property file loaded
	public BaseClass()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Shilps\\git\\RSAcademyFramework\\RSAcademyTest\\src\\main\\java\\com\\qa\\RSAcademy\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();	
		}
		catch(IOException e)
		{
		e.printStackTrace();	
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverlocation"));
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
		//settings for IE	
		}
		else
		{
			System.out.println("No browser name found in config file");
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	@BeforeSuite
	public void setPrerequisites()
	{
		String currentExecution = TestUtil.getCurrentDateTime();
		
		//create execution folder
		currentExecutionPath = TestUtil.outputFilePath+currentExecution;
		System.out.println("Current execution path =" +currentExecutionPath);
		File executionDetails = new File(currentExecutionPath);
		executionDetails.mkdirs();
		
		//create extent report under main folder
		htmlReporter = new ExtentHtmlReporter(currentExecutionPath+ "/" +"ExecutionSummary.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//create folder for screenshot
		currentScreenshotPath = currentExecutionPath+ "/" +"Screenshots";
		File screenshotDetails = new File(currentScreenshotPath);
		screenshotDetails.mkdirs();
		
	}
	
	
	@AfterSuite
	public void closure() throws IOException
	{
		extent.flush();
		File src = new File(currentExecutionPath+ "/" +"ExecutionSummary.html");
		File dest = new File("C:\\RSAcademyTest_Output\\ExecutionSummary.html");
		Files.copy(src,dest);
	}
	

}
