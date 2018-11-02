package com.revature.services;


import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

import com.revature.models.Reimbursement;

public class ReimbursementServices {

	private ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();
	
	public Reimbursement createReimbursement(double amount, int author, int type, String description) {
		
		return reimbDAO.createReimbursement(amount, author, type, description);
		
		
	}
	
	
	
}
