package com.comcast.crm.generic.fileUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fileReader = new FileReader("./commonData/commonData.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fileReader);
		JSONObject map = (JSONObject)obj;
		String data=(String) map.get(key);
		return data;
		
	}
	

}
