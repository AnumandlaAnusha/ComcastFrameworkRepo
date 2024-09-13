package practiceHomeTest;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsingReporterFunctionality {
		@Test
		public void homePage(Method mtd) {
	Reporter.log(mtd.getName() + "Test Start");
		Reporter.log("step-1");
		Reporter.log("step-2");
		Reporter.log("step-3");	
		Reporter.log("step-4");
	Reporter.log(mtd.getName() + "Test End");
	  
		}
		@Test
		public void verifyHomePage(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");
			Reporter.log("step-1");
			Reporter.log("step-2");
			Reporter.log("step-3");	
			Reporter.log("step-4");
		Reporter.log(mtd.getName() + "Test End");
	  
		}
		@Test
		public void verifyHomePageReporter(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");
	//check the reporter log in console	
			Reporter.log("step-1",true);
			Reporter.log("step-2",true);
			Reporter.log("step-3",true);	
			Reporter.log("step-4",true);
		Reporter.log(mtd.getName() + "Test End");
	  
		}
	}



