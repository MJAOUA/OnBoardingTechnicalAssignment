package com.task.codetest.repositories;

import java.io.IOException;
import java.util.List;

import com.task.codetest.models.Transaction;

public interface TransactionRepository {
	/**
	 * Get all transaction from source "DataBase or JSON File"
	 * 
	 * @return List of Transactions
	 * @throws IOException
	 */
	List<Transaction> getAllTransactions() throws IOException;
}
