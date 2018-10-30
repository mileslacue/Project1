package com.revature.dao;

import com.revature.models.Employee;

//Contain the implemented Data Access Methods
public class EmployeeDAOImpl implements EmployeeDAO {

	public Employee createEmployee(String username, String password) {
		
		//using the username and password that is passed by the user upon logging in construct an employee object
			//will need to connect to the database 
				//select the record that correspond with the login information
					//use that information to pass into the Employee constructor
		
		return null; //should return the constructed user object
	}

}
