package practiceHomeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsSelectPage;
import com.comcast.crm.ObjectRepositoryUtility.createContactInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.createNewContactPage;
import com.comcast.crm.ObjectRepositoryUtility.createNewOrganizationPage;
import com.comcast.crm.baseTest.BaseClass;

import junit.framework.Assert;
public class hardAndSoftAssertUsingRealSelenium extends BaseClass {

	@Test(groups = "smokeTest")
	public void CreateContactTest() throws Throwable {
		
		// read testScript data from Excel file
		String lastname = eLib.getDataFromExcel("Sheet1", 13, 3) + jLib.getRandomNumber();

		// step 2: navigate to org module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 3: click on create org button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		// step 4: enter all details and create new org
		createNewContactPage ccp = new createNewContactPage(driver);
		ccp.createContact(lastname);
		
		//step 6: verify header phone number info expected result
		//String actHeader =  driver.findElement(By.className("dvHeaderText")).getText();
		String actHeader =  cp.getHeaderMsg().getText();
        boolean status = actHeader.contains(lastname);
		Assert.assertEquals(status, true);
		
		// step 6: verify header lastname info expected result
		//createContactInfoPage cip = new createContactInfoPage(driver);
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(actHeader, actLastName);	
		assertObj.assertAll();
		}
		@Test(groups = "regressionTest")
		public void CreateContactwithSupportDateTest() throws Throwable {
			// read testScript data from Excel file
			String lastname = eLib.getDataFromExcel("Sheet1", 13, 3) + jLib.getRandomNumber();

			// step 2: navigate to org module
			HomePage hp = new HomePage(driver);
			hp.getContactLink().click();

			// step 3: click on create org button
			ContactPage cp = new ContactPage(driver);
			cp.getCreateNewContactBtn().click();

			// step 4: enter all details and create new org
			String StartDate = jLib.getSystemDateYYYYMMDD();
			String afterDateRequires = jLib.getRequiredDateYYYYDDMM(30);
			createNewContactPage cncp = new createNewContactPage(driver);
			cncp.createContactWithSupportDate(lastname, StartDate, afterDateRequires);

			// step 5: verify header msg expected result
			String actualStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
			if (actualStartDate.contains(StartDate)) {
				System.out.println(StartDate + " is verified==PASS");
			} else {
				System.out.println(StartDate + "is not verified==FAIL");
			}

			// step 6: verify header orgname info expected result
			String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
			if (actEndDate.equals(afterDateRequires)) {
				System.out.println(afterDateRequires + " is verified==PASS");
			} else {
				System.out.println(afterDateRequires + "is not verified==FAIL");
			}
		}

		@Test(groups = "regressionTest")
		public void CreateContactwithOrgTest() throws Throwable {
			String lastname = eLib.getDataFromExcel("Sheet1", 13, 3) + jLib.getRandomNumber();
			String orgname = eLib.getDataFromExcel("Sheet1", 13, 2) + jLib.getRandomNumber();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// step 2: navigate to org module
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();

			// step 3: click on create org button
			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateNewOrgBtn().click();

			// step 4: enter all details and create new org
			createNewOrganizationPage cnop = new createNewOrganizationPage(driver);
			cnop.createOrg(orgname);

			// step 5: verify header msg expected result
			String headerInfoo = driver.findElement(By.className("dvHeaderText")).getText();
			
			if (headerInfoo.contains(orgname)) {
				System.out.println(orgname + " is created==PASS");
			} else {
				System.out.println(orgname + "is not created==FAIL");
			}

			// step 2: navigate to org module
			hp.getContactLink().click();

			// step 3: click on create org button
			ContactPage cp = new ContactPage(driver);
			cp.getCreateNewContactBtn().click();

			// step 4: enter all details and create new contact
			createNewContactPage cncp=new createNewContactPage(driver);
			cncp.getLastnameEdt().sendKeys(lastname);
			cncp.getOrgImgSelectButton().click();

			// switch to child window

			String parent = driver.getWindowHandle();
			wLib.switchNewBrowserTab(driver, "Accounts&action");
			OrganizationsSelectPage osp=new OrganizationsSelectPage(driver);

			osp.selectOrg(orgname);
			driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

			driver.switchTo().window(parent);
			cncp.getSaveBtn().click();

			// step 5: verify header msg expected result
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (headerInfo.contains(lastname)) {
				System.out.println(lastname + " is created==PASS");
			} else {
				System.out.println(lastname + "is not created==FAIL");
			}

			// step 6: verify header orgname info expected result
			String actOrgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			System.out.println(actOrgname);
			if (actOrgname.trim().equals(orgname)) {
				System.out.println(orgname + " is verified==PASS");
			} else {
				System.out.println(orgname + "is not verified==FAIL");
			}

		}
}
