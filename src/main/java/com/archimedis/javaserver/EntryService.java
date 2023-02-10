package com.archimedis.javaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
	
	@Autowired
	EntryRepo repo;
	public void initialPostToDB(String UUID, String AccountID) {
		repo.insertInitData(UUID, AccountID); 
	}
	
	public String getEmailID(String UUID) {
		return repo.getData(UUID);
	}

	public void setEmailID(String id, String emailID, String time) {
		repo.insertFinalData(emailID, time,id);
	}
}
