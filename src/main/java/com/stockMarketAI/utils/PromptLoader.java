package com.stockMarketAI.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class PromptLoader {
	
	@Value("classpath:GeminiSuperPrompt.txt")
	private Resource promptFile;
	
	private String prompt;

	@PostConstruct
	public void init() throws IOException {
		this.prompt = promptFile.getContentAsString(StandardCharsets.UTF_8);
	}
	
	public String getPrompt() {
		return prompt;
	}
}
