package com.ing.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.TransactionRequest;
import com.ing.bank.dto.TransactionResponse;
import com.ing.bank.model.Transaction;
import com.ing.bank.model.UserAccount;
import com.ing.bank.repository.TransactionRepository;
import com.ing.bank.repository.UserRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
    TransactionRepository transactionRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public TransactionResponse createTransaction(TransactionRequest request) {
	UserAccount user=userRepository.findById(request.getUserId()).get();
	UserAccount user2=new UserAccount();
	TransactionResponse response= new TransactionResponse();
		Transaction t1= new Transaction();
		Transaction t2= new Transaction();
		t1.setFromAccount(user.getAccountNumber());
		t1.setAmount(request.getAmount());
		t1.setType("Debit");
		t1.setUserId(request.getUserId());
		t1.setBalance(user.getBalance()-request.getAmount());
		t1.setToAccount(request.getToAccount());
		
		transactionRepository.save(t1);
		user.setBalance(t1.getBalance());
		
		user2=userRepository.getUser(request.getToAccount());
		userRepository.save(user);
		t2.setToAccount(request.getToAccount());
		t2.setAmount(request.getAmount());
		t2.setType("Cridit");
		t2.setUserId(user2.getUserId());
		t2.setBalance(request.getAmount()+user2.getBalance());
		user2.setBalance(t2.getBalance());
		userRepository.save(user2);
		t2.setFromAccount(user.getAccountNumber());
		transactionRepository.save(t2);
		response.setAmount(request.getAmount());
		response.setStatus("Transaction Success...");
		response.setTransactionType("Debit");
		return response;
	}

}
