package com.comcast.crm.generic.dataBaseUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getdBConnection(String url, String username, String password) throws Throwable {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			}
	}
//hardcoding the script 	
	public void getdBConnection() throws Throwable {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "admin");
		}catch (Exception e) {
			}
	}

	public void closeDbConnection() {
		try {
			conn.close();
		}catch (Exception e) {
		   }
		}
// executing select queries	
	public ResultSet executSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
			Statement state=conn.createStatement();
			result=state.executeQuery(query);
		}catch (Exception e) {
			}
		return result;
	}
//executing non-select queries	
	public int executNonSelectQuery(String query)  {
		int result = 0;
		try {
			Statement state=conn.createStatement();
			result=state.executeUpdate(query);
		}catch (Exception e) {
			}
		return result;
	}
	}
