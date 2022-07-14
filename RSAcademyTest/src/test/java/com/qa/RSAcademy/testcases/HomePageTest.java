package com.qa.RSAcademy.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.RSAcademy.base.BaseClass;
import com.qa.RSAcademy.pages.HomePage;
import com.qa.RSAcademy.pages.MentorshipPage;
import com.qa.RSAcademy.util.TestUtil;

public class HomePageTest extends BaseClass
{
	HomePage hp;
	MentorshipPage mp;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		hp = new HomePage();
	}
	
	@Test(priority=1)
	public void testHomePageTitle() throws IOException
	{
		ExtentTest titleTest = extent.createTest("testHomePageTitle", "this test case checks home page title");
		
		String actualPageTitle = hp.pageTitle();
		if(actualPageTitle.equalsIgnoreCase("Rahul Shetty Academy"))
		{
			titleTest.pass("Title displayed successfully on home page");
		}
		else
		{
			titleTest.fail("Incorrect title displayed on home page", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot(driver)).build());
		}
		//Assert.assertEquals(actualPageTitle, "Rahul Shetty Academy", "Issue with page title");
		
	}
	
	@Test(priority=2)
	public void testCourseDetails() throws IOException
	{
		ExtentTest courseDetailsTest = extent.createTest("testCourseDetails", "this test case checks course details on home page");
		boolean courseShown = hp.courseDetails();
		//Assert.assertEquals(courseShown, true);
		
		if(courseShown)
		{
		courseDetailsTest.pass("Course details shown on home page");
		}
		else
		{
			courseDetailsTest.fail("Course details not shown on home page",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot(driver)).build());
		}
		
	}
	
//	@Test(priority=3)
//	public void testMentorshipLink()
//	{
//		mp = hp.checkMentorshopLink();
//	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}
