package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeServices;
import com.revature.services.ReimbursementService;

@WebServlet("/reimburse")
public class ReimbursementServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	//viewing of reimbursement records.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//create the appropriate service objects
		ReimbursementService reimburseService = new ReimbursementService();
		EmployeeServices employeeService = new EmployeeServices();
		
		System.out.println("CHeck");
		//map the Stringified JSON to an array
		ObjectMapper mapper = new ObjectMapper();
		String[] userFields= mapper.readValue(request.getInputStream(), String[].class);
		
		System.out.println("test");
		//map the JSON object (received in the request) to an Employee
		int userID = Integer.parseInt(userFields[0]);
		Employee user = Employee.duplicate(employeeService.getEmployee(userID));
		
	
		System.out.println("1");
		//call method from the reimb service class that return the record 
		List<Reimbursement> reimburseRecords = new ArrayList<>();
		reimburseRecords = reimburseService.recordSelector(user);
		
		
		//return a JSON object that represents the list of records
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		String recordsJSON = mapper.writeValueAsString(reimburseRecords);
		pw.write(recordsJSON);
	}
	
	//creation of new reimbursement records
	protected void doPut(HttpServletRequest request, HttpServletResponse resposnse) throws ServletException, IOException{
		
	}

	//updating of reimbursement records(manager exclusive)
	protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
