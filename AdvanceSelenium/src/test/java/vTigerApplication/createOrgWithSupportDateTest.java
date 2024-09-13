package vTigerApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createOrgWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\CommonDataVtiger.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PW = pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
	//navigate to contact module	
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	//click on create new contact	
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//enter mandotory feild i.e., lastname	
		driver.findElement(By.name("lastname")).sendKeys("abcedd");
		
		Date dateObj = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sdf.format(dateObj);
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String endDate = sdf.format(cal.getTime());

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//verifiying header phone number info expected reuslt		
		String actstartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartDate.equals(startDate))
		{
			System.out.println(startDate + " PASS");
		}else {
			System.out.println(startDate + " FAIL");
		}
		
		String actEndDate = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if(actEndDate.equals(endDate))
		{
			System.out.println(endDate + "PASS");
		}
		else
		{
			System.out.println(endDate + "FAIL");
		}
	
//logout
		driver.quit();
			
		
		
	}

}
