package nal.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import nal.qa.util.TestUtil;

public class TestBase {
public static WebDriver driverNal;
public static Properties prop;

public TestBase() 
{
	FileInputStream fis;
	try {
		fis = new FileInputStream(System.getProperty("C:\\Users\\user\\Downloads\\eclipse-oxygen\\NalE2E-25-03-2020\\src\\main\\java\\nal\\qa\\config\\config.properties"));
		prop=new Properties();
		prop.load(fis);
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
     	} catch (IOException e) {
		e.printStackTrace();
     	}

}

public static void Initializer()
{
	if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driverNal=new FirefoxDriver();
	}
	else
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32(2)\\chromedriver.exe");
		driverNal=new ChromeDriver();
	}
	driverNal.get(prop.getProperty("url"));
	driverNal.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driverNal.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driverNal.manage().window().maximize();
	driverNal.manage().deleteAllCookies();	
}
}
