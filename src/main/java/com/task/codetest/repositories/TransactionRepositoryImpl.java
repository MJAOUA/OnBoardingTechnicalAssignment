package com.task.codetest.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.codetest.models.Transaction;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@Override
	public List<Transaction> getAllTransactions() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ClassPathResource resource = new ClassPathResource("transactionsMock.json");
		Transaction[] transactionsArray = objectMapper.readValue(resource.getInputStream(), Transaction[].class);
		return Arrays.asList(transactionsArray);
	}

}
