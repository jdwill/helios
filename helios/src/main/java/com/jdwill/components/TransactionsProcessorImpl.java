package com.jdwill.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
