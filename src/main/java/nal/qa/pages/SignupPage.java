package nal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import nal.qa.base.TestBase;

public class SignupPage extends TestBase {

	public SignupPage()
	{
		PageFactory.initElements(driverNal, this);
	}

	@FindBy(xpath="//input[contains(@name,'name')]")
    @CacheLookup
	WebElement fullname;
	@FindBy(xpath="//input[contains(@name,'login')]")
	WebElement emailid;
	@FindBy(xpath="//input[contains(@name,'passwd')]")
	WebElement password;
	@FindBy(xpath="//input[contains(@name,'confirm_passwd')]")
	WebElement confirmpassword;
	@FindBy(xpath="//input[contains(@name,'altemail')]")
	WebElement altmail;
	@FindBy(id="mobno")
	WebElement mobileno;
	@FindBy(xpath="//select[contains(@name,'DOB_Day')]")
	WebElement dayofbirth;
	@FindBy(xpath="//select[contains(@name,'DOB_Month')]")
	WebElement monthofbirth;
	@FindBy(xpath="//select[contains(@name,'DOB_Year')]")
	WebElement yearofbirth;
	@FindBy(xpath="//input[@value='m']")
	WebElement gender;
	@FindBy(id="country")
	WebElement country;
	@FindBy(xpath="//select[contains(@name,'city')]")
	WebElement city;
	@FindBy(id="Register")
	WebElement submit;

	public WebElement DateOfBirth()
	{
		return dayofbirth;
	}
	
	public WebElement MonthOfBirth()
	{
		return monthofbirth;
	}
	
	public WebElement YearOfBirth()
	{
		return yearofbirth;
	}
	
	public WebElement Country()
	{
		return country;
	}
	
	public WebElement City()
	{
		return city;
	}
	
	public LandingPage CreateAccount(String fn, String eid, String pass, String cpass, String alteid, String mob, String dob, String mtob, String yob, String ctr, String cty)
	{
		fullname.sendKeys(fn);
		emailid.sendKeys(eid);
		password.sendKeys(pass);
		confirmpassword.sendKeys(cpass);
		altmail.sendKeys(alteid);
		mobileno.sendKeys(mob);
		Select day=new Select(DateOfBirth());
		day.selectByValue(dob);
		
		Select month=new Select(MonthOfBirth());
		month.selectByValue(dob);
	
		Select year=new Select(YearOfBirth());
		year.selectByValue(yob);
		
		gender.click();
		
		Select scountry=new Select(Country());
		scountry.selectByValue(ctr);
		
		Select scity=new Select(City());
		scity.selectByValue(cty);

		 submit.click();
		 
		 return new LandingPage();
	}
	
}
