package com.task.codetest.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import com.task.codetest.controllers.TransactionController;
import com.task.codetest.models.Transaction;
import com.task.codetest.models.TransactionFilter;
import com.task.codetest.services.TransactionService;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionService transactionService;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		PageRequest pageRequest = PageRequest.of(1, 5, Sort.by("id"));
		Page<Transaction> page = new PageImpl<>(transactionList, pageRequest, transactionList.size());

		when(transactionService.getAllTransactionsFiltered(new TransactionFilter(), null, null, 0, 0)).thenReturn(page);
		this.mockMvc.perform(get("/v1/api")).andDo(print()).andExpect(status().is2xxSuccessful());

	}

}
