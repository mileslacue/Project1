package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cf;
	private static boolean build = true;

	private ConnectionFactory() {
		build = false;
	}

	public static synchronized ConnectionFactory getInstance() {
		return (build) ? cf = new ConnectionFactory() : cf;
	}
<<<<<<< HEAD:Project1/ERS/src/main/java/com/revature/util/ConnectionFactory.java
	
	//establishes connection to the database
	public Connection getConnection()  {
=======

	public Connection getConnection() {
>>>>>>> 4a5cf503d94e1f1c3c5496435d2db9912d6759e2:ExpenseReimbSys/src/main/java/com/revature/util/ConnectionFactory.java
		
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			//Load the properties file keys/values intotheProperties object
			prop.load(new FileReader("src/main/resources/application.properties"));
			
<<<<<<< HEAD:Project1/ERS/src/main/java/com/revature/util/ConnectionFactory.java
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Load the properties file keys/values into the Properties object
			prop.load(new FileReader("C:/Users/Luctamar/git Repository/1810-Oct08-Java-USF/Jeffly_Luctamar_Code/Springtools projects/Week 3/Project1/ERS/src/main/resources/Application.Properties"));  //possible solution to possible paths problem URL fileLoc = getClass().getResource ("../../../application.properties");
=======
>>>>>>> 4a5cf503d94e1f1c3c5496435d2db9912d6759e2:ExpenseReimbSys/src/main/java/com/revature/util/ConnectionFactory.java
			
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("usr"), 
					prop.getProperty("pw")
					);
			//catch exceptions for if SQL Database isn't found, Field not found and the input/output
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
