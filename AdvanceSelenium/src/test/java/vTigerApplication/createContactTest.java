package vTigerApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createContactTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//read common data from properties file	
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\CommonDataVtiger.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PW = pro.getProperty("password");
	//generate random number
		Random rand=new Random();
		int randNum = rand.nextInt(1000);
	//read testScript data from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Admin\\Documents\\TestScriptData00.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(7);
		String orgName = row.getCell(2).toString() + randNum;
		String phoneNummber = row.getCell(4).getStringCellValue();
		wb.close();
		
		
		
		
	//login to appn	
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
	//navigate to org module
		driver.findElement(By.linkText("Contacts")).click();
	//click on create org module
		driver.findElement(By.xpath("")).click();
	// enter all the details and create new org
		//driver.findElement(By.name("")).sendKeys(lastName);
		driver.findElement(By.xpath("")).click();
	//logout
		//driver.quit();
		
		
		
		
		
		
	}

}
