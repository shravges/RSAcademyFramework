package com.qa.RSAcademy.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.RSAcademy.base.BaseClass;
import com.qa.RSAcademy.pages.HomePage;
import com.qa.RSAcademy.pages.PracticePage;
import com.qa.RSAcademy.util.TestUtil;

public class PracticePageTest extends BaseClass 
{
	HomePage hp;
	PracticePage pp;
	
	public PracticePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
	initialization();
	hp = new HomePage();
	pp = hp.checkPracticeLink();
	}
	
	@DataProvider
	public Object[][] getRSAcademyTestData()
	{
		Object data[][] = TestUtil.getTestData("Practice");
		return data;
	}
	
	@Test(priority=1, dataProvider="getRSAcademyTestData")
	public void TestPracticeDetails(String name, String email)
	{
		boolean pageReached = pp.checkPracticePageHeader();
		if(pageReached)
		{
			System.out.println("Landed on Practice page successfully");
			//pp.enterPracticeInfo("shilpa", "abc@gmail.com");
			pp.enterPracticeInfo(name, email);
			System.out.println("Data entered successfully");
		}
		
//		boolean enterCodePageReached = pp.checkEnterCodeHeader();
//		if(enterCodePageReached)
//		{
//			System.out.println("Landed on 2nd Practice page successfully");
//		}
//		else
//		{
//			System.out.println("Not Landed on 2nd Practice page");
//		}
		
		//pp.enterPracticeInfo("shilpa", "shilpa@gmail.com");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
