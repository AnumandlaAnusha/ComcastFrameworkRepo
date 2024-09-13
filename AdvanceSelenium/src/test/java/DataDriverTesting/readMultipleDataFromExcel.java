package DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		
/*   //fetch single data from excel
        Row row = sheet.getRow(1);
		String coloumn1Data = row.getCell(0).toString();
		String coloumn2Data = row.getCell(1).toString();
		System.out.println(coloumn1Data +"\t"+ coloumn2Data);   */
		
	//fetch multiple data from excel
		int rowCount = sheet.getLastRowNum();
       for(int i=1;i<=rowCount;i++)
		{
			Row row = sheet.getRow(i);
			String column1Data = row.getCell(0).toString();
			String column2Data = row.getCell(1).toString();
			System.out.println(column1Data +"\t"+ column2Data);  
		}
		wb.close();
		}
}
