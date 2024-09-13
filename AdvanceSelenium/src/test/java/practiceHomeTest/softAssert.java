package practiceHomeTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssert {
	@Test
	public void homePage(Method mtd) {
	System.out.println(mtd.getName() + "test start");
	
		SoftAssert assertObj = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertEquals("Home", "Home-page");
		
		System.out.println("step-3");
		assertObj.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("step-4");
		assertObj.assertAll();
		
	System.out.println(mtd.getName() + "test end");

		
	}
	@Test
	public void verifyHomePageLogo(Method mtd) {
	System.out.println(mtd.getName() + "test start");
	
		SoftAssert assertObj = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		assertObj.assertAll();
		
	System.out.println(mtd.getName() + "test end");

		
	}

}
