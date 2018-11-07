package com.revature.dao;

import com.revature.models.Employee;

// Interface containing all (unimplemented) methods that will be used to access/manipulate employee table
// {CRUD(Create.Read.Update.Delete) methods}
public interface EmployeeDAO {

	//create employee OBJECT(not table record) to represent the user upon logging in
	public Employee getEmployee(int id);//constructs an employee object based on their UserID
	public Employee getEmployee(String username, String password);//constructs an employee object based on client-side login credentials
	public boolean checkEmployee(String username, String password);
}
