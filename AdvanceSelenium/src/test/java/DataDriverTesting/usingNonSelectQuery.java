package DataDriverTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class usingNonSelectQuery {

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
		   int result=state.executeUpdate("insert into student values(17,'mock','1223344','mock@gmail.com');");
		   System.out.println(result);
		   conn.close();

	}

}
