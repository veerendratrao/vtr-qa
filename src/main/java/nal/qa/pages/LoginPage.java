package nal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nal.qa.base.TestBase;

public class LoginPage extends TestBase{
	public LoginPage()
	{
		PageFactory.initElements(driverNal, this);
	}
	
	@FindBy(id="login1")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(className="signinbtn")
	WebElement signin;
	@FindBy(linkText="Create a new account")
	WebElement signup;
	
	public WebElement UserName()
	{
		return username;
	}
	
	public WebElement Password()
	{
		return password;
	}
	
	public WebElement Signin()
	{
		return signin;
	}
	
	public WebElement Signup()
	{
		return signup;
	}
	//actions
	public String validateLoginPageTitle()
	{
		return driverNal.getTitle();
	}
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		signin.click();
		return new HomePage();
	}
	public SignupPage CreateNewAccount()
	{
		signup.click();
		return new SignupPage();
	}

}
