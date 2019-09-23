package com.ing.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.Util.RandomGenerator;
import com.ing.bank.dto.UserRequest;
import com.ing.bank.dto.UserResponse;
import com.ing.bank.exception.UserNotFoundException;
import com.ing.bank.model.UserAccount;
import com.ing.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserResponse createUser(UserRequest user) {
		UserAccount account= new UserAccount();
		
		String name=RandomGenerator.getRandomNumber(user.getUserName(), user.getGmail(), user.getPhoneNumber());
		account.setAccountNumber(name);	
		account.setGmail(user.getGmail());
		account.setPassword(RandomGenerator.generatePIN(12456));
		account.setMobile(user.getPhoneNumber());
		account.setPlace(user.getPlace());
		account.setUserName(user.getUserName());
		UserResponse response= new UserResponse();
		
		account=userRepository.save(account);
		if(account!=null)
		{
			response.setName(user.getUserName());
			response.setMobile(user.getPhoneNumber());
			response.setPlace(user.getPlace());	
			response.setMessage("Account Created Success...");
		
			return response;
		}else
		{
			 throw new  UserNotFoundException("Invalid Input/Account Creation Failed");
		}
			
	}

}
