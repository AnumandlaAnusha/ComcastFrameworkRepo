package screenShot;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class sampleTestForScreenshot {
	@Test
	public void amazonTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File  srcFile = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("./sreenshot/test.png"));		
		
		
/*Above selenium-4 version eventFiringWebDriver will not support instead we use TakesScreenshot and FileHandler
 * 	//step-1 create an object to eventFiring WebDriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
	//step-2 use getScreenshotAs method to get file type of screenshot
	     File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
	 //step-3 store screenshot in local driver
	     FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));  */
		
		
		
	}

}
