package com.task.codetest.services;

import java.io.IOException;

import org.springframework.data.domain.Page;

import com.task.codetest.models.Transaction;
import com.task.codetest.models.TransactionFilter;

public interface TransactionService {

	/**
	 * 
	 * @param transactionFilter : Object used to set filter attributes
	 * @param sortBy            : Attribute to sort with
	 * @param sortOrder         : Order of sorting data ; Ascending by default
	 * @param page              : Number of the desired data
	 * @param pageSize          : Number of records per page
	 * @return : A page of transactions
	 */
	public Page<Transaction> getAllTransactionsFiltered(TransactionFilter transactionFilter, String sortBy,
			String sortOrder, int page, int pageSize) throws IOException;
}
