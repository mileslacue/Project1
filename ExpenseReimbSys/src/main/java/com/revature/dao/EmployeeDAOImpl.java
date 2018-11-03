package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

//Contain the implemented Data Access Methods
public class EmployeeDAOImpl implements EmployeeDAO {

	public Employee createEmployee(String username, String password) {
		
		//using the username and password that is passed by the user upon logging in construct an employee object
			//will need to connect to the database 
				//select the record that correspond with the login information
					//use that information to pass into the Employee constructor
		
		return null; //should return the constructed user object
	}
	
public Employee getEmployee(String username, String password) {
		
		//constructs an employee object based on client-side login credentials
		Employee user = new Employee();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			//Construct & execute the corresponding SELECT statement
			String sql = "SELECT * FROM EMPLOYEES WHERE (Username = ? AND pass = ?)";
			
			// prepare the SQL call
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// set the values 
			pstmt.setString(1, username);
			pstmt.setString(2, password);	
			
			ResultSet rs = pstmt.executeQuery();			 
		
			//loop through each row, assigning each table field to is corresponding object field
			while(rs.next()) {
				
				user.setEmployeeID(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPass(rs.getString(3));
				user.setFirst_Name(rs.getString(4));
				user.setLast_Name(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUserRoleID(rs.getInt(7));			
			} 
				
		 }catch (SQLException sql) {
			System.out.println("getEmployee function");
			sql.printStackTrace();
		}
			
		return user; //should return the constructed employee(user) object
	}

	
	
}
