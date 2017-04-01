package com.jdwill.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.time.YearMonth;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdwill.models.CommonArguments;
import com.jdwill.models.IncomeAndExpenseStrings;
import com.jdwill.models.IncomeAndExpenseSummary;
import com.jdwill.models.IncomesAndExpensesByMonth;
import com.jdwill.models.Transaction;
import com.jdwill.models.TransactionsResponse;

@Component
public class TransactionsProcessorImpl implements TransactionsProcessor {
	String getAllTransactionsUrl = "https://2016.api.levelmoney.com/api/v2/core/get-all-transactions";
	Logger log = Logger.getLogger(TransactionsProcessorImpl.class);

	@Override
	public List<Transaction> retrieveAllTransactions(RestTemplate restTemplate) {
		List<Transaction> transactions = null;
		log.info("TransactionsController.getAllTransactions() called...");
		try {
			CommonArguments request = new CommonArguments();
			//Use Jackson marshaling to get a String representation of the JSON.
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
			String json = mapper.writeValueAsString(request);
			log.debug("Json for LevelMoney.GetAllTransactions is: " + json);
			//Add the required HTTP headers
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(json, headers);
			ResponseEntity<TransactionsResponse> response = restTemplate.exchange(getAllTransactionsUrl, HttpMethod.POST, entity, TransactionsResponse.class);
			log.debug("Received transactions; first transaction is: " + response.getBody().getTransactions().get(0).toString());
			transactions = response.getBody().getTransactions();
		}
		catch(JsonProcessingException e) {
			log.error("An exception occured while retrieving user's transactions (TransactionsProcessorImpl.retrieveAllTransactions)...", e);
			transactions = new ArrayList<Transaction>(Arrays.asList(new Transaction()));
		}
		return transactions;
	}

	@Override
	public Map<YearMonth, IncomeAndExpenseSummary> calculateMonthlyIncomesAndExpenses(List<Transaction> transactions) {
		int year = -1;
		int month = -1;
		Map<YearMonth, IncomeAndExpenseSummary> monthlyIncomesAndExpenses = new HashMap<YearMonth, IncomeAndExpenseSummary>();
		for(Transaction transaction : transactions) {
			String transactionTime = transaction.getTransaction_time().substring(0, 7);
			YearMonth yearMonth = (transactionTime != null) ? YearMonth.parse(transactionTime) : null;
			Double amount = transaction.getAmount();
			monthlyIncomesAndExpenses = addAmmount(monthlyIncomesAndExpenses, yearMonth, amount);
		}
		//IncomesAndExpensesByMonth incomesAndExpensesByMonth = new IncomesAndExpensesByMonth();
		//incomesAndExpensesByMonth.setIncomesAndExpensesByMonth(monthlyIncomesAndExpenses);
		return monthlyIncomesAndExpenses;
	}
	
	private Map<YearMonth, IncomeAndExpenseSummary> addAmmount(Map<YearMonth, IncomeAndExpenseSummary> monthlyIncomesAndExpenses, YearMonth yearMonth, Double amount) {
		if(yearMonth != null && amount != null) {
			BigDecimal convertedAmount = convertCentocents(amount).abs();
			//If the key already exists, update the income or expense
			if(monthlyIncomesAndExpenses.containsKey(yearMonth)) {
				IncomeAndExpenseSummary summary = monthlyIncomesAndExpenses.get(yearMonth);
				//If amount is income
				if(amount >= 0) {
					BigDecimal income = summary.getIncome().add(convertedAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
					summary.setIncome(income);
				}
				//If amount is an expense 
				else {
					BigDecimal spent = summary.getSpent().add(convertedAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
					summary.setSpent(spent);
				}
				monthlyIncomesAndExpenses.put(yearMonth, summary);
			}
			//If the key does not yet exist, add it and insert the dependent values
			else {
				IncomeAndExpenseSummary summary;
				//If amount is income
				if(amount >= 0) {
					summary = new IncomeAndExpenseSummary(
							new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP),
							convertedAmount
							);
				}
				//If amount is an expense
				else {
					summary = new IncomeAndExpenseSummary(
							convertedAmount,
							new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP)
							);
				}
				//Add the new monthly tracking values to the collection
				monthlyIncomesAndExpenses.put(yearMonth, summary);
			}
		}
		return monthlyIncomesAndExpenses;
	}
	
	private BigDecimal convertCentocents(Double amount) {
		BigDecimal convertedAmount = new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
		convertedAmount = convertedAmount.divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);
		return convertedAmount;
	}
	
	@Override
	public Map<YearMonth, IncomeAndExpenseStrings> convertIncomeAndExpenseMap(Map<YearMonth, IncomeAndExpenseSummary> monthlyIncomesAndExpenses) {
		Map<YearMonth, IncomeAndExpenseStrings> convertedMap = new HashMap<YearMonth, IncomeAndExpenseStrings>();
		Iterator<Entry<YearMonth, IncomeAndExpenseSummary>> iterator = monthlyIncomesAndExpenses.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<YearMonth, IncomeAndExpenseSummary> entry = iterator.next();
			IncomeAndExpenseSummary incomeAndExpense = entry.getValue();
			String spent = "$" + incomeAndExpense.getSpent().toString();
			String income = "$" + incomeAndExpense.getIncome().toString();
			convertedMap.put(entry.getKey(), new IncomeAndExpenseStrings(spent, income));
		}
		return convertedMap;
	}
}