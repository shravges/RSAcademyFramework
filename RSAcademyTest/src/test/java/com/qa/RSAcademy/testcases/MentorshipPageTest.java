package com.qa.RSAcademy.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.RSAcademy.base.BaseClass;
import com.qa.RSAcademy.pages.HomePage;
import com.qa.RSAcademy.pages.MentorshipPage;

public class MentorshipPageTest extends BaseClass
{
	HomePage hp;
	MentorshipPage mp;
	
	public MentorshipPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		hp = new HomePage();
		mp = hp.checkMentorshopLink();
	}
	
	@Test
	public void TestMentorshipHeader()
	{
		Assert.assertEquals(mp.checkPageHeader(), true);
	}
	
	@Test
	public void TestBrozeMbmshipHeader()
	{
		Assert.assertEquals(mp.checkBronzeHeader(), true);
	}
	
	@Test
	public void TestPlatinumHeader()
	{
		Assert.assertEquals(mp.checkPlatinumHeader(), true);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
