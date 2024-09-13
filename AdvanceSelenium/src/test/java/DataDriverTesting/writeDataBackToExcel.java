package DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writeDataBackToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellValue("FAIL");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\Documents\\Book1.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}

}
