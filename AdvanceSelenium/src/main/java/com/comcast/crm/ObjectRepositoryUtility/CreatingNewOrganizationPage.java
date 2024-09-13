package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
	     PageFactory.initElements(driver, this);
	}
	@FindBy (name = "accountname")
	private WebElement orgnameEdt;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy (name = "industry")
	private WebElement industryDpDn;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName) {
		getOrgnameEdt().sendKeys(orgName);
		getSaveBtn().click();
	}
	public void createOrg(String orgName, String industryName, String typeName) {
		orgnameEdt.sendKeys(orgName);
		Select sel=new Select(industryDpDn);
		sel.selectByVisibleText("industry");
		saveBtn.click();
		
	}


	
	
}
