package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

//Contain the implemented Data Access Methods {CRUD(Create.Read.Update.Delete) methods}
public class EmployeeDAOImpl implements EmployeeDAO {

	
	
	@Override
	public Employee getEmployee(int id) {
		
		
		//constructs an employee object based on their UserID
		Employee user = new Employee();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			//Construct & execute the corresponding SELECT statement
			String sql = "SELECT * FROM EMPLOYEES WHERE User_ID = ?";
			
			// prepare the SQL call
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// set the values 
			pstmt.setInt(1, id);

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
	
	@Override
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

	@Override
	public boolean checkEmployee(String username, String password) {
		
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
		
			
			//check to see credentials match with the database
			int count = 0;
			while (rs.next()) {
			    ++count;
			}
			if (count == 1) {
			    System.out.println("Username exists");
			    return true;
			}else {
				return false;
			}				
		 }catch (SQLException sql) {
			System.out.println("getEmployee function");
			sql.printStackTrace();
		}
			
		return false;
	}
	
}



