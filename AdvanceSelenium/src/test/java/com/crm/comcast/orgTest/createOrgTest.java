package com.crm.comcast.orgTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.createNewOrganizationPage;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webDriverUtilitiy.utilityClassObject;

import junit.framework.Assert;

	public class createOrgTest extends BaseClass{
	//	WebDriver driver = null;
		
		@Test(groups = "smokeTest")
		public void CreateOrgTest() throws Throwable {
			String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();
			// Step 1: login to app
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			// step 2: navigate to org module
			utilityClassObject.getTest().log(Status.INFO, "navigated to org page");
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();

			// step 3: click on create org button
			utilityClassObject.getTest().log(Status.INFO, "cliked on org button");
			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateNewOrgBtn().click();

			// step 4: enter all details and create new org
			utilityClassObject.getTest().log(Status.INFO, "created new org");
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName);
			utilityClassObject.getTest().log(Status.INFO, orgName+ "created a new org");



			// step 5: verify header msg expected result
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String actualOrgName = oip.getHeaderMsg().getText();
			Assert.assertEquals(true, actualOrgName.contains(orgName));
		/*	if (actualOrgName.contains(orgName)) {
				System.out.println(orgName + " is verified==PASS");
			} else {
				System.out.println(orgName + "is not verified==FAIL");
			}           */

		}

		@Test(groups = "regressionTest")
		public void createOrgTestWithIndustry() throws Throwable {
			String orgName = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
			String IndustryName = eLib.getDataFromExcel("Sheet1", 4, 4);
			String TypeName = eLib.getDataFromExcel("Sheet1", 4, 5);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			// step 2: navigate to org module
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();
			// step 3: click on create org button
			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateNewOrgBtn().click();
			// step 4: enter all details and create new org
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName, IndustryName, TypeName);

			// verify the industry and type info
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String actualOrgName = oip.getHeaderMsg().getText();
			Assert.assertEquals(true, actualOrgName.contains(orgName));

		}

		@Test(groups = "regressionTest")
		public void createOrgTestWithPhoneNumber() throws Throwable {
			String orgName = eLib.getDataFromExcel("Sheet1", 7, 2) + jLib.getRandomNumber();
			String phoneNumber = eLib.getDataFromExcel("Sheet1", 7, 4);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			// step 2: navigate to org module
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();
			// step 3: click on create org button
			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateNewOrgBtn().click();
			// step 4: enter all details and create new org
			createNewOrganizationPage cnop = new createNewOrganizationPage(driver);
			cnop.createOrgwithPhno(orgName, phoneNumber);

			// step 5: verify phno as expected result
			String actPhoneNo = driver.findElement(By.id("dtlview_Phone")).getText();
			Assert.assertEquals(true, actPhoneNo.contains(orgName));

		}
	}