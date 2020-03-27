package nal.qa.tests;

import java.io.IOException;
//import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import nal.qa.base.TestBase;
import nal.qa.pages.LandingPage;
import nal.qa.pages.LoginPage;
import nal.qa.pages.SignupPage;
import nal.qa.util.TestUtil;

public class SignupPageTest extends TestBase {
    SignupPage sp;
	LandingPage land;
	public SignupPageTest(){
		super();
	}
@BeforeMethod
public void Initialize()
{
	Initializer();
	LoginPage lp=new LoginPage();
	sp=lp.CreateNewAccount();
}
@AfterMethod()
public void Teardown()
{
	driverNal.quit();
}
@Test(dataProvider="SignupData")
public void CreateRediffAccount(String fullname, String email, String password, String confirmpassword, String altmail, String mobileno, String dayofbirth,  String monthofbirth, String yearofbirth, String country, String city) throws IOException
{
	land=sp.CreateAccount(fullname, email, password, confirmpassword, altmail, mobileno, dayofbirth, monthofbirth, yearofbirth, country, city);
	/*TestUtil tu=new TestUtil();
	ArrayList<String> data=	tu.getdata("Signup");
	land=sp.CreateAccount(data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10), data.get(11));
*/
	
}
@DataProvider
public Object[][] SignupData()
{
	Object[][] data=TestUtil.getTestData("Signup");
	return data;
}
}