package com.jdwill.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jdwill.models.IncomeAndExpenseStrings;
import com.jdwill.models.MinimumTransactionData;
import com.jdwill.models.Transaction;
import com.jdwill.models.TransactionDate;

public class SortingUtilities {

	public static Map<String, IncomeAndExpenseStrings> sortIncomesAndExpensesMap(Map<String, IncomeAndExpenseStrings> incomesAndExpenses) {
		Map<String, IncomeAndExpenseStrings> sortedIncomesAndExpenses = new LinkedHashMap<String, IncomeAndExpenseStrings>();
		incomesAndExpenses.entrySet().stream()
        .sorted(Map.Entry.<String, IncomeAndExpenseStrings>comparingByKey())
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
	
	public static List<TransactionDate> getCreditCardPayments(List<Transaction> transactions) {
		Logger log = Logger.getLogger(SortingUtilities.class);
		log.info("SortingUtilities.getCreditCardPayments().  Searching for credit card transactions...");
		final long dayInMiliseconds = (24 * 60 * 60 * 1000);
		List<TransactionDate> creditCardPaymentTransactions = new ArrayList<TransactionDate>();
		List<TransactionDate> transactionDates = convertTransactionType(transactions);
		Iterator<TransactionDate> iterator = transactionDates.iterator();
		while(iterator.hasNext()) {
			TransactionDate transaction = iterator.next();
			Iterator<TransactionDate> candidateIterator = transactionDates.iterator();
			while(candidateIterator.hasNext()) {
				TransactionDate candidate = candidateIterator.next();
				if(!candidate.equals(transaction)) {
					double amountSum = candidate.getAmount() + transaction.getAmount();
					if(amountSum == 0d) {
						long candidateTime = candidate.getTransaction_time().getTime();
						long transactionTime = transaction.getTransaction_time().getTime();
						long timeDifference = Math.abs(candidateTime - transactionTime);
						if(timeDifference <= dayInMiliseconds) {
							//This is a credit card payment
							creditCardPaymentTransactions.add(transaction);
							creditCardPaymentTransactions.add(candidate);
							break;
						}
					}
				}
			}
		}
		return creditCardPaymentTransactions;
	}
	
	public static List<TransactionDate> convertTransactionType(List<Transaction> transactions) {
		Logger log = Logger.getLogger(SortingUtilities.class);
		List<TransactionDate> transactionDates = new ArrayList<TransactionDate>();
		for(Transaction transaction : transactions) {
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(transaction.getTransaction_time());
				TransactionDate transactionDate = new TransactionDate(transaction.getTransaction_id(), transaction.getAccount_id(), 
						transaction.getRaw_merchant(), transaction.getMerchant(), transaction.getIs_pending(), 
						date, transaction.getAmount(), transaction.getPrevious_transaction_id(), 
						transaction.getCategorization(), transaction.getMemo_only_for_testing(), transaction.getClear_date());
				transactionDates.add(transactionDate);
			} catch (ParseException e) {
				log.error("Error parsing String to Date.", e);
			}
		}
		return transactionDates;
	}
	
	public static List<Transaction> revertTransactionType(List<TransactionDate> transactionDates) {
		Logger log = Logger.getLogger(SortingUtilities.class);
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(TransactionDate transactionDate : transactionDates) {
			//Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(transaction.getTransaction_time());
			Date date = transactionDate.getTransaction_time();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			String dateString = dateFormat.format(date);
			Transaction transaction = new Transaction(transactionDate.getTransaction_id(), transactionDate.getAccount_id(), 
					transactionDate.getRaw_merchant(), transactionDate.getMerchant(), transactionDate.getIs_pending(), 
					dateString, transactionDate.getAmount(), transactionDate.getPrevious_transaction_id(), 
					transactionDate.getCategorization(), transactionDate.getMemo_only_for_testing(), transactionDate.getClear_date());
			transactions.add(transaction);
		}
		return transactions;
	}
	
	public static List<MinimumTransactionData> minimizeTransactionList(List<Transaction> transactions) {
		List<MinimumTransactionData> miniTransactions = new ArrayList<MinimumTransactionData>();
		for(Transaction transaction : transactions) {
			MinimumTransactionData miniTransaction = new MinimumTransactionData(transaction.getTransaction_id(), 
					transaction.getMerchant(), transaction.getTransaction_time(), transaction.getAmount(), transaction.getCategorization());
			miniTransactions.add(miniTransaction);
		}
		return miniTransactions;
	}
	
	public static int getYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year;
	}
	
	public static int getMonth() {
		int month = Calendar.getInstance().get(Calendar.MONTH);
		month++;
		return month;
	}
}