package com.comcast.crm.generic.webDriverUtilitiy;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random rand=new Random();
		int randomNum = rand.nextInt(1000);
		return randomNum;
		
	}
	public String getSystemDateYYYYMMDD()
	{
		Date dateObj = new Date(0);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
		
	}
public String getRequiredDateYYYYDDMM(int days) {
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		//Calendar cal=sdf.getCalendar();
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sdf.format(cal.getTime());
		return reqDate;
		
				
	}

}
