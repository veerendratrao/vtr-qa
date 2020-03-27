package nal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nal.qa.base.TestBase;

public class HomePage extends TestBase{
	public HomePage()
	{
		PageFactory.initElements(driverNal, this);
	}
	@FindBy(linkText="veerendra T rao")
	WebElement profile;
	
	public void ClickOnProfile()
	{
		profile.click();
	}
	
	public String ValidateHomePageTitle()
	{
		return driverNal.getTitle();
	}
	
}
