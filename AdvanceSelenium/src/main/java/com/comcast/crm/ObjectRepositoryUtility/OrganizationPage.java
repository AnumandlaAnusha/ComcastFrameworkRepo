package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
	     PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="searchfeild")
	private WebElement searchDD;
	
	@FindBy (xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy (name = "submit")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}
	
	

}
