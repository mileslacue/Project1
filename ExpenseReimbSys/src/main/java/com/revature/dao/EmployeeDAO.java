package com.revature.dao;

import com.revature.models.Employee;

//Interface containing all (unimplemented) methods that will be used to access/manipulate 
//information relating to the employee table
public interface EmployeeDAO {

	//create employee object to represent the user upon logging in
	public Employee createEmployee(String username, String password);

	public Employee getEmployee(String username, String password);
}
