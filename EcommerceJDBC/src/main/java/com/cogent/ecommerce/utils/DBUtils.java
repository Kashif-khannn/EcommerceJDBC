package com.cogent.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DBUtils {
	@Autowired // performing dependency injection getting one object made by spring
	DataSource dataSource;
	
	public  DBUtils() {
		
	}
	
	
	

	
	
	public Connection getConnection() {
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			return con;
		} 
			// TODO Auto-generated catch block
		
		 catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
