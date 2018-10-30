package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {


	public void createReimbursement(double amount, int author, int type, String description ) {
		
		//create a new object ()
		Reimbursement reimb = new Reimbursement();
		
		
		//establish a connection to the database (auto commit:off)
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
					
		//prepared statement -> create the SQL INSERT statement to insert a new record into the table
		String sql = "INSERT INTO REIMBURSEMENT (ReImb_Amount, ReImb_Auhtor, ReImb_Type_ID,  ReImb_Description ) VALUES (?,?,?,?)";
		
		//prepare the SQL call
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//set the values > double amt,  Employee author , int type< 
		pstmt.setDouble(1, amount);
		pstmt.setInt(2, author);
		pstmt.setInt(3, type);
		pstmt.setString(4, description);
		
		
		//execute the query 
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			reimb.setAmount(amount);
			
			
		}
			
			
		}catch(SQLException sql) {
			sql.printStackTrace();
		}

		
	}

	public void updateReimbursement() {
		//Financial manager will be able to update the reimbursment table status column
		
	}

	public void getReimbursement(int id) {
		
		
	}



	
}
