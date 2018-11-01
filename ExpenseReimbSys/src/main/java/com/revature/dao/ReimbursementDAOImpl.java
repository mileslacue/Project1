package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	public Reimbursement createReimbursement(double amount, int author, int type, String description) {

		// create a new object ()
		Reimbursement reimb = new Reimbursement();
		System.out.println("Spinning up method to create a reimbursement");

		// establish a connection to the database (auto commit:off)
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			// prepared statement -> create the SQL INSERT statement to insert a new record
			// into the table
			String sql = "INSERT INTO REIMBURSEMENT (ReImb_Amount, ReImb_Author, ReImb_Type_ID,  ReImb_Description ) VALUES (?,?,?,?)";

			// prepare the SQL call
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// set the values > double amt, Employee author , int type<
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, author);
			pstmt.setInt(3, type);
			pstmt.setString(4, description);

			// execute the query
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Creation Executed and Row Inserted");

		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return reimb;

	}

	public ArrayList<Reimbursement> emp_getAllReimb() {
		// create a new object ()
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		System.out.println("Spinning up the method to get all reimbursements");

		// establish a connection to the database (auto commit:off)
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			// prepared statement -> create the SQL INSERT statement to insert a new record
			// into the table
			String sql = "SELECT * FROM REIMBURSEMENT";

			// prepare the SQL call
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// execute the query
			ResultSet rs = pstmt.executeQuery();
			System.out.println("All Reimbursements Gathered");
			while (rs.next()) {
				Reimbursement r = new Reimbursement();

				r.setReimbID(rs.getInt("REIMB_ID"));
				r.setAmount(rs.getInt("REIMB_AMOUNT"));
				r.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				r.setApproved(rs.getTimestamp("REIMB_RESOLVED"));
				r.setDescription(rs.getString("REIMB_DESCRIPTION"));
				r.setAuthor(rs.getInt("REIMB_AUTHOR"));
				r.setResolver(rs.getInt("REIMB_RESOLVER"));
				r.setStatusID(rs.getInt("REIMB_STATUS_ID"));
				r.setTypeID(rs.getInt("REIMB_TYPE_ID"));
				reimbursements.add(r);
			}

		} catch (SQLException sql) {
			sql.printStackTrace();
		}

		return reimbursements;

	}

	public void updateReimbursement() {
		// Financial manager will be able to update the reimbursment table status column

	}

	@Override
	public ArrayList<Reimbursement> emp_getApprovedReimb() {
		// create a new object ()
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		System.out.println("Spinning up the method to get all accepted reimbursements");

		// establish a connection to the database (auto commit:off)
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			// prepared statement -> create the SQL INSERT statement to insert a new record
			// into the table
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMB_STATUS_ID = 3";

			// prepare the SQL call
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// execute the query
			ResultSet rs = pstmt.executeQuery();
			System.out.println("All Accepted Reimbursements Gathered");
			while (rs.next()) {
				Reimbursement r = new Reimbursement();

				r.setReimbID(rs.getInt("REIMB_ID"));
				r.setAmount(rs.getInt("REIMB_AMOUNT"));
				r.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
				r.setApproved(rs.getTimestamp("REIMB_RESOLVED"));
				r.setDescription(rs.getString("REIMB_DESCRIPTION"));
				r.setAuthor(rs.getInt("REIMB_AUTHOR"));
				r.setResolver(rs.getInt("REIMB_RESOLVER"));
				r.setStatusID(rs.getInt("REIMB_STATUS_ID"));
				r.setTypeID(rs.getInt("REIMB_TYPE_ID"));
				reimbursements.add(r);
			}

		} catch (SQLException sql) {
			sql.printStackTrace();
		}

		return reimbursements;

	}

	@Override
	public ArrayList<Reimbursement> emp_getDeclinedReimb() {
		// create a new object ()
				ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				System.out.println("Spinning up the method to get all declined reimbursements");

				// establish a connection to the database (auto commit:off)
				try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

					// prepared statement -> create the SQL INSERT statement to insert a new record
					// into the table
					String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMB_STATUS_ID = 2";

					// prepare the SQL call
					PreparedStatement pstmt = conn.prepareStatement(sql);

					// execute the query
					ResultSet rs = pstmt.executeQuery();
					System.out.println("All Declined Reimbursements Gathered");
					while (rs.next()) {
						Reimbursement r = new Reimbursement();

						r.setReimbID(rs.getInt("REIMB_ID"));
						r.setAmount(rs.getInt("REIMB_AMOUNT"));
						r.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
						r.setApproved(rs.getTimestamp("REIMB_RESOLVED"));
						r.setDescription(rs.getString("REIMB_DESCRIPTION"));
						r.setAuthor(rs.getInt("REIMB_AUTHOR"));
						r.setResolver(rs.getInt("REIMB_RESOLVER"));
						r.setStatusID(rs.getInt("REIMB_STATUS_ID"));
						r.setTypeID(rs.getInt("REIMB_TYPE_ID"));
						reimbursements.add(r);
					}

				} catch (SQLException sql) {
					sql.printStackTrace();
				}

				return reimbursements;
	}

}
