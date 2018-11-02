package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	

	//creates a new reimbursement record 
	Reimbursement createReimbursement(double amount, int author, int type, String description);
		
	//get all reimbursements that belong to current employee
	ArrayList<Reimbursement> emp_getAllReimb();
	
	//get all reimbursements that belong to current employee that are "Approved"
	ArrayList<Reimbursement> emp_getApprovedReimb();
	
	//Get all reimbursements that belong to the current employee that are "Declined"
	ArrayList<Reimbursement> emp_getDeclinedReimb();
	
	
	public void updateReimbursement();
	
	
}
