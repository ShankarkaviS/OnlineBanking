package com.ing.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.bank.model.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount,Long> {
	
	@Query(value="select * from user_account where account_number=?",nativeQuery=true)
	public UserAccount getUser(String account);
	

}
