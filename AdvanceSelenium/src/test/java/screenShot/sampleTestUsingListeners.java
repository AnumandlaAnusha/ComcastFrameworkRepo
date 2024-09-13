package screenShot;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
//import com.crm.generic.BaseUtility.BaseClass;

//@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class sampleTestUsingListeners extends BaseClass {
	@Test
	public void createInvoiceTest() {
		System.out.println("execute create invoice test");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute create invoice with contact test");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");

		
	}

}
