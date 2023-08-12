package com.task.codetest.services;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.task.codetest.models.Transaction;
import com.task.codetest.models.TransactionFilter;
import com.task.codetest.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Page<Transaction> getAllTransactionsFiltered(TransactionFilter transactionFilter, String sortBy,
			String sortOrder, int page, int pageSize) throws IOException {
		try {
			// Get all transaction from source (DataBase or JSON file)
			List<Transaction> transactions = transactionRepository.getAllTransactions();

			List<Transaction> filteredTransactions = transactions.stream()
					.filter(t -> transactionFilter.getAmount() == null
							|| t.getAmount().equals(transactionFilter.getAmount()))
					.filter(t -> transactionFilter.getMerchant() == null
							|| t.getMerchant().equals(transactionFilter.getMerchant()))
					.filter(t -> transactionFilter.getStatus() == null
							|| t.getStatus().equals(transactionFilter.getStatus()))
					.collect(Collectors.toList());

			// Sort Data with selected attribute

			Comparator<Transaction> comparator = Comparator.comparing(Transaction::getDate);

			switch (sortBy) {
			case "amount":
				comparator = Comparator.comparing(Transaction::getAmount);
				break;
			case "status":
				comparator = Comparator.comparing(Transaction::getStatus);
				break;
			case "merchant":
				comparator = Comparator.comparing(Transaction::getMerchant);
				break;
			default:
				break;
			}

			// Set order of Sort for the filtered data

			if ("desc".equalsIgnoreCase(sortOrder)) {
				comparator = comparator.reversed();
			}
			filteredTransactions.sort(comparator);

			// Convert List to Page

			int startIndex = (page - 1) * pageSize;
			int endIndex = Math.min(startIndex + pageSize, filteredTransactions.size());

			List<Transaction> paginatedTransactions = filteredTransactions.subList(startIndex, endIndex);

			PageRequest pageRequest = PageRequest.of(page - 1, pageSize,
					Sort.by(Sort.Direction.fromString(sortOrder), sortBy));

			return new PageImpl<>(paginatedTransactions, pageRequest, filteredTransactions.size());
		} catch (Exception e) {
			return null;
		}
	}

}
