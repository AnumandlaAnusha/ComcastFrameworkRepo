package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class propertiesToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fisPro = new FileInputStream("C:\\Users\\Admin\\Documents\\Task1100.properties");
		Properties pro = new Properties();
		pro.load(fisPro);
		pro.keySet();
		
		FileInputStream fisExcel = new FileInputStream("C:\\Users\\Admin\\Documents\\Task1.xlsx");
		Workbook book = WorkbookFactory.create(fisExcel);
		Sheet sheet1 = book.getSheet("Sheet1");
	
		
        int rowIndex = 0;
        for (String key : pro.stringPropertyNames()) {
            Row row = sheet1.createRow(rowIndex++);
           // row.createCell(0).setCellValue(key);
            row.createCell(0).setCellValue(pro.getProperty(key));
        }
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Documents\\Task1.xlsx")) {
            book.write(fos);
        }

        book.close();

        System.out.println("Properties have been written to the Excel file.");

    }

}


