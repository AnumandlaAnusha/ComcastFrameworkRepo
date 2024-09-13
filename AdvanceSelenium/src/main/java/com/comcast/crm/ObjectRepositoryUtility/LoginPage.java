package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //Rule-1 create a new java class
	                     
WebDriver driver;	
 //Rule-2 Object Creation 
//create constructor	
public LoginPage(WebDriver driver) {
		this.driver=driver;
	     PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	 WebElement usernameEdt;
	
	@FindBy(name="user_password")
	 WebElement passwordEdt;
	
	@FindBy(id="submitButton")
     WebElement loginBtn;
//Rule-3 object Initialization
	
//Rule-4 Object Encapsulation
		
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
//Rule-5 object Utilization
	//Rule-6 provide Action(business method )
	public void loginToapp(String username, String password) {
		driver.manage().window().maximize();
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("root");
		loginBtn.click();
	}
	
	

	
}

