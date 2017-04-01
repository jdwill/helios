package com.jdwill.controllers;

import java.util.Arrays;
import java.util.List;

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
	String url = "https://2016.api.levelmoney.com/api/v2/core/get-all-transactions";

	/**
	 * Returns all a users transactions
	 * @param restTemplate	A Spring RestTemplate injected by Spring.
	 * @return				A list of the user's transactions.
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/getAllTransactions")
	public List<Transaction> getAllTransactions(RestTemplate restTemplate) throws JsonProcessingException {
		//TODO Convert console out statements to Log outputs.
		System.out.println("TransactionsController.getAllTransactions() called...");
		CommonArguments request = new CommonArguments();
		System.out.println("Evaluating request object:");
		System.out.println(request.toString() + "\n");
		//Use Jackson marshaling to get a String representation of the JSON.
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
	    String json = mapper.writeValueAsString(request);
	    //Add the required HTTP headers
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);
		ResponseEntity<TransactionsResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, TransactionsResponse.class);
		System.err.println(response.getBody().getTransactions().get(0).toString());
		return response.getBody().getTransactions();
	}
}