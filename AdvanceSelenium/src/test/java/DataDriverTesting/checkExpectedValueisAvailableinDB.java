package DataDriverTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

public class checkExpectedValueisAvailableinDB {
	@Test
	public void studentCheckTest() throws Throwable {
		String expectedStudentName="king";
		boolean flag=false;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		  Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tekpyramid","root","admin");
	        System.out.println("===done===");
	        Statement state=conn.createStatement();
	        ResultSet resultset=state.executeQuery("select * from student");
	        while(resultset.next()) {
	        	String actualStudentName=resultset.getString(2);
	        	if(expectedStudentName.equals(actualStudentName))
	        	{
	        		flag=true;
	        		System.out.println(expectedStudentName + " is available===pass");
	        	}
	        }
	        if(flag==false) {
	        	System.out.println(expectedStudentName + " is not available==fail");
	        	//Assert.fail();
	        }
	        conn.close();

	}
	

}
	