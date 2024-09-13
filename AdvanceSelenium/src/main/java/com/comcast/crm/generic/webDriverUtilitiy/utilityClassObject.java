package com.comcast.crm.generic.webDriverUtilitiy;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class utilityClassObject {
//this method will give the extend report object for multiple threads when we achieve parallel execution	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}



}
