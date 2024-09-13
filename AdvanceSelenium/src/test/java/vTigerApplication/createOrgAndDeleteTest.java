package vTigerApplication;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.generic.fileUtilities.ExcelUtility;
import com.comcast.crm.generic.fileUtilities.FileUtility;
import com.comcast.crm.generic.webDriverUtilitiy.JavaUtility;
import com.comcast.crm.generic.webDriverUtilitiy.WebDriverUtility;

public class createOrgAndDeleteTest {
	public static void main(String[] args) throws Throwable {
// create object
		/* Create Objects */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// read common data from properties file

		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// read testScript data from Excel file
		String orgname = eLib.getDataFromExcel("Sheet1", 10, 2) + jLib.getRandomNumber();

		
		// Step 1: login to app
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		// LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		lp.loginToapp(USERNAME, PASSWORD);

		// step 2: navigate to org module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on create org button
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		// step 4: enter all details and create new org
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// step 5: verify header msg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualOrgName = oip.getHeaderMsg().getText();
		if (actualOrgName.contains(orgname)) {
			System.out.println(orgname + " is verified==PASS");
		} else {
			System.out.println(orgname + "is not verified==FAIL");
		}
		//Go back to Organizations Page
		hp.getOrgLink().click();
		//Search for Organizations
		op.getSearchEdt().sendKeys(orgname);
		wLib.selectByVisibleText(op.getSearchDD(), "Organization Name");
		op.getSearchDD().click();
		
		//In dynamic webtable select and delete org
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		wLib.switchToAlertAndAccept(driver);
		// step 6: logout
		hp.logout();
		driver.quit();
	}
}