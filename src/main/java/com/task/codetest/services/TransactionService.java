package com.task.codetest.services;

import java.io.IOException;
import java.util.List;

import com.task.codetest.models.Transaction;

public interface TransactionService {

	public List<Transaction> getAllTransactions() throws IOException;

}
