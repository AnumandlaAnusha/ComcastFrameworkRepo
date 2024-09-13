package DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchingDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\Book1.xlsx");

	    Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("Sheet1");
		
		Row row = sheet.getRow(1);
		
		Cell cell=row.getCell(3);
	//data formatter is used to print the same data which is present in excel	
		DataFormatter format = new DataFormatter();
	    String ExcelData = format.formatCellValue(cell);
	    System.out.println(ExcelData);
		


	}

}
