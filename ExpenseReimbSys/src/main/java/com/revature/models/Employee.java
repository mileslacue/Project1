package com.revature.models;

//POJO Representing the employee table
public class Employee {

	private int employeeID;
	private String username;
	private String email;
	private String pass;
	private String First_Name;
	private String Last_Name;
	private String email;
	private int userRoleID;
	
	
	//Constructors
	public Employee() {}
	
<<<<<<< HEAD:Project1/ERS/src/main/java/com/revature/models/Employee.java
	public Employee(int employeeID, String username, String pass, String first_Name, String last_Name, String email,
			int userRoleID) {
		super();
		this.employeeID = employeeID;
		this.username = username;
		this.pass = pass;
		First_Name = first_Name;
		Last_Name = last_Name;
		this.email = email;
		this.userRoleID = userRoleID;
=======
	public Employee(int empID, String userN, String passw, String fn, String ln, int roleID, String email ) {
		
		this.employeeID = empID;
		this.username = userN;
		this.username = passw;
		this.First_Name = fn;
		this.Last_Name = ln;
		this.email = email;
		this.userRoleID = roleID;
		
>>>>>>> 4a5cf503d94e1f1c3c5496435d2db9912d6759e2:ExpenseReimbSys/src/main/java/com/revature/models/Employee.java
	}
	
	
	public Employee(Employee originalUser) {
		super();
<<<<<<< HEAD:Project1/ERS/src/main/java/com/revature/models/Employee.java
		this.employeeID = originalUser.employeeID;
=======
>>>>>>> 4a5cf503d94e1f1c3c5496435d2db9912d6759e2:ExpenseReimbSys/src/main/java/com/revature/models/Employee.java
		this.username = originalUser.username;
		this.email = originalUser.email;
		this.pass = originalUser.pass;
		this.First_Name = originalUser.First_Name;
		this.Last_Name = originalUser.Last_Name;
		this.userRoleID = originalUser.userRoleID;
<<<<<<< HEAD:Project1/ERS/src/main/java/com/revature/models/Employee.java
}

=======
	}
	
	//GETTERS AND SETTERS
>>>>>>> 4a5cf503d94e1f1c3c5496435d2db9912d6759e2:ExpenseReimbSys/src/main/java/com/revature/models/Employee.java

	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getFirst_Name() {
		return First_Name;
	}


	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}


	public String getLast_Name() {
		return Last_Name;
	}


	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getUserRoleID() {
		return userRoleID;
	}


	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((First_Name == null) ? 0 : First_Name.hashCode());
		result = prime * result + ((Last_Name == null) ? 0 : Last_Name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeID;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + userRoleID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (First_Name == null) {
			if (other.First_Name != null)
				return false;
		} else if (!First_Name.equals(other.First_Name))
			return false;
		if (Last_Name == null) {
			if (other.Last_Name != null)
				return false;
		} else if (!Last_Name.equals(other.Last_Name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (userRoleID != other.userRoleID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", username=" + username + ", pass=" + pass + ", First_Name="
				+ First_Name + ", Last_Name=" + Last_Name + ", email=" + email + ", userRoleID=" + userRoleID + "]";
	}

<<<<<<< HEAD:Project1/ERS/src/main/java/com/revature/models/Employee.java
=======
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
>>>>>>> 4a5cf503d94e1f1c3c5496435d2db9912d6759e2:ExpenseReimbSys/src/main/java/com/revature/models/Employee.java
	
	public static Employee duplicate(Employee originalUser) {
		return new Employee(originalUser);
}

	
	
	public static Employee duplicate(Employee originalUser) {
		return new Employee(originalUser);
	}
	
}