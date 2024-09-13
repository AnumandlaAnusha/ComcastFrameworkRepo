package vTigerApplication;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class createOrg {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	// read common data from json file	
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\CommonDataVtiger.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PW = pro.getProperty("password");
		
	// generate	the random number
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
	// read testscript data from excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Admin\\Documents\\TestScriptData00.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(7);
		String orgName = row.getCell(2).toString() + randomInt;
		String phoneNummber = row.getCell(4).getStringCellValue();
		wb.close();
		
		
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		
        driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNummber);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();

		
		
		

	}

}
