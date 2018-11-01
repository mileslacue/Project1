package com.revature.drivers;

import java.util.ArrayList;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.models.Reimbursement;

public class ERS_Driver {
	public static void main(String[] args) {
		ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();
		
//		// create reimbursements
		
		reimbDAO.createReimbursement(50.00, 2, 3, "This is a test as well");
//-----------------------------------------------------------------------------------
		// get all reimbursements
		
//		ArrayList<Reimbursement> reimbursements = reimbDAO.emp_getAllReimb();
//		// loop through the artists ArrayList and print each Artist
//		for (Reimbursement reimb : reimbursements) {
//			System.out.println(reimb);
//		}
		// -----------------------------------------------------------------------------------
//		// get all reimbursements where the status is "Approved"
		
//		ArrayList<Reimbursement> approvedReimb = reimbDAO.emp_getApprovedReimb();
//		// loop through the artists ArrayList and print each Artist
//		for (Reimbursement reimb : approvedReimb) {
//			System.out.println(reimb);
//		}
		// -----------------------------------------------------------------------------------
//		// get all reimbursements where the status is "Declined"
		
//		ArrayList<Reimbursement> declinedReimb = reimbDAO.emp_getDeclinedReimb();
//		// loop through the artists ArrayList and print each Artist
//		for (Reimbursement reimb : declinedReimb) {
//			System.out.println(reimb);
//		}
		// -----------------------------------------------------------------------------------
	}
}
