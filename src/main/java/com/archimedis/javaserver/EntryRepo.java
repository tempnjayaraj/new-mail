package com.archimedis.javaserver;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EntryRepo extends CrudRepository<Entry, String> {
	/**
	 * CustomQuery getUsers Parameter: user_name, user_password Return type: User
	 * Explanation: This method gets data from database table 'users'
	 * 
	 */
	@Transactional
	@Modifying
	@Query(value = "insert into entry (uuid,accountid) values (:uid,:acntid)", nativeQuery = true)
	public void insertInitData(@Param(value = "uid") String UUID, @Param(value = "acntid") String accountID);

	@Query(value = "select emailid from entry where uuid =  :uid", nativeQuery = true)
	public String getData(@Param(value = "uid") String UUID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update entry set emailid = :emaild ,time = :tim where uuid = :id", nativeQuery = true)
	public void insertFinalData(@Param(value = "emaild") String emailid, @Param(value = "tim") String time,
			@Param(value = "id") String uuid);

}