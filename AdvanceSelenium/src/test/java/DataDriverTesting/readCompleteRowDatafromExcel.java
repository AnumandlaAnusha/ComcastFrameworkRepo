package DataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readCompleteRowDatafromExcel {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		for(int i=0;i<=row.getLastCellNum();i++)
		{
			String data="";
			try {
				data=row.getCell(i).getStringCellValue();
			}catch(Exception e) {}
			System.out.print(data +"\t");
			}
		wb.close();
		}
}
		
		
		
		
		


