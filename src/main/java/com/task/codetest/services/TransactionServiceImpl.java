package com.task.codetest.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.codetest.models.Transaction;
import com.task.codetest.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getAllTransactions() throws IOException {
		return transactionRepository.getAllTransactions();
	}

}
