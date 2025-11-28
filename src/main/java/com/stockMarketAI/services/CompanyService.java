package com.stockMarketAI.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockMarketAI.objects.AnalyseCompanyObject;
import com.stockMarketAI.objects.Root;
import com.stockMarketAI.objects.StockAnalysisResponse;
import com.stockMarketAI.utils.LLMClient;
import com.stockMarketAI.utils.LLMResponseParser;
import com.stockMarketAI.utils.PromptLoader;

@Service
public class CompanyService {

	private PromptLoader promptLoader;

	@Value("${stockmarketai.gemini.api.key}")
	private String apiKey;

	@Value("${stockmarketai.gemini.api.url.gemini.pro}")
	private String geminiProApiUrl;

	@Value("${stockmarketai.gemini.api.url.gemini.flash}")
	private String geminiFlashApiUrl;

	private final LLMClient client;
	private final ObjectMapper objectMapper;

	public CompanyService(LLMClient client, PromptLoader promptLoader, ObjectMapper objectMapper) {
		this.client = client;
		this.promptLoader = promptLoader;
		this.objectMapper = objectMapper;
	}

	public StockAnalysisResponse getCompanyAnalysis(AnalyseCompanyObject company) throws Exception {
		final String name = company.getCompanyName();
		String rootString = client.generateResponse(name, apiKey, geminiProApiUrl, promptLoader.getPrompt());
//		System.out.println("rootString = "+rootString);

		String cleanJson = LLMResponseParser.extractJsonFromLLMResponse(rootString);
//		System.out.println("cleanJson = "+cleanJson);
		
		// Step 1: After extraction, print fully parsed JsonNode:
		JsonNode node = objectMapper.readTree(cleanJson);
//		System.out.println("Technical JsonNode: " + node.get("technical"));

		// Step 2: Map to POJO:
		StockAnalysisResponse res = objectMapper.readValue(cleanJson, StockAnalysisResponse.class);

		// Step 3: Print POJO field:
//		System.out.println("Technical field in POJO: " + res.getTechnical());

//		StockAnalysisResponse res = objectMapper.readValue(cleanJson, StockAnalysisResponse.class);
		return res;
//		Root rootObj = getRootObj(cleanJson);
//		StockAnalysisResponse stockAObj = getStockAObject(rootObj);
//		return stockAObj;
	}

	public Root getFullResponse(AnalyseCompanyObject company) throws Exception {
		final String name = company.getCompanyName();
		String rootString = client.generateResponse(name, apiKey, geminiProApiUrl, promptLoader.getPrompt());
		Root rootObj = getRootObj(rootString);
		return rootObj;
	}

	private StockAnalysisResponse getStockAObject(Root rootObj) throws JsonMappingException, JsonProcessingException {
		String rawAnalysisString = rootObj.getCandidates().get(0).getContent().getParts().get(0).getText();
		String cleanedAnalysisString = rawAnalysisString.replace("```json", "").replace("```", "").trim();

		return objectMapper.readValue(cleanedAnalysisString, StockAnalysisResponse.class);
	}

	private Root getRootObj(String str) throws JsonMappingException, JsonProcessingException {
		Root root = objectMapper.readValue(str, Root.class);
		return root;
	}

	public String getPromptFromFile() {
		return promptLoader.getPrompt();
	}

}
