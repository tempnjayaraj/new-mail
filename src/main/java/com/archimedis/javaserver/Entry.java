package com.archimedis.javaserver;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Entry {
	@Id
	private int entry_ID;
    private String UUID;
    private String time;
    private String accountID;
    private String emailID;
	public int getEntry_ID() {
		return entry_ID;
	}
	public void setEntry_ID(int entry_ID) {
		this.entry_ID = entry_ID;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public Entry(int entry_ID, String uUID, String time, String accountID, String emailID) {
		super();
		this.entry_ID = entry_ID;
		UUID = uUID;
		this.time = time;
		this.accountID = accountID;
		this.emailID = emailID;
	}
    
	public Entry() {
		
	}
}
