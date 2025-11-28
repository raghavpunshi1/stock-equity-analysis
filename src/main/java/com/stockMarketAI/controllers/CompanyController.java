package com.stockMarketAI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockMarketAI.objects.AnalyseCompanyObject;
import com.stockMarketAI.services.CompanyService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/stockMarketAI/")
public class CompanyController {
	
	private final CompanyService companyService;
	
	@Autowired
	public CompanyController (CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping("/health")
	public String health() {
		return "Stock Market AI is up...";
	}
	
	@RateLimiter(name = "api", fallbackMethod = "rateLimitFallback")
	@PostMapping("/analyseCompany")
	public Object getCompanyAnalysis(@RequestBody AnalyseCompanyObject companyObj) throws Exception {
		return companyService.getCompanyAnalysis(companyObj);
	}
	
	@RateLimiter(name = "api", fallbackMethod = "rateLimitFallback")
	@PostMapping("/LLMResponse")
	public Object getFullResponse(@RequestBody AnalyseCompanyObject companyObj) throws Exception {
		return companyService.getFullResponse(companyObj);
	}
	
	@RateLimiter(name = "api", fallbackMethod = "rateLimitFallback")
	@GetMapping("/prompt")
	public String getPrompt() {
		return companyService.getPromptFromFile();
	}
	

}
