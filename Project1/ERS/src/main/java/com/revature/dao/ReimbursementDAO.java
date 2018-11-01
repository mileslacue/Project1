package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	

	//creates a new reimbursement record 
	public void createReimbursement(double amount, String description, int type, int author);
	public void updateReimbursement(int id, int status); //Validation: ID should be checked to to see if it exists in the table BEFORE function call
	public List<Reimbursement> mngGetAll();
	public List<Reimbursement>  mngGetAccept();
	public List<Reimbursement>  mngGetDecline();
	public List<Reimbursement> mngGetPending();

	
}
