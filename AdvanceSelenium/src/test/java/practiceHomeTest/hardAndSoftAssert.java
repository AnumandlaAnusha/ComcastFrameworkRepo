package practiceHomeTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import junit.framework.Assert;

public class hardAndSoftAssert {
	@Test
	public void homePage(Method mtd) {
	System.out.println(mtd.getName() + "Test Start");
	SoftAssert assertObj = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
	//hard-Assert--->verify mandatory feilds	
		Assert.assertEquals("Home", "Home-Pge");
		System.out.println("step-3");
	//soft-Assert--->verify non-mandatory feilds	
		assertObj.assertEquals("Title", "Title");
		System.out.println("step-4");
		assertObj.assertAll();
	System.out.println(mtd.getName() + "Test End");
  
	}
}
