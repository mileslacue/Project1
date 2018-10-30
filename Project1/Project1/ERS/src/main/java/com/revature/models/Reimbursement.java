package com.revature.models;

import java.sql.Timestamp;

//POJO representing the reimbursement table
public class Reimbursement {
	
	private int reimbID;
	private double amount;
	private Timestamp submitted;
	private Timestamp approved;
	//private     /*data type for reciept*/     description;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public Reimbursement() {}
	
	public Reimbursement(int id, double amt, Timestamp submit, int author, int resolve, int stat, int type) {
		
		this.reimbID = id;
		this.amount = amt;
		this.submitted = submit;
		this.author = author;
		this.resolver = resolve;
		this.statusID = stat;
		this.typeID = type;
	}
	
	public Reimbursement(int id, double amt, Timestamp submit, int author,  int stat, int type) {
	
		this.reimbID = id;
		this.amount = amt;
		this.submitted = submit;
		this.author = author;
		this.statusID = stat;
		this.typeID = type;
	}
	
	public Reimbursement(int id, double amt, Timestamp submit, Timestamp approve, int author, int resolve, int stat, int type) {
		this.reimbID = id;
		this.amount = amt;
		this.submitted = submit;
		this.author = author;
		this.approved = approve;
		this.resolver = resolve;
		this.statusID = stat;
		this.typeID = type;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getApproved() {
		return approved;
	}

	public void setApproved(Timestamp approved) {
		this.approved = approved;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((approved == null) ? 0 : approved.hashCode());
		result = prime * result + author;
		result = prime * result + reimbID;
		result = prime * result + resolver;
		result = prime * result + statusID;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + typeID;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
			return false;
		if (author != other.author)
			return false;
		if (reimbID != other.reimbID)
			return false;
		if (resolver != other.resolver)
			return false;
		if (statusID != other.statusID)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (typeID != other.typeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", amount=" + amount + ", submitted=" + submitted + ", approved="
				+ approved + ", author=" + author + ", resolver=" + resolver + ", statusID=" + statusID + ", typeID="
				+ typeID + "]";
	}


	
	
	
	
	
}
