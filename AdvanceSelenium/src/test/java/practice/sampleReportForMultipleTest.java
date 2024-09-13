package practice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class sampleReportForMultipleTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	
	}
	@AfterSuite
	public void congifAS() {
		report.flush();
		
	}
	@Test
	public void createContactTest() {

		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");

		}
	//backup the reports	
		report.flush();
		
	}
	@Test 
	public void createContactWithORG() {
		ExtentTest test = report.createTest("createContactWithORG");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");

		}
	}
	@Test
	public void createContactWithPhoneNumber() {
       ExtentTest test = report.createTest("createContactWithPhoneNumber");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}
	}
}
