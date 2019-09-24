package com.ing.bank.service;

import com.ing.bank.dto.TransactionRequest;
import com.ing.bank.dto.TransactionResponse;

public interface TransactionService {

	public TransactionResponse createTransaction(TransactionRequest request);
	
}
