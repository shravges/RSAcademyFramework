package com.qa.RSAcademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.RSAcademy.base.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement btnLogin;
	
	@FindBy(id="email")
	WebElement txtbxEmail;
	
	@FindBy(id="password")
	WebElement txtbxPassword;
	
	@FindBy(name="commit")
	WebElement btnConfirmLogin;
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement coursesHeader;
	
	@FindBy(xpath="(//a[contains(text(),'Mentorship')])[1]")
	WebElement lnkMentorship;
	
	@FindBy(xpath="(//a[contains(text(),'Practice')])[1]")
	WebElement lnkPractice;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean courseDetails()
	{
		return coursesHeader.isDisplayed();
	}
	
	public MentorshipPage checkMentorshopLink()
	{
		try
		{
			lnkMentorship.click();
		}
		catch(Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		return new MentorshipPage();
	}	
	
	public PracticePage checkPracticeLink()
	{
		try
		{
		lnkPractice.click();
		}
		catch(Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		return new PracticePage();
	}
	
	
	
	
	
	

}




