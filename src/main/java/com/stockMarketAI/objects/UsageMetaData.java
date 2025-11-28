package com.stockMarketAI.objects;

import java.util.List;

public class UsageMetaData {
    private int promptTokenCount;
    private int candidatesTokenCount;
    private int totalTokenCount;
    private List<TokensDetails> promptTokensDetails;
    private List<TokensDetails> cacheTokensDetails;
    private int thoughtsTokenCount;

    public int getPromptTokenCount() {
        return promptTokenCount;
    }

    public void setPromptTokenCount(int promptTokenCount) {
        this.promptTokenCount = promptTokenCount;
    }

    public int getCandidatesTokenCount() {
        return candidatesTokenCount;
    }

    public void setCandidatesTokenCount(int candidatesTokenCount) {
        this.candidatesTokenCount = candidatesTokenCount;
    }

    public int getTotalTokenCount() {
        return totalTokenCount;
    }

    public void setTotalTokenCount(int totalTokenCount) {
        this.totalTokenCount = totalTokenCount;
    }

    public List<TokensDetails> getPromptTokensDetails() {
        return promptTokensDetails;
    }

    public void setPromptTokensDetails(List<TokensDetails> promptTokensDetails) {
        this.promptTokensDetails = promptTokensDetails;
    }

    public List<TokensDetails> getCacheTokensDetails() {
        return cacheTokensDetails;
    }

    public void setCacheTokensDetails(List<TokensDetails> cacheTokensDetails) {
        this.cacheTokensDetails = cacheTokensDetails;
    }

    public int getThoughtsTokenCount() {
        return thoughtsTokenCount;
    }

    public void setThoughtsTokenCount(int thoughtsTokenCount) {
        this.thoughtsTokenCount = thoughtsTokenCount;
    }
}
