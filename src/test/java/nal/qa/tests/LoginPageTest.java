package nal.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nal.qa.base.TestBase;
import nal.qa.pages.HomePage;
import nal.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	public LoginPageTest()
	{
		super();
	}
@BeforeMethod
public void Initialize()
{
	Initializer();
	lp=new LoginPage();
}

@AfterMethod
public void Teardown()
{
	driverNal.quit();
}

@Test(priority=1)
public  void ValidateTitle()
{   
	String title=lp.validateLoginPageTitle();
	Assert.assertEquals(title, "Rediffmail");	
}

@Test(priority=2)
public void LoginTest()
{
	hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
}
}
