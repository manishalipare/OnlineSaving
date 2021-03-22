package com.skillrary.skillkart.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.skillrary.skillkart.generics.AutoConstants;
import com.skillrary.skillkart.generics.Utilities;
import com.skillrary.skillkart.generics.WebActionsUtil;
import com.skillrary.skillkart.generics.takeScreenShot;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.LoginPage;

public class BaseTest implements AutoConstants{
	
	WebDriver driver;
	WebActionsUtil webActionsUtil;
	@Parameters({"browserName","appURL","ETO","ITO"})
	@BeforeClass
	public void launchApp(@Optional(DEFAULT_BORSWER) String browserName,
			              @Optional(DEFAULT_URL)String appURL,
			              @Optional(ETO)String ETO,
			              @Optional(ITO)String ITO)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
			
		}
		else 
		{
			throw new IllegalArgumentException("Please use valid browser");
		}
		
		long ito=Long.parseLong(ITO);
		long eto=Long.parseLong(ETO);
		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(ito,TimeUnit.SECONDS);
		driver.get(DEFAULT_URL);
		webActionsUtil = new WebActionsUtil(driver, eto);
	}
	
	
	@Parameters({"un" ,"pw"})
	@BeforeMethod
	
	public void loginToApp(@Optional(DEFAULT_USERNAME)String un,
			               @Optional(DEFAULT_PASSWORD)String pw)
	{
		LoginPage lp= new LoginPage(driver, webActionsUtil);
		lp.login(un, pw);
	}
	
 /*  @AfterMethod()
	public void logOutFromApp(ITestResult result)
	{
	   String testCaseName=result.getName();
	   int testcaseStatus = result.getStatus();
	   int status = ITestResult.FAILURE;
	   if(testcaseStatus==status)
	   {
		   System.out.println();
		   takeScreenShot.takePageScreenShot(driver, testCaseName);
	   }
	   
	   Utilities.sleepInseconds(5);
	   HomePage hp=new HomePage(driver, webActionsUtil);
	   hp.logout();
	}*/
	
	@AfterClass(alwaysRun=true)
	public void closeApp()
	{
		driver.quit();
	}

}











