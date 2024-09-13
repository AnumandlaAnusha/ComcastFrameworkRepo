package POMImplementation;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;

public class endToEndScenarioUsingPOM {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//read common data from properties file	
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Documents\\CommonDataVtiger.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PW = pro.getProperty("password");
	//generate random number
		Random rand=new Random();
		int randNum = rand.nextInt(1000);
	//read testScript data from excel
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Admin\\Documents\\TestScriptData00.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(7);
		String orgName = row.getCell(2).toString() + randNum;
		String phoneNummber = row.getCell(4).getStringCellValue();
		wb.close();
		
		
		
		
	//login to appn	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		LoginPage lp= new LoginPage(driver);
		lp.loginToapp(UN, PW);
		
	//navigate to org module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
	//click on create org button
		OrganizationPage cop=new OrganizationPage(driver);
		cop.getCreateNewOrgBtn().click();
		
	// enter all the details and create new org
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
	//verify header msg expected result
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName + "PASS");
		}else {
			System.out.println(orgName + "FAIL");
		}
		
		
	// Logout
		hp.logout();
		driver.quit();
	}

}


