package screenShot;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryListenerTestCase {
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImpClass.class)
	public void activateSim() {
		System.out.println("execute create invoice test");
		Assert.assertEquals("", "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");

}
}
