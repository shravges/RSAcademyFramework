package com.qa.RSAcademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.RSAcademy.base.BaseClass;

public class MentorshipPage extends BaseClass 
{
	@FindBy(xpath="//h1[contains(text(),'Mentorship')]")
	WebElement headerMentorship;
	
	@FindBy(xpath="//h1[contains(text(),'BRONZE')]")
	WebElement headerBronzeMbmship;
	
	@FindBy(xpath="//h1[contains(text(),'PLATINUM')]")
	WebElement headerPlatinumMbmship;
	
	public MentorshipPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkPageHeader()
	{
		return headerMentorship.isDisplayed();
	}
	
	public boolean checkBronzeHeader()
	{
		return headerBronzeMbmship.isDisplayed();
	}
	
	public boolean checkPlatinumHeader()
	{
		return headerPlatinumMbmship.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
}
