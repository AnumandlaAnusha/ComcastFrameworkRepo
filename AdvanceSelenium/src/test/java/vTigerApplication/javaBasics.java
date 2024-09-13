package vTigerApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class javaBasics {

	public static void main(String[] args) {
		Date dateObj = new Date();
		//System.out.println(dateObj.toString());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String actDate = sdf.format(dateObj);
		System.out.println("current date "+ actDate);
		
		//Calendar cal = sdf.getCalendar();
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DAY_OF_MONTH,30);
		//cal.add(Calendar.DAY_OF_MONTH,-30);  after date
		String dateReq = sdf.format(cal.getTime());
		System.out.println("before date "+ dateReq);
		
	}

}
