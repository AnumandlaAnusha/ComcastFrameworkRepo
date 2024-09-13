package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createContactInfoPage {
		WebDriver driver;
		public createContactInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerInfo;
		
		@FindBy(id = "dtlview_Last Name")
		private WebElement ActLastName;
		public WebElement getHeaderInfo() {
			return headerInfo;
		}

		public WebElement getActLastName() {
			return ActLastName;
		}

	}


