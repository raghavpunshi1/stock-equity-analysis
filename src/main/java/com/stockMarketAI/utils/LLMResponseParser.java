package com.stockMarketAI.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Utility to parse LLM responses with markdown code block wrappers
 * 
 * PROBLEM: Gemini wraps JSON in ```json and ``` markers
 * SOLUTION: Extract JSON from markdown wrapper before deserializing
 * 
 * Example LLM response:
 * ```json
 * {
 *   "company_name": "Tata Motors",
 *   ...
 * }
 * ```
 * 
 * @author Fix for JSON Parsing
 * @version 1.0
 */
@Component
public class LLMResponseParser {
    
    private static final Logger logger = LoggerFactory.getLogger(LLMResponseParser.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Parse LLM response by extracting JSON from markdown code block
     * 
     * @param rawResponse Raw response from Gemini API (contains candidates array)
     * @return Extracted JSON string without markdown wrappers
     * @throws Exception if parsing fails
     */
    public static String extractJsonFromLLMResponse(String rawResponse) throws Exception {
        try {
            // Parse the Gemini API response structure
            JsonNode responseNode = mapper.readTree(rawResponse);
            
            // Navigate to the text content: response.candidates[0].content.parts[0].text
            JsonNode textNode = responseNode
                .get("candidates")
                .get(0)
                .get("content")
                .get("parts")
                .get(0)
                .get("text");
            
            String textContent = textNode.asText();
            
            // Extract JSON from markdown code block
            String jsonString = extractJsonFromMarkdown(textContent);
            
            return jsonString;
            
        } catch (Exception e) {
            logger.error("Failed to extract JSON from LLM response: " + e.getMessage());
            throw new Exception("Error parsing LLM response: " + e.getMessage(), e);
        }
    }
    
    /**
     * Extract JSON from markdown code block
     * 
     * Input:  ```json\n{...}\n```
     * Output: {...}
     * 
     * @param markdownText Text containing markdown code block
     * @return Clean JSON string
     */
    private static String extractJsonFromMarkdown(String markdownText) {
        String result = markdownText;
        
        // Remove leading ```json or ```
        result = result.replaceAll("^\\s*```\\s*(json)?\\s*\\n?", "");
        
        // Remove trailing ```
        result = result.replaceAll("\\n?\\s*```\\s*$", "");
        
        // Trim whitespace
        result = result.trim();
        
        logger.debug("Extracted JSON from markdown: " + result.substring(0, Math.min(100, result.length())) + "...");
        
        return result;
    }
}
