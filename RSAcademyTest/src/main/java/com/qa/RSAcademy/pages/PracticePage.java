package com.qa.RSAcademy.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.RSAcademy.base.BaseClass;
import com.qa.RSAcademy.util.TestUtil;

public class PracticePage extends BaseClass
{
	@FindBy(xpath="//h2[contains(text(),'Join now to Practice')]")
	WebElement headerJoinNow;
	
	@FindBy(id="name")
	WebElement txtbxName;
	
	@FindBy(id="email")
	WebElement txtbxEmail;
	
	@FindBy(xpath="(//button[contains(text(),'Submit')])[1]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//h2[contains(text(),'Enter code here')]")
	WebElement headerEnterCode;
	
	public PracticePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkPracticePageHeader()
	{
		return headerJoinNow.isDisplayed();
	}
	
	public void enterPracticeInfo(String name, String email)
	{
		txtbxName.sendKeys(name);
		txtbxEmail.sendKeys(email);
		btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
	}
	
	public boolean checkEnterCodeHeader()
	{
		return headerEnterCode.isDisplayed();
	}
	
}
