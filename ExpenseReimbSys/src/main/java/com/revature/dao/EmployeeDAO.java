package com.revature.dao;

import com.revature.models.Employee;

// Interface containing all (unimplemented) methods that will be used to access/manipulate employee table
// {CRUD(Create.Read.Update.Delete) methods}
public interface EmployeeDAO {

<<<<<<< HEAD:Project1/ERS/src/main/java/com/revature/dao/EmployeeDAO.java
	//create employee OBJECT(not table record) to represent the user upon logging in
	public Employee getEmployee(int id);//constructs an employee object based on their UserID
	public Employee getEmployee(String username, String password);//constructs an employee object based on client-side login credentials
	public boolean checkEmployee(String username, String password);
=======
	//create employee object to represent the user upon logging in
	public Employee createEmployee(String username, String password);

	public Employee getEmployee(String username, String password);
>>>>>>> 4a5cf503d94e1f1c3c5496435d2db9912d6759e2:ExpenseReimbSys/src/main/java/com/revature/dao/EmployeeDAO.java
}
