package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {


	public void createReimbursement(double amount, String description, int type, int author ) {
			
		//establish a connection to the database (auto commit:off)
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
					
		//prepared statement -> create the SQL INSERT statement to insert a new record into the table
		String sql = "INSERT INTO REIMBURSEMENT (ReImb_Amount, ReImb_Author, ReImb_Type_ID,  ReImb_Description ) VALUES (?,?,?,?)";
		
		//prepare the SQL call
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//set the values > double amt,  Employee author , int type< 
		pstmt.setDouble(1, amount);
		pstmt.setInt(2, author);
		pstmt.setInt(3, type);
		pstmt.setString(4, description);
		
		
		//execute the query 
		ResultSet rs = pstmt.executeQuery();

		//commit changes	
		conn.commit();
		}catch(SQLException sql) {
			System.out.println("Create function");
			sql.printStackTrace();
		}

		
	}

	public void updateReimbursement(int id, int status) {
		//Financial manager will be able to update the reimbursement table status column
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			// prepared statement -> create the SQL INSERT statement to insert a new record
			// into the table
			String sql = "UPDATE REIMBURSEMENT SET ReImb_Status_ID = ? WHERE ReImb_ID = ?";                       
			// prepare the SQL call
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// set the values 
			pstmt.setInt(1, status);
			pstmt.setInt(2, id);	
			
			// execute the query
			ResultSet rs = pstmt.executeQuery();
			
			//commit changes
			conn.commit();
		} catch (SQLException sql) {
			System.out.println("update function");
			sql.printStackTrace();
		}
	}


	@Override
	public List<Reimbursement> mngGetAll() {
		
		List<Reimbursement> records = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			//Construct & execute the corresponding SELECT statement
			String sql = "SELECT * FROM REIMBURSEMENT";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);   
		
			//loop through each row, assigning each table field to is corresponding object field
			while(rs.next()) {
				Reimbursement rec = new Reimbursement();
				rec.setReimbID(rs.getInt(1));
				rec.setAmount(rs.getDouble(2));
				rec.setSubmitted(rs.getTimestamp(3));
				rec.setResolved(rs.getTimestamp(4));
				rec.setDescription(rs.getString(5));
				//Receipt(would go here) not included
				rec.setAuthor(rs.getInt(7));
				rec.setResolver(rs.getInt(8));
				rec.setStatusID(rs.getInt(9));
				rec.setTypeID(rs.getInt(10));
				
				//appended populated record to the list of records to be returned
				records.add(rec);
				
			}

		} catch (SQLException sql) {
			System.out.println("mngGetAll function");
			sql.printStackTrace();
		}
		return records;
	}
	
	
	@Override
	public List<Reimbursement> mngGetAccept() {
		
		List<Reimbursement> records = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			//Construct & execute the corresponding SELECT statement
			String sql = "SELECT * FROM REIMBURSEMENT WHERE ReImb_Status_ID = 3";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);   
		
			//loop through each row, assigning each table field to is corresponding object field
			while(rs.next()) {
				Reimbursement rec = new Reimbursement();
				rec.setReimbID(rs.getInt(1));
				rec.setAmount(rs.getDouble(2));
				rec.setSubmitted(rs.getTimestamp(3));
				rec.setResolved(rs.getTimestamp(4));
				rec.setDescription(rs.getString(5));
				//Receipt(would go here) not included
				rec.setAuthor(rs.getInt(7));
				rec.setResolver(rs.getInt(8));
				rec.setStatusID(rs.getInt(9));
				rec.setTypeID(rs.getInt(10));
				
				//appended populated record to the list of records to be returned
				records.add(rec);
				
			}

		} catch (SQLException sql) {
			System.out.println("mngGetAccept function");
			sql.printStackTrace();
		}
		return records;
	}

	
	@Override
	public List<Reimbursement> mngGetDecline() {
		List<Reimbursement> records = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			//Construct & execute the corresponding SELECT statement
			String sql = "SELECT * FROM REIMBURSEMENT WHERE ReImb_Status_ID = 2 ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);   
		
			//loop through each row, assigning each table field to is corresponding object field
			while(rs.next()) {
				Reimbursement rec = new Reimbursement();
				rec.setReimbID(rs.getInt(1));
				rec.setAmount(rs.getDouble(2));
				rec.setSubmitted(rs.getTimestamp(3));
				rec.setResolved(rs.getTimestamp(4));
				rec.setDescription(rs.getString(5));
				//Receipt(would go here) not included
				rec.setAuthor(rs.getInt(7));
				rec.setResolver(rs.getInt(8));
				rec.setStatusID(rs.getInt(9));
				rec.setTypeID(rs.getInt(10));
				
				//appended populated record to the list of records to be returned
				records.add(rec);
				
			}

		} catch (SQLException sql) {
			System.out.println("mngGetDecline function");
			sql.printStackTrace();
		}
		return records;
	}

	
	@Override
	public List<Reimbursement> mngGetPending() {
	
		List<Reimbursement> records = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			//Construct & execute the corresponding SELECT statement
			String sql = "SELECT * FROM REIMBURSEMENT WHERE ReImb_Status_ID = 1";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);   
		
			//loop through each row, assigning each table field to is corresponding object field
			while(rs.next()) {
				Reimbursement rec = new Reimbursement();
				rec.setReimbID(rs.getInt(1));
				rec.setAmount(rs.getDouble(2));
				rec.setSubmitted(rs.getTimestamp(3));
				rec.setResolved(rs.getTimestamp(4));
				rec.setDescription(rs.getString(5));
				//Receipt(would go here) not included
				rec.setAuthor(rs.getInt(7));
				rec.setResolver(rs.getInt(8));
				rec.setStatusID(rs.getInt(9));
				rec.setTypeID(rs.getInt(10));
				
				//appended populated record to the list of records to be returned
				records.add(rec);
				
			}

		} catch (SQLException sql) {
			System.out.println("mngGetAll function");
			sql.printStackTrace();
		}
		return records;
	}





	
}
