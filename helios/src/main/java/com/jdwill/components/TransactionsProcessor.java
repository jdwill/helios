package com.jdwill.components;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.jdwill.models.IncomeAndExpenseStrings;
import com.jdwill.models.IncomeAndExpenseSummary;
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
	public Map<YearMonth, IncomeAndExpenseSummary> calculateMonthlyIncomesAndExpenses(List<Transaction> transactions);
	
	/**
	 * Converts a map where value contains object with BigDecimals to an object with Strings
	 * so that the $ symbol can be prefixed to them.
	 * @param monthlyIncomesAndExpenses	A map with BigDecimals in the value objects
	 * @return							A map with Strings in the value objects prefixed with $
	 */
	public Map<YearMonth, IncomeAndExpenseStrings> convertIncomeAndExpenseMap(Map<YearMonth, IncomeAndExpenseSummary> monthlyIncomesAndExpenses);
}
