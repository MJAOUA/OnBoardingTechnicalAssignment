package com.task.codetest.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@EntityScan
public class Transaction {

	private Long id;
	private BigDecimal amount;
	private String merchant;
	private String status;
	private OffsetDateTime date;

}
