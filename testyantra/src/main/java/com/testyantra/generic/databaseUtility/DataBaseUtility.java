package com.testyantra.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;

	public void getDataBaseConnection(String url, String username, String password) throws SQLException {
		// register or load to the database
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

		}

	}
	//we can hardcode 
	public void getDataBaseConnection() {
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void closeconnection() {
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException {
	ResultSet	result=null;
	try {
		Statement state = conn.createStatement();
		 result = state.executeQuery(query);
	}catch(Exception e)
	{
		
	}
		 return result;
	}
	public int executeNonSelectQuery(String query) throws SQLException {
		int	result=0;
		try {
			Statement state = conn.createStatement();
			 result = state.executeUpdate(query);
			 
		}catch(Exception e)
		{
			
		}
		return result;
}
}