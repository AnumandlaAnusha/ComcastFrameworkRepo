package DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataBasedonCondition {

	public static void main(String[] args) throws Throwable {
		String expectedTestId = "TC_02";
		String data1="";
		String data2="";
		String data3="";
		boolean flag = false;
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for(int i=0 ;i<=rowCount; i++)
		{
			String data="";
			try {
			data = sheet.getRow(i).getCell(0).toString();
			if(data.equals(expectedTestId))
			{
				flag = true;
				data1 = sheet.getRow(i).getCell(1).toString();
				data2 = sheet.getRow(i).getCell(2).toString();
				data3 = sheet.getRow(i).getCell(3).toString();
			}
		}catch (Exception e) {}
		}
		if(flag == true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}else {
			System.out.println(expectedTestId + "data is not available");
		}
		wb.close();	
		}	
	}