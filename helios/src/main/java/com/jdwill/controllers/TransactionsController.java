package com.jdwill.controllers;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdwill.components.TransactionsProcessor;
import com.jdwill.models.CommonArguments;
import com.jdwill.models.IncomeAndExpenseStrings;
import com.jdwill.models.IncomeAndExpenseSummary;
import com.jdwill.models.IncomesAndExpensesByMonth;
import com.jdwill.models.Transaction;
import com.jdwill.models.TransactionsResponse;
import com.jdwill.utilities.SortingUtilities;

/**
 * APIs for accessing a user's transaction details. 
 * @author Jason Williams
 *
 */
@RestController
public class TransactionsController {
	@Autowired
	TransactionsProcessor processor;
	Logger log = Logger.getLogger(TransactionsController.class);

	/**
	 * Returns all a user's transactions
	 * @param restTemplate	A Spring RestTemplate injected by Spring.
	 * @return				A list of the user's transactions.
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/getAllTransactions")
	public List<Transaction> getAllTransactions(RestTemplate restTemplate) {
		log.info("TransactionsController.getAllTransactions() requested");
		return processor.retrieveAllTransactions(restTemplate);
	}
	
	/**
	 * Returns a summary of the user's income and expenses organized by month
	 * @param restTemplate	A Spring RestTemplate injected by Spring.
	 * @return				A JSON representation of the user's expenses 
	 * 						in the form {yyyy-MM: {spent: $nnnn.nn}}
	 */
	@RequestMapping("/getIncomeAndExpensesSummary")
	public IncomesAndExpensesByMonth getIncomeAndExpensesSummary(RestTemplate restTemplate) {
		log.info("TransactionsController.getIncomeAndExpensesSummary() requested");
		List<Transaction> transactions = processor.retrieveAllTransactions(restTemplate);
		Map<YearMonth, IncomeAndExpenseSummary> monthlyIncomesAndExpenses = processor.calculateMonthlyIncomesAndExpenses(transactions);
		Map<YearMonth, IncomeAndExpenseStrings> stringifiedMonthlyIncomesAndExpenses = processor.convertIncomeAndExpenseMap(monthlyIncomesAndExpenses);
		stringifiedMonthlyIncomesAndExpenses = SortingUtilities.sortIncomesAndExpensesMap(stringifiedMonthlyIncomesAndExpenses);
		IncomesAndExpensesByMonth incomesAndExpensesByMonth = new IncomesAndExpensesByMonth();
		incomesAndExpensesByMonth.setIncomesAndExpensesByMonth(stringifiedMonthlyIncomesAndExpenses);
		return incomesAndExpensesByMonth;
	}
	
	@RequestMapping("/getNonDonutIncomeAndExpensesSummary")
	public IncomesAndExpensesByMonth getNonDonutIncomeAndExpensesSummary(RestTemplate restTemplate) {
		log.info("TransactionsController.getNonDonutIncomeAndExpensesSummary() requested");
		List<Transaction> transactions = processor.retrieveAllTransactions(restTemplate);
		//Filter out Donut transactions
		transactions = SortingUtilities.filterTransactions(transactions, Arrays.asList("Krispy Kreme Donuts", "DUNKIN #336784"));
		Map<YearMonth, IncomeAndExpenseSummary> monthlyIncomesAndExpenses = processor.calculateMonthlyIncomesAndExpenses(transactions);
		Map<YearMonth, IncomeAndExpenseStrings> stringifiedMonthlyIncomesAndExpenses = processor.convertIncomeAndExpenseMap(monthlyIncomesAndExpenses);
		stringifiedMonthlyIncomesAndExpenses = SortingUtilities.sortIncomesAndExpensesMap(stringifiedMonthlyIncomesAndExpenses);
		IncomesAndExpensesByMonth incomesAndExpensesByMonth = new IncomesAndExpensesByMonth();
		incomesAndExpensesByMonth.setIncomesAndExpensesByMonth(stringifiedMonthlyIncomesAndExpenses);
		return incomesAndExpensesByMonth;
	}
}