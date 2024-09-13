package practiceHomeTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageVerification {
	@Test
	public void homePageTest(Method mtd){
		System.out.println(mtd.getName() + "Test Start");
		String expectedPage = "Home Page";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
        driver.findElement(By.id("submitButton")).click();
       String actTitle = driver.findElement(By.xpath("//a[contains(.,'Home')]")).getText();
       if(actTitle.trim().equals(expectedPage)) {
    	   System.out.println("home page is verified===PASS");
       }else {
    	   System.out.println("not verified==FAIL");
       }
       driver.close();
       System.out.println(mtd.getName() + "test end");
		
		
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd){
		System.out.println(mtd.getName() + "Test Start");
		String expectedPage = "Home";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
        driver.findElement(By.id("submitButton")).click();
        
       boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
       if(status) {
    	   System.out.println("logo is verifies== PASS");
       }else {
    	   System.out.println("logo is not verifies== FAIL");
       }
       driver.close();
       System.out.println(mtd.getName() + "Test END");
		
		
	}

}
