package practiceHomeTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class HardAssert {
	@Test
	public void homePage(Method mtd) {
	System.out.println(mtd.getName() + "Test Start");
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("Home", "Home-Pge");
		System.out.println("step-3");
		Assert.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("step-4");
		
	System.out.println(mtd.getName() + "Test End");

		
	}
	@Test
	public void verifyHomePageLogo(Method mtd) {
	System.out.println(mtd.getName() + "Test Start");
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		
	System.out.println(mtd.getName() + "Test End");

		
	}

}
