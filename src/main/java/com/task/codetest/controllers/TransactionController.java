package com.task.codetest.controllers;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.codetest.models.Transaction;
import com.task.codetest.models.TransactionFilter;
import com.task.codetest.services.TransactionService;

@RestController
@RequestMapping("/v1/api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	/**
	 * 
	 * @param merchant  : Name of the merchant to fetch with
	 * @param amount    : Amount of the transaction to fetch with
	 * @param status    : Status of the transaction to fetch with
	 * @param sortBy    : Attribute to sort with
	 * @param sortOrder : Order of sorting data ; Ascending by default
	 * @param page      : Number of the desired data
	 * @param pageSize  : Number of records per page
	 * @return : Reponse Entity which contains the status of the response and the
	 *         body
	 */
	@GetMapping
	public ResponseEntity<?> getTransactions(@RequestParam(name = "merchant", required = false) String merchant,
			@RequestParam(name = "amount", required = false) BigDecimal amount,
			@RequestParam(name = "status", required = false) String status,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy,
			@RequestParam(name = "sortOrder", required = false, defaultValue = "asc") String sortOrder,
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") int pageSize) {

		// Initialize the Transaction Filter Object to apply it later for filtering

		TransactionFilter transactionFilter = new TransactionFilter(amount, merchant, status);

		try {
			Page<Transaction> filteredTransactions = transactionService.getAllTransactionsFiltered(transactionFilter,
					sortBy, sortOrder, page, pageSize);
			if (filteredTransactions != null && !filteredTransactions.isEmpty())
				return new ResponseEntity<Page<Transaction>>(filteredTransactions, HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.toString(), HttpStatus.EXPECTATION_FAILED);
		}
	}

}
