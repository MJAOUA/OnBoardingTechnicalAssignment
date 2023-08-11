package com.task.codetest.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.codetest.models.Transaction;
import com.task.codetest.services.TransactionService;

@RestController
@RequestMapping("/v1/api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping("/getAllTransactions")
	public List<Transaction> getAllTransactions(@RequestParam(required = false) BigDecimal amount,
			@RequestParam(required = false) String merchant, @RequestParam(required = false) String status)
			throws IOException {

		return transactionService.getAllTransactions();
	}

}
