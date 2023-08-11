package com.task.codetest.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class Transaction {

	private Long id;
	private BigDecimal amount;
	private String merchant;
	private String status;
	private Date date;

}
