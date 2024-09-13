package DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class readDataFromJASONFile {

	public static void main(String[] args) throws Throwable {
		
	//step1: parse json physical file into the java object jason parse 
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\Documents\\commonData.json"));
		
	//step 2: convert java object to JSON object using downcasting
		JSONObject map=(JSONObject)obj;
		
	//step 3: get the value from json file using key	
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
		
	}
}

//use below code in create org in vtiger application


/* @Test
 * JSONParser parser = new JSONParser();
Object obj = parser.parse(new FileReader("C:\\Users\\Admin\\Documents\\commonData.json"));
JSONObject map=(JSONObject)obj;

String URL = map.get("url").toString();
String BROWSER = map.get("browser").toString();
String USERNAME = map.get("username").toString();
String PASSWORD = map.get("password").toString();     
 //generate random  number
  * Random random=new Random();
  * int randomInt=random.nextInt(100);
 // read testcsript data from excel file
  * FIS fis=new FIS("");
  * WORKBOOK
  * SHEET
  * ROW
  * String orgName= row.getCell(2).toString() + randomInt;
  * wb.close();*/






     
