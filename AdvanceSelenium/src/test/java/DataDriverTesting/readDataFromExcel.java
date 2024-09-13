package DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromExcel {

	public static void main(String[] args) throws Throwable, IOException  {
		//step 1 : get the excel path location 
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\Book1.xlsx");

		//step 2 : open workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3 : get the control of the sheet1 
		Sheet sheet = wb.getSheet("Sheet1");
		
		//step 4 : get the control of row
		Row row = sheet.getRow(1);
		
		//step 5 : get the control of cell
		/*Cell cell = row.getCell(2);
		String data = cell.getStringCellValue();*/
		
		//String data=row.getCell(2).getStringCellValue();
		double data = row.getCell(3).getNumericCellValue();
		System.out.println(data);
		
		//step 6 : close the workbook
		wb.close();
		
		

	}

}
