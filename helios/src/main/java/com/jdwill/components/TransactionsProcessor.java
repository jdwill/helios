package com.jdwill.components;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.jdwill.models.IncomesAndExpensesByMonth;
import com.jdwill.models.Transaction;

public interface TransactionsProcessor {

	/**
	 * Retrieves all the user's available transactions from LevelMoney GetAllTransactions API.
	 * @param restTemplate	A Spring RestTemplate that will be used to call LevelMoney API.
	 * @return				A list of all the user's available transactions.
	 */
	public List<Transaction> retrieveAllTransactions(RestTemplate restTemplate);
	
	/**
	 * Sorts the user's transactions and reports the results in terms of income and expenses by month.
	 * @return
	 */
	public IncomesAndExpensesByMonth calculateMonthlyIncomesAndExpenses(List<Transaction> transactions);
}
