package com.comcast.crm.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.dataBaseUtilities.DataBaseUtility;
import com.comcast.crm.generic.fileUtilities.ExcelUtility;
import com.comcast.crm.generic.fileUtilities.FileUtility;
import com.comcast.crm.generic.fileUtilities.JsonUtility;
import com.comcast.crm.generic.webDriverUtilitiy.JavaUtility;
import com.comcast.crm.generic.webDriverUtilitiy.WebDriverUtility;
import com.comcast.crm.generic.webDriverUtilitiy.utilityClassObject;

public class BaseClass {
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public JsonUtility jsnLib = new JsonUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	//public static WebDriver driver = null;  ----> if we give static, this variable will not participate in parallel execution
	public static WebDriver sdriver = null;
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void configBS() throws Throwable
	{
		System.out.println("==Connect to dB and Report config==");
		dbLib.getdBConnection();
	
	ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
	spark.config().setDocumentTitle("CRM test suite results");
	spark.config().setReportName("CRM Report");
	spark.config().setTheme(Theme.DARK);

	 report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "WINDOWS-10");
	report.setSystemInfo("BROWSER", "CHROME-100");
	}

	//@Parameters("BROWSER")
	
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("==Launch Browser==");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
				//fLib.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new EdgeDriver();
		}
		sdriver = driver; //create temporary static varaible
		utilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("== Login ==");
		wLib.waitForPageToLoad(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(USERNAME,PASSWORD);
	}
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void configAM() {
		System.out.println("== Logout ==");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void configAC() {
		System.out.println("== Close Browser==");
		driver.close();
	
		
	}
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void configAS()
	{
		System.out.println("== disconnect to dB and Report backup ==");
		dbLib.closeDbConnection();
		report.flush();
	}
}
