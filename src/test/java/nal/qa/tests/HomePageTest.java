package nal.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import nal.qa.base.TestBase;
import nal.qa.pages.HomePage;
import nal.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	HomePage hp;
          public HomePageTest()
			{
				super();
			}
@BeforeMethod
public void Initialize()
{
	Initializer();
	LoginPage lp=new LoginPage();
	hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
}
@AfterMethod
public void Teardown()
{
	driverNal.quit();
}
@Test
public void VerifyHomePageTitle()
{
	String title=hp.ValidateHomePageTitle();
	Assert.assertEquals(title, "Rediffmail");	
}
@Test
public void ClickOnProfileLabel()
{
	hp.ClickOnProfile();
}
}
