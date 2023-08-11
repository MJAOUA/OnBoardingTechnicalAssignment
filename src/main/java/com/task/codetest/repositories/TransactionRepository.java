package com.task.codetest.repositories;

import java.io.IOException;
import java.util.List;

import com.task.codetest.models.Transaction;

public interface TransactionRepository {

	List<Transaction> getAllTransactions() throws IOException;
}
