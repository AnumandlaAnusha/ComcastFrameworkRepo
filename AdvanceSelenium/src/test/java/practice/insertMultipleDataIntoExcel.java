package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.chrome.ChromeDriver;

public class insertMultipleDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("phones");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\amazonData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("AllPhones");
		//Sheet sheet1 = book.getSheet("Above20k");
	    List<WebElement> mobiles = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium ')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));
	
	   for(int i=1;i<mobiles.size();i++)
			{
				sheet.createRow(i).createCell(1).setCellValue(mobiles.get(i).getText());
				sheet.getRow(i).createCell(2).setCellValue(prices.get(i).getText());
				
			}
	   Sheet sh1 = wb.getSheet("amazon4"); 
		int rowcount = 0;
		Sheet sh2 = wb.createSheet("amazon5");
		for (int i = 0; i < productNames.size(); i++) {
           String price = prices.get(i).getText();
           int priceint = Integer.parseInt(price.replace(",", ""));
           if (priceint > 30000) {
           	sh2.createRow(i).createCell(0).setCellValue(productNames.get(i).getText());
   			System.out.println(productNames.get(i).getText()+"\t"+prices.get(i).getText());
   			sh2.getRow(i).createCell(1).setCellValue(prices.get(i).getText());
   			rowcount++;
           }
	 
			
				
				
				
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Documents\\amazonData.xlsx");
			book.write(fos);
			book.close();
			}

}