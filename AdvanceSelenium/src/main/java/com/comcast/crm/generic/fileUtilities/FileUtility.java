package com.comcast.crm.generic.fileUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./commonData/commonData00.properties");
		Properties pro =new Properties();
		pro.load(fis);
		String data = pro.getProperty(key);
		
		return data;
		
	}

}
