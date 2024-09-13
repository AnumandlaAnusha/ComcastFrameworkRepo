package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webDriverUtilitiy.utilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	WebDriver driver = null;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+"====START===");
		 test = report.createTest(result.getMethod().getMethodName());
		 utilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==Started==");
		 
    }

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+"====END===");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==Completed==");

		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
/* copy screenshot into local file		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File  srcFile = ts.getScreenshotAs(OutputType.FILE);  
			try {
	//	    FileHandler.copy(srcFile, new File("./sreenshot/" +testName+ ".png"));
		    FileHandler.copy(srcFile, new File("./sreenshot/" +testName+ "+" +time+ ".png"));
		    } catch (IOException e) {
			e.printStackTrace();
		}                                                                */
		
//	copy screenshot into extent report	
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
	//	test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==Failed==");

		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
