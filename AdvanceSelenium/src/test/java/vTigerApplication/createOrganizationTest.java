package vTigerApplication;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.protobuf.Duration;

public class createOrganizationTest {

	public static void main(String[] args)throws Throwable  {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
        driver.manage().window().maximize();
 //read data from properties file       
        FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\Documents\\commonData00.properties");
        Properties pro=new Properties();
        pro.load(fis);
        
        String URL = pro.getProperty("url");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");
        driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		
        driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//read data from excel
        Random random=new Random();
		int randomInt=random.nextInt(1000);
		
      FileInputStream fis1= new FileInputStream("C:\\Users\\Admin\\Documents\\TestScriptData00.xlsx");
      Workbook wb = WorkbookFactory.create(fis1);
      Sheet sheet = wb.getSheet("Sheet1");
     Row row = sheet.getRow(1);  
     String orgName = row.getCell(2).toString() + randomInt;
     wb.close();
     
     driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
      
      
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        driver.quit();
	}

}
