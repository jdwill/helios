package com.jdwill.controllers;

import java.util.Arrays;
import java.util.List;

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
import com.jdwill.models.Transaction;
import com.jdwill.models.TransactionsResponse;

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
	 * Returns all a users transactions
	 * @param restTemplate	A Spring RestTemplate injected by Spring.
	 * @return				A list of the user's transactions.
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/getAllTransactions")
	public List<Transaction> getAllTransactions(RestTemplate restTemplate) {
		log.info("TransactionsController.getAllTransactions() requested");
		return processor.retrieveAllTransactions(restTemplate);
	}
	
	@RequestMapping("/getIncomeAndExpensesSummary")
	public List getIncomeAndExpensesSummary(RestTemplate restTemplate) {
		log.info("TransactionsController.getIncomAndExpensesSummary() requested");
		List<Transaction> transactions = processor.retrieveAllTransactions(restTemplate);
		return null;
	}
}