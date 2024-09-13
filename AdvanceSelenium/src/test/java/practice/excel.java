package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class excel {

	public static void main(String[] args) {
		WebDriver driver = null;
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\amazonData.xlsx");
		
		 
		// Load the workbook 
		Workbook workbook = WorkbookFactory.create(fis); 
		 
		// Get the source sheet (Sheet 1) and destination sheet (Sheet 2) 
		Sheet sourceSheet = workbook.getSheet("Sheet1"); 
		Sheet destSheet = workbook.createSheet("Sheet2"); 
		 List<WebElement> mobiles = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium ')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));
		
		 
		// Copy rows from source to destination 
		for (int i = 0; i < numRows; i++) { 
		    Row sourceRow = sourceSheet.getRow(i); 
		    Row destRow = destSheet.createRow(i); 
		 
		    for (int j = 0; j < sourceRow.getLastCellNum(); j++) { 
		        Cell sourceCell = sourceRow.getCell(j); 
		        Cell destCell = destRow.createCell(j); 
		 
		        if (sourceCell != null) { 
		            destCell.setCellValue(sourceCell.getStringCellValue()); 
		        } 
		    } 
		} 
		 
		// Write the changes back to the workbook 
		FileOutputStream fileOut = new FileOutputStream("path/to/your/excel/file.xlsx"); 
		workbook.write(fileOut); 
		fileOut.close(); 
		workbook.close(); 

	}

}
