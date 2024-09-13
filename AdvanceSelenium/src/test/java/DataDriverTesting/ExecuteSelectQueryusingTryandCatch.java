package DataDriverTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryusingTryandCatch {

	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tekpyramid","root","admin");
	        System.out.println("===done===");
	        Statement state=conn.createStatement();
	        ResultSet resultset=state.executeQuery("select * from student");
	       while(resultset.next()) {
	    	   System.out.println(resultset.getString(1) + "\t" +resultset.getString(2) + "\t" +resultset.getString(3));
	    	   
	        }
	}catch (Exception e) {
		System.out.println("handle Exception");
	}finally {
		conn.close();
		System.out.println("====connection close====");

	}
	}
}
