package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
		public  ContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(className = "dvHeaderText")
		private WebElement headerMsg;
		
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createNewContactBtn;
		
		
		
		public WebDriver getDriver() {
			return driver;
		}



		public WebElement getHeaderMsg() {
			return headerMsg;
		}



		public WebElement getCreateNewContactBtn() {
			return createNewContactBtn;
		}

	}


