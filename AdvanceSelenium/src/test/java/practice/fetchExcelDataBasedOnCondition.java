package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fetchExcelDataBasedOnCondition {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("phones");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\amazonData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet1 = book.getSheet("AllPhones");
		Sheet sheet2 = book.getSheet("Above20k");
		List<WebElement> mobiles = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium ')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));
		
		
			for (int i = 0; i < mobiles.size(); i++) { 
			    Row sourceRow = sheet1.getRow(i); 
			    Row destRow = sheet2.createRow(i); 
			
			 
			    for (int j = 0; j < sourceRow.getLastCellNum(); j++) { 
			        Cell sourceCell = sourceRow.getCell(j); 
			        Cell destCell = destRow.createCell(j); 
			        
			        if (sourceCell != null) { 
			            destCell.setCellValue(sourceCell.getStringCellValue()); 
			 
		}}}}

}
