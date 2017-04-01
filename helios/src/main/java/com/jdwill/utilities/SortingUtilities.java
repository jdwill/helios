package com.jdwill.utilities;

import java.time.YearMonth;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jdwill.models.IncomeAndExpenseStrings;
import com.jdwill.models.Transaction;

public class SortingUtilities {

	public static Map<YearMonth, IncomeAndExpenseStrings> sortIncomesAndExpensesMap(Map<YearMonth, IncomeAndExpenseStrings> incomesAndExpenses) {
		Map<YearMonth, IncomeAndExpenseStrings> sortedIncomesAndExpenses = new LinkedHashMap<YearMonth, IncomeAndExpenseStrings>();
		incomesAndExpenses.entrySet().stream()
        .sorted(Map.Entry.<YearMonth, IncomeAndExpenseStrings>comparingByKey())
        .forEachOrdered(x -> sortedIncomesAndExpenses.put(x.getKey(), x.getValue()));
		return sortedIncomesAndExpenses;
	}
	
	public static List<Transaction> filterTransactions(List<Transaction> transactions, List<String> transactionsToRemove) {
		Logger log = Logger.getLogger(SortingUtilities.class);
		log.debug("SortingUtilities.filterTransactions()");
		Iterator<Transaction> iterator = transactions.iterator();
		while(iterator.hasNext()) {
			Transaction transaction = iterator.next();
			for(String transactionName : transactionsToRemove) {
				if(transaction.getRaw_merchant().contains(transactionName)) {
					log.debug("Removing transaction: " + transaction.getRaw_merchant());
					iterator.remove();
					break;
				}
			}
		}
		return transactions;
	}
}