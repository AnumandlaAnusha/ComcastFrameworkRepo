package DataDriverTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class usingSelectquery {

	public static void main(String[] args) throws Throwable {
	//create object for driver	
		Driver driverRef = new Driver();
	//load the database driver	
	    DriverManager.registerDriver(driverRef);
	//connect to database
	// DriverManager.getConnection("URL", "UN", "PW");
	// url=jdbc:"vendorName://IP Address:PortNumber/Projects"
	   Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tekpyramid","root","admin");
        System.out.println("===done===");
    //create sql statement
        Statement state=conn.createStatement();
    //execute select query and get result
        ResultSet resultset=state.executeQuery("select * from student");
        while(resultset.next())
        {
        	System.out.println(resultset.getString(1)+ "\t" +resultset.getString(2)+ "\t" +resultset.getString(3)+ "\t" +resultset.getString(4));
        }
        
        
        
        
     //close the connection
        conn.close();
        
	}

}
