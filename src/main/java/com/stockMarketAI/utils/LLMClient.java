package com.stockMarketAI.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;

@Component
public class LLMClient {

	private RestTemplate restTemplate = new RestTemplate();

	public String generateResponse(String companyName, String apiKey, String apiUrl, String prompt) throws Exception {

		Map<String, Object> requestBody = new HashMap<>();
		Map<String, Object> part = new HashMap<>();
		part.put("text", getPrompt(prompt, companyName));

//		System.out.println(getPrompt(prompt, companyName));

		Map<String, Object> content = new HashMap<>();
		content.put("parts", new Object[] { part });

		requestBody.put("contents", new Object[] { content });

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> generationConfig = new HashMap<>();
		generationConfig.put("maxOutputTokens", 20000);  // ← THIS FIXES TRUNCATION!
		generationConfig.put("temperature", 0.4);       // Consistency
		generationConfig.put("topK", 40);
		generationConfig.put("topP", 0.95);
		
		requestBody.put("generationConfig", generationConfig);

		HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(requestBody, headers);

		String fullUrl = apiUrl + "?key=" + apiKey;
		ResponseEntity<String> response;
		try {
			response = restTemplate.postForEntity(fullUrl, request, String.class);
			System.out.println(response.getBody());
		} catch (HttpServerErrorException ex) {
			throw new Exception(ex.getStatusCode() + " " + ex.getMessage());
		}
		return response.getBody();

	}

	private String getPrompt(String prompt, String companyName) {
		return prompt.replace("<COMPANY_NAME>", companyName);
	}

}
