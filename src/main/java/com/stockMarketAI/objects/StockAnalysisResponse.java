//package com.stockMarketAI.objects;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.Serializable;
//
///**
// * Enterprise-Grade Equity Analysis Response v3.5
// * Handles both flat and nested JSON structures with multi-location fallback support
// * Thread-safe and production-ready
// * 
// * UPDATED v3.5: Added @JsonIgnore to all helper methods to prevent duplicate keys in JSON output
// * - Helper methods are for programmatic access only (not serialized to JSON)
// * - Only actual @JsonProperty fields are serialized
// * - Eliminates duplicate keys like company_name vs companyName
// * 
// * @author AI Equity Analyst
// * @version 3.5
// * @since 2025-11-23
// */
//public class StockAnalysisResponse implements Serializable {
//    
//    private static final long serialVersionUID = 5L;
//    
//    // ==================== ROOT LEVEL STRING FIELDS ====================
//    
//    @JsonProperty("company_name")
//    private String company_name;
//    
//    @JsonProperty("ticker")
//    private String ticker;
//    
//    @JsonProperty("analysis_date")
//    private String analysis_date;
//    
//    @JsonProperty("sector")
//    private String sector;
//    
//    @JsonProperty("company_position")
//    private String company_position;
//    
//    @JsonProperty("data_source")
//    private String data_source;
//    
//    @JsonProperty("data_staleness_warning")
//    private String data_staleness_warning;
//    
//    @JsonProperty("this_stock_relative_valuation")
//    private String this_stock_relative_valuation;
//    
//    // ==================== ROOT LEVEL NUMERIC FIELDS ====================
//    
//    @JsonProperty("peer_median_pe")
//    private Double peer_median_pe;
//    
//    // ==================== NESTED COMPLEX OBJECTS (JsonNode) ====================
//    
//    @JsonProperty("analysis_metadata")
//    private JsonNode analysis_metadata;
//    
//    @JsonProperty("company_identification")
//    private JsonNode company_identification;
//    
//    @JsonProperty("stock_price")
//    private JsonNode stock_price;
//    
//    @JsonProperty("market_cap")
//    private JsonNode market_cap;
//    
//    @JsonProperty("shares_outstanding")
//    private JsonNode shares_outstanding;
//    
//    @JsonProperty("financial_metrics")
//    private JsonNode financial_metrics;
//    
//    @JsonProperty("debt_analysis")
//    private JsonNode debt_analysis;
//    
//    @JsonProperty("valuation")
//    private JsonNode valuation;
//    
//    @JsonProperty("competitor_comparison")
//    private JsonNode competitor_comparison;
//    
//    @JsonProperty("technical")
//    private JsonNode technical;
//    
//    @JsonProperty("recent_developments")
//    private JsonNode recent_developments;
//    
//    @JsonProperty("analyst_consensus")
//    private JsonNode analyst_consensus;
//    
//    @JsonProperty("fair_value")
//    private JsonNode fair_value;
//    
//    @JsonProperty("scenarios")
//    private JsonNode scenarios;
//    
//    @JsonProperty("investment_decision")
//    private JsonNode investment_decision;
//    
//    @JsonProperty("action_plan")
//    private JsonNode action_plan;
//    
//    @JsonProperty("confidence_metrics")
//    private JsonNode confidence_metrics;
//    
//    @JsonProperty("execution_checklist")
//    private JsonNode execution_checklist;
//    
//    // ==================== CONSTRUCTORS ====================
//    
//    /**
//     * Default constructor for Jackson deserialization
//     */
//    public StockAnalysisResponse() {
//        super();
//    }
//    
//    /**
//     * Constructor with essential fields
//     */
//    public StockAnalysisResponse(String company_name, String ticker, String analysis_date) {
//        this.company_name = company_name;
//        this.ticker = ticker;
//        this.analysis_date = analysis_date;
//    }
//    
//    // ==================== GETTERS AND SETTERS ====================
//    
//    public String getCompany_name() {
//        return company_name;
//    }
//    
//    public void setCompany_name(String company_name) {
//        this.company_name = company_name;
//    }
//    
//    public String getTicker() {
//        return ticker;
//    }
//    
//    public void setTicker(String ticker) {
//        this.ticker = ticker;
//    }
//    
//    public String getAnalysis_date() {
//        return analysis_date;
//    }
//    
//    public void setAnalysis_date(String analysis_date) {
//        this.analysis_date = analysis_date;
//    }
//    
//    public String getSector() {
//        return sector;
//    }
//    
//    public void setSector(String sector) {
//        this.sector = sector;
//    }
//    
//    public String getCompany_position() {
//        return company_position;
//    }
//    
//    public void setCompany_position(String company_position) {
//        this.company_position = company_position;
//    }
//    
//    public String getData_source() {
//        return data_source;
//    }
//    
//    public void setData_source(String data_source) {
//        this.data_source = data_source;
//    }
//    
//    public String getData_staleness_warning() {
//        return data_staleness_warning;
//    }
//    
//    public void setData_staleness_warning(String data_staleness_warning) {
//        this.data_staleness_warning = data_staleness_warning;
//    }
//    
//    public String getThis_stock_relative_valuation() {
//        return this_stock_relative_valuation;
//    }
//    
//    public void setThis_stock_relative_valuation(String this_stock_relative_valuation) {
//        this.this_stock_relative_valuation = this_stock_relative_valuation;
//    }
//    
//    public Double getPeer_median_pe() {
//        return peer_median_pe;
//    }
//    
//    public void setPeer_median_pe(Double peer_median_pe) {
//        this.peer_median_pe = peer_median_pe;
//    }
//    
//    // JsonNode getters and setters
//    
//    public JsonNode getAnalysis_metadata() {
//        return analysis_metadata;
//    }
//    
//    public void setAnalysis_metadata(JsonNode analysis_metadata) {
//        this.analysis_metadata = analysis_metadata;
//    }
//    
//    public JsonNode getCompany_identification() {
//        return company_identification;
//    }
//    
//    public void setCompany_identification(JsonNode company_identification) {
//        this.company_identification = company_identification;
//    }
//    
//    public JsonNode getStock_price() {
//        return stock_price;
//    }
//    
//    public void setStock_price(JsonNode stock_price) {
//        this.stock_price = stock_price;
//    }
//    
//    public JsonNode getMarket_cap() {
//        return market_cap;
//    }
//    
//    public void setMarket_cap(JsonNode market_cap) {
//        this.market_cap = market_cap;
//    }
//    
//    public JsonNode getShares_outstanding() {
//        return shares_outstanding;
//    }
//    
//    public void setShares_outstanding(JsonNode shares_outstanding) {
//        this.shares_outstanding = shares_outstanding;
//    }
//    
//    public JsonNode getFinancial_metrics() {
//        return financial_metrics;
//    }
//    
//    public void setFinancial_metrics(JsonNode financial_metrics) {
//        this.financial_metrics = financial_metrics;
//    }
//    
//    public JsonNode getDebt_analysis() {
//        return debt_analysis;
//    }
//    
//    public void setDebt_analysis(JsonNode debt_analysis) {
//        this.debt_analysis = debt_analysis;
//    }
//    
//    public JsonNode getValuation() {
//        return valuation;
//    }
//    
//    public void setValuation(JsonNode valuation) {
//        this.valuation = valuation;
//    }
//    
//    public JsonNode getCompetitor_comparison() {
//        return competitor_comparison;
//    }
//    
//    public void setCompetitor_comparison(JsonNode competitor_comparison) {
//        this.competitor_comparison = competitor_comparison;
//    }
//    
//    public JsonNode getTechnical() {
//        return technical;
//    }
//    
//    public void setTechnical(JsonNode technical) {
//        this.technical = technical;
//    }
//    
//    public JsonNode getRecent_developments() {
//        return recent_developments;
//    }
//    
//    public void setRecent_developments(JsonNode recent_developments) {
//        this.recent_developments = recent_developments;
//    }
//    
//    public JsonNode getAnalyst_consensus() {
//        return analyst_consensus;
//    }
//    
//    public void setAnalyst_consensus(JsonNode analyst_consensus) {
//        this.analyst_consensus = analyst_consensus;
//    }
//    
//    public JsonNode getFair_value() {
//        return fair_value;
//    }
//    
//    public void setFair_value(JsonNode fair_value) {
//        this.fair_value = fair_value;
//    }
//    
//    public JsonNode getScenarios() {
//        return scenarios;
//    }
//    
//    public void setScenarios(JsonNode scenarios) {
//        this.scenarios = scenarios;
//    }
//    
//    public JsonNode getInvestment_decision() {
//        return investment_decision;
//    }
//    
//    public void setInvestment_decision(JsonNode investment_decision) {
//        this.investment_decision = investment_decision;
//    }
//    
//    public JsonNode getAction_plan() {
//        return action_plan;
//    }
//    
//    public void setAction_plan(JsonNode action_plan) {
//        this.action_plan = action_plan;
//    }
//    
//    public JsonNode getConfidence_metrics() {
//        return confidence_metrics;
//    }
//    
//    public void setConfidence_metrics(JsonNode confidence_metrics) {
//        this.confidence_metrics = confidence_metrics;
//    }
//    
//    public JsonNode getExecution_checklist() {
//        return execution_checklist;
//    }
//    
//    public void setExecution_checklist(JsonNode execution_checklist) {
//        this.execution_checklist = execution_checklist;
//    }
//    
//    // ==================== ENHANCED HELPER METHODS (NOT SERIALIZED) ====================
//    // All helper methods marked with @JsonIgnore to prevent duplicate keys in JSON output
//    
//    /**
//     * Get company name from either root level or nested company_identification
//     * @return company name, handles both JSON structures
//     */
//    @JsonIgnore
//    public String getCompanyName() {
//        // Try root level first
//        if (company_name != null && !company_name.trim().isEmpty()) {
//            return company_name;
//        }
//        // Fallback to nested structure
//        if (company_identification != null && company_identification.has("company_name")) {
//            return company_identification.get("company_name").asText();
//        }
//        return null;
//    }
//    
//    /**
//     * Get ticker from either root level or nested company_identification
//     * @return ticker symbol
//     */
//    @JsonIgnore
//    public String getTickerSymbol() {
//        if (ticker != null && !ticker.trim().isEmpty()) {
//            return ticker;
//        }
//        if (company_identification != null && company_identification.has("ticker")) {
//            return company_identification.get("ticker").asText();
//        }
//        return null;
//    }
//    
//    /**
//     * Get sector from either root level or nested company_identification
//     * @return sector name
//     */
//    @JsonIgnore
//    public String getSectorName() {
//        if (sector != null && !sector.trim().isEmpty()) {
//            return sector;
//        }
//        if (company_identification != null && company_identification.has("sector")) {
//            return company_identification.get("sector").asText();
//        }
//        return null;
//    }
//    
//    /**
//     * Get company position from either root level or nested company_identification
//     * @return company position description
//     */
//    @JsonIgnore
//    public String getCompanyPositionDescription() {
//        if (company_position != null && !company_position.trim().isEmpty()) {
//            return company_position;
//        }
//        if (company_identification != null && company_identification.has("company_position")) {
//            return company_identification.get("company_position").asText();
//        }
//        return null;
//    }
//    
//    /**
//     * Get investment verdict from decision node
//     * @return "BUY", "HOLD", "SELL", or "AVOID"
//     */
//    @JsonIgnore
//    public String getInvestmentVerdict() {
//        if (investment_decision != null && investment_decision.has("final_verdict")) {
//            return investment_decision.get("final_verdict").asText();
//        }
//        return null;
//    }
//    
//    /**
//     * Get conviction level from decision node
//     * @return conviction percentage (0-100)
//     */
//    @JsonIgnore
//    public Integer getConvictionLevel() {
//        if (investment_decision != null && investment_decision.has("conviction_level")) {
//            return investment_decision.get("conviction_level").asInt();
//        }
//        return null;
//    }
//    
//    /**
//     * Get 12-month target price from multiple locations
//     * ENHANCED: Checks investment_decision and action_plan profit_target
//     * @return 12-month target price
//     */
//    @JsonIgnore
//    public Double getTargetPrice12m() {
//        // Location 1: Try investment_decision.target_price_12m
//        if (investment_decision != null && investment_decision.has("target_price_12m")) {
//            try {
//                return investment_decision.get("target_price_12m").asDouble();
//            } catch (Exception e) {
//                // Handle null or non-numeric values
//            }
//        }
//        
//        // Location 2: Try action_plan.profit_target.price (backup)
//        if (action_plan != null && action_plan.has("profit_target")) {
//            JsonNode target = action_plan.get("profit_target");
//            if (target.has("price")) {
//                try {
//                    return target.get("price").asDouble();
//                } catch (Exception e) {
//                    // Handle null or non-numeric values
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get entry price from action plan
//     * @return recommended entry price
//     */
//    @JsonIgnore
//    public Double getEntryPrice() {
//        if (action_plan != null && action_plan.has("entry_price")) {
//            JsonNode entryPriceNode = action_plan.get("entry_price");
//            if (entryPriceNode.isObject() && entryPriceNode.has("primary")) {
//                try {
//                    String primary = entryPriceNode.get("primary").asText();
//                    // Parse "960-985" format if needed
//                    if (primary.contains("-")) {
//                        String[] range = primary.split("-");
//                        return (Double.parseDouble(range[0]) + Double.parseDouble(range[1])) / 2;
//                    } else {
//                        return Double.parseDouble(primary);
//                    }
//                } catch (Exception e) {
//                    // Handle parsing errors
//                }
//            } else if (entryPriceNode.isNumber()) {
//                return entryPriceNode.asDouble();
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get stop loss from action plan
//     * @return stop loss price
//     */
//    @JsonIgnore
//    public Double getStopLoss() {
//        if (action_plan != null && action_plan.has("stop_loss")) {
//            JsonNode stopLossNode = action_plan.get("stop_loss");
//            if (stopLossNode.has("price")) {
//                return stopLossNode.get("price").asDouble();
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get profit target from action plan
//     * @return profit target price
//     */
//    @JsonIgnore
//    public Double getProfitTarget() {
//        if (action_plan != null && action_plan.has("profit_target")) {
//            JsonNode targetNode = action_plan.get("profit_target");
//            if (targetNode.has("price")) {
//                return targetNode.get("price").asDouble();
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get current stock price from multiple locations
//     * ENHANCED: Handles both stock_price.value and action_plan.entry_price
//     * @return current stock price in INR per share
//     */
//    @JsonIgnore
//    public Double getCurrentStockPrice() {
//        // Location 1: Try stock_price JsonNode
//        if (stock_price != null && stock_price.has("value")) {
//            try {
//                return stock_price.get("value").asDouble();
//            } catch (Exception e) {
//                // Handle null or non-numeric values
//            }
//        }
//        
//        // Location 2: Try action_plan entry_price as reference
//        Double entryPrice = getEntryPrice();
//        if (entryPrice != null) {
//            return entryPrice;
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get market cap from multiple locations
//     * ENHANCED: Also calculates from stock price and shares if needed
//     * @return market capitalization in INR Crores
//     */
//    @JsonIgnore
//    public Double getMarketCapValue() {
//        // Location 1: Try market_cap JsonNode
//        if (market_cap != null && market_cap.has("value")) {
//            try {
//                return market_cap.get("value").asDouble();
//            } catch (Exception e) {
//                // Handle null or non-numeric values
//            }
//        }
//        
//        // Location 2: Calculate from stock price and shares (fallback)
//        Double price = getCurrentStockPrice();
//        if (shares_outstanding != null && shares_outstanding.has("value") && price != null) {
//            try {
//                Long shares = shares_outstanding.get("value").asLong();
//                // Convert shares to market cap (price in INR, convert to Crores)
//                return (price * shares) / 10000000.0;  // Convert to Crores
//            } catch (Exception e) {
//                // Handle errors
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get 3-year revenue CAGR from multiple locations
//     * ENHANCED: Also checks financial_metrics.summary_metrics.revenue_cagr_3yr
//     * @return revenue CAGR percentage
//     */
//    @JsonIgnore
//    public Double getRevenueCagr() {
//        // Location 1: Try root level of financial_metrics (old structure)
//        if (financial_metrics != null && financial_metrics.has("revenue_cagr_3yr")) {
//            JsonNode cagr = financial_metrics.get("revenue_cagr_3yr");
//            if (cagr.has("value")) {
//                try {
//                    return cagr.get("value").asDouble();
//                } catch (Exception e) {
//                    // Handle null or non-numeric values
//                }
//            }
//        }
//        
//        // Location 2: Try summary_metrics (new structure)
//        if (financial_metrics != null && financial_metrics.has("summary_metrics")) {
//            JsonNode summary = financial_metrics.get("summary_metrics");
//            if (summary.has("revenue_cagr_3yr")) {
//                JsonNode cagr = summary.get("revenue_cagr_3yr");
//                if (cagr.has("value")) {
//                    try {
//                        return cagr.get("value").asDouble();
//                    } catch (Exception e) {
//                        // Handle null or non-numeric values
//                    }
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get profit CAGR from multiple locations
//     * NEW: Checks financial_metrics.summary_metrics.profit_cagr_3yr
//     * @return profit CAGR percentage
//     */
//    @JsonIgnore
//    public Double getProfitCagr() {
//        // Location 1: Try root level of financial_metrics (if it exists)
//        if (financial_metrics != null && financial_metrics.has("profit_cagr_3yr")) {
//            JsonNode cagr = financial_metrics.get("profit_cagr_3yr");
//            if (cagr.has("value")) {
//                try {
//                    return cagr.get("value").asDouble();
//                } catch (Exception e) {
//                    // Handle null or non-numeric values
//                }
//            }
//        }
//        
//        // Location 2: Try summary_metrics (new structure)
//        if (financial_metrics != null && financial_metrics.has("summary_metrics")) {
//            JsonNode summary = financial_metrics.get("summary_metrics");
//            if (summary.has("profit_cagr_3yr")) {
//                JsonNode cagr = summary.get("profit_cagr_3yr");
//                if (cagr.has("value")) {
//                    try {
//                        return cagr.get("value").asDouble();
//                    } catch (Exception e) {
//                        // Handle null or non-numeric values
//                    }
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get P/E ratio
//     * @return Price-to-Earnings multiple
//     */
//    @JsonIgnore
//    public Double getPeRatio() {
//        if (valuation != null && valuation.has("pe_ratio")) {
//            JsonNode pe = valuation.get("pe_ratio");
//            if (pe.has("value")) {
//                return pe.get("value").asDouble();
//            }
//        }
//        // Try corrected_pe_ratio if available (for cases with calculation notes)
//        if (valuation != null && valuation.has("corrected_pe_ratio")) {
//            JsonNode pe = valuation.get("corrected_pe_ratio");
//            if (pe.has("value")) {
//                return pe.get("value").asDouble();
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get net debt to EBITDA ratio from multiple locations
//     * ENHANCED: Also checks financial_metrics.years_data[0].debt.net_debt_to_ebitda
//     * @return leverage ratio (net debt / EBITDA)
//     */
//    @JsonIgnore
//    public Double getNetDebtToEbitda() {
//        // Location 1: Try old structure (debt_analysis - deprecated)
//        if (debt_analysis != null && debt_analysis.has("net_debt_to_ebitda")) {
//            JsonNode ratio = debt_analysis.get("net_debt_to_ebitda");
//            if (ratio.has("value")) {
//                return ratio.get("value").asDouble();
//            }
//        }
//        
//        // Location 2: Try new structure (financial_metrics.years_data[0].debt)
//        if (financial_metrics != null && financial_metrics.has("years_data")) {
//            JsonNode yearsData = financial_metrics.get("years_data");
//            if (yearsData.isArray() && yearsData.size() > 0) {
//                JsonNode latestYear = yearsData.get(0);
//                if (latestYear.has("debt")) {
//                    JsonNode debtNode = latestYear.get("debt");
//                    if (debtNode.has("net_debt_to_ebitda")) {
//                        JsonNode ratio = debtNode.get("net_debt_to_ebitda");
//                        if (ratio.has("value")) {
//                            return ratio.get("value").asDouble();
//                        }
//                    }
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get total debt from multiple locations
//     * NEW: Handles financial_metrics.years_data[0].debt.total_debt
//     * @return total debt in INR Crores
//     */
//    @JsonIgnore
//    public Double getTotalDebt() {
//        // Location 1: Try old structure (debt_analysis - deprecated)
//        if (debt_analysis != null && debt_analysis.has("total_debt")) {
//            JsonNode debt = debt_analysis.get("total_debt");
//            if (debt.has("value")) {
//                try {
//                    return debt.get("value").asDouble();
//                } catch (Exception e) {
//                    // Handle null or non-numeric values
//                }
//            }
//        }
//        
//        // Location 2: Try new structure (financial_metrics.years_data[0].debt)
//        if (financial_metrics != null && financial_metrics.has("years_data")) {
//            JsonNode yearsData = financial_metrics.get("years_data");
//            if (yearsData.isArray() && yearsData.size() > 0) {
//                JsonNode latestYear = yearsData.get(0);
//                if (latestYear.has("debt")) {
//                    JsonNode debtNode = latestYear.get("debt");
//                    if (debtNode.has("total_debt")) {
//                        JsonNode totalDebt = debtNode.get("total_debt");
//                        if (totalDebt.has("value")) {
//                            try {
//                                return totalDebt.get("value").asDouble();
//                            } catch (Exception e) {
//                                // Handle null or non-numeric values
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get net debt from multiple locations
//     * NEW: Handles financial_metrics.years_data[0].debt.net_debt
//     * @return net debt (total debt - cash) in INR Crores
//     */
//    @JsonIgnore
//    public Double getNetDebt() {
//        // Location 1: Try old structure (debt_analysis - deprecated)
//        if (debt_analysis != null && debt_analysis.has("net_debt")) {
//            JsonNode debt = debt_analysis.get("net_debt");
//            if (debt.has("value")) {
//                try {
//                    return debt.get("value").asDouble();
//                } catch (Exception e) {
//                    // Handle null or non-numeric values
//                }
//            }
//        }
//        
//        // Location 2: Try new structure (financial_metrics.years_data[0].debt)
//        if (financial_metrics != null && financial_metrics.has("years_data")) {
//            JsonNode yearsData = financial_metrics.get("years_data");
//            if (yearsData.isArray() && yearsData.size() > 0) {
//                JsonNode latestYear = yearsData.get(0);
//                if (latestYear.has("debt")) {
//                    JsonNode debtNode = latestYear.get("debt");
//                    if (debtNode.has("net_debt")) {
//                        JsonNode netDebt = debtNode.get("net_debt");
//                        if (netDebt.has("value")) {
//                            try {
//                                return netDebt.get("value").asDouble();
//                            } catch (Exception e) {
//                                // Handle null or non-numeric values
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get cash position from multiple locations
//     * NEW: Handles financial_metrics.years_data[0].debt.cash
//     * @return cash in INR Crores
//     */
//    @JsonIgnore
//    public Double getCash() {
//        // Location 1: Try old structure (debt_analysis - deprecated)
//        if (debt_analysis != null && debt_analysis.has("cash_position")) {
//            JsonNode cash = debt_analysis.get("cash_position");
//            if (cash.has("value")) {
//                try {
//                    return cash.get("value").asDouble();
//                } catch (Exception e) {
//                    // Handle null or non-numeric values
//                }
//            }
//        }
//        
//        // Location 2: Try new structure (financial_metrics.years_data[0].debt.cash)
//        if (financial_metrics != null && financial_metrics.has("years_data")) {
//            JsonNode yearsData = financial_metrics.get("years_data");
//            if (yearsData.isArray() && yearsData.size() > 0) {
//                JsonNode latestYear = yearsData.get(0);
//                if (latestYear.has("debt")) {
//                    JsonNode debtNode = latestYear.get("debt");
//                    if (debtNode.has("cash")) {
//                        JsonNode cash = debtNode.get("cash");
//                        if (cash.has("value")) {
//                            try {
//                                return cash.get("value").asDouble();
//                            } catch (Exception e) {
//                                // Handle null or non-numeric values
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get latest year's revenue from financial metrics
//     * NEW: Extracts from financial_metrics.years_data[0].revenue.value
//     * @return latest year revenue in INR Crores
//     */
//    @JsonIgnore
//    public Double getLatestYearRevenue() {
//        if (financial_metrics != null && financial_metrics.has("years_data")) {
//            JsonNode yearsData = financial_metrics.get("years_data");
//            if (yearsData.isArray() && yearsData.size() > 0) {
//                JsonNode latestYear = yearsData.get(0);
//                if (latestYear.has("revenue")) {
//                    JsonNode revenue = latestYear.get("revenue");
//                    if (revenue.has("value")) {
//                        try {
//                            return revenue.get("value").asDouble();
//                        } catch (Exception e) {
//                            // Handle null or non-numeric values
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get latest year's profit (PAT) from financial metrics
//     * NEW: Extracts from financial_metrics.years_data[0].profit.pat.value
//     * @return latest year profit in INR Crores
//     */
//    @JsonIgnore
//    public Double getLatestYearProfit() {
//        if (financial_metrics != null && financial_metrics.has("years_data")) {
//            JsonNode yearsData = financial_metrics.get("years_data");
//            if (yearsData.isArray() && yearsData.size() > 0) {
//                JsonNode latestYear = yearsData.get(0);
//                if (latestYear.has("profit")) {
//                    JsonNode profit = latestYear.get("profit");
//                    if (profit.has("pat")) {
//                        JsonNode pat = profit.get("pat");
//                        if (pat.has("value")) {
//                            try {
//                                return pat.get("value").asDouble();
//                            } catch (Exception e) {
//                                // Handle null or non-numeric values
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get latest year's EBITDA from financial metrics
//     * NEW: Extracts from financial_metrics.years_data[0].ebitda.value
//     * @return latest year EBITDA in INR Crores
//     */
//    @JsonIgnore
//    public Double getLatestYearEbitda() {
//        if (financial_metrics != null && financial_metrics.has("years_data")) {
//            JsonNode yearsData = financial_metrics.get("years_data");
//            if (yearsData.isArray() && yearsData.size() > 0) {
//                JsonNode latestYear = yearsData.get(0);
//                if (latestYear.has("ebitda")) {
//                    JsonNode ebitda = latestYear.get("ebitda");
//                    if (ebitda.has("value")) {
//                        try {
//                            return ebitda.get("value").asDouble();
//                        } catch (Exception e) {
//                            // Handle null or non-numeric values
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get credit rating agency and rating
//     * NEW: Extracts from financial_metrics.summary_metrics.latest_credit_rating
//     * @return credit rating (e.g., "AA+")
//     */
//    @JsonIgnore
//    public String getCreditRating() {
//        // Location 1: Try summary_metrics (new structure)
//        if (financial_metrics != null && financial_metrics.has("summary_metrics")) {
//            JsonNode summary = financial_metrics.get("summary_metrics");
//            if (summary.has("latest_credit_rating")) {
//                JsonNode rating = summary.get("latest_credit_rating");
//                if (rating.has("value")) {
//                    try {
//                        return rating.get("value").asText();
//                    } catch (Exception e) {
//                        // Handle null or non-text values
//                    }
//                }
//            }
//        }
//        
//        // Location 2: Try debt_analysis (old structure, if it exists)
//        if (debt_analysis != null && debt_analysis.has("debt_rating")) {
//            JsonNode rating = debt_analysis.get("debt_rating");
//            if (rating.has("value")) {
//                try {
//                    return rating.get("value").asText();
//                } catch (Exception e) {
//                    // Handle null or non-text values
//                }
//            }
//        }
//        
//        return null;
//    }
//    
//    /**
//     * Get analyst consensus rating
//     * @return "BUY", "HOLD", or "SELL"
//     */
//    @JsonIgnore
//    public String getAnalystRating() {
//        if (analyst_consensus != null && analyst_consensus.has("consensus_rating")) {
//            return analyst_consensus.get("consensus_rating").asText();
//        }
//        return null;
//    }
//    
//    /**
//     * Get technical trend
//     * @return trend direction (UPTREND, DOWNTREND, SIDEWAYS)
//     */
//    @JsonIgnore
//    public String getTechnicalTrend() {
//        if (technical != null && technical.has("trend")) {
//            try {
//                return technical.get("trend").asText();
//            } catch (Exception e) {
//                // Handle null or non-text values
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Get technical rating score
//     * @return technical rating (e.g., "7/10")
//     */
//    @JsonIgnore
//    public String getTechnicalRating() {
//        if (technical != null && technical.has("technical_rating")) {
//            try {
//                return technical.get("technical_rating").asText();
//            } catch (Exception e) {
//                // Handle null or non-text values
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * Check if all required analysis components are complete
//     * @return true if all checklist items pass
//     */
//    @JsonIgnore
//    public Boolean isAnalysisComplete() {
//        if (execution_checklist != null && execution_checklist.has("no_data_missing")) {
//            return execution_checklist.get("no_data_missing").asBoolean();
//        }
//        return false;
//    }
//    
//    /**
//     * Validate that essential fields are populated (enhanced with new structure)
//     * @return true if minimum required data is present
//     */
//    @JsonIgnore
//    public boolean isValid() {
//        // Check root level or fallback to nested
//        boolean hasCompany = (getCompanyName() != null && !getCompanyName().trim().isEmpty());
//        boolean hasTicker = (getTickerSymbol() != null && !getTickerSymbol().trim().isEmpty());
//        
//        // Check nested structures
//        boolean hasDecision = investment_decision != null && investment_decision.has("final_verdict");
//        boolean hasAction = action_plan != null;
//        
//        // Check financial metrics (new structure)
//        boolean hasFinancials = financial_metrics != null && financial_metrics.has("years_data");
//        
//        return hasCompany && hasTicker && hasDecision && hasAction && hasFinancials;
//    }
//    
//    /**
//     * Get position size recommendation
//     * @return position size as percentage of portfolio
//     */
//    @JsonIgnore
//    public String getPositionSize() {
//        if (action_plan != null && action_plan.has("position_size")) {
//            return action_plan.get("position_size").asText();
//        }
//        return null;
//    }
//    
//    /**
//     * Get monitoring checklist items
//     * @return array of monitoring items
//     */
//    @JsonIgnore
//    public JsonNode getMonitoringItems() {
//        if (action_plan != null && action_plan.has("monitoring")) {
//            return action_plan.get("monitoring");
//        }
//        return null;
//    }
//    
//    // ==================== UTILITY METHODS ====================
//    
//    /**
//     * Enhanced toString with correct data retrieval
//     */
//    @Override
//    public String toString() {
//        return String.format(
//            "StockAnalysisResponse{company='%s', ticker='%s', verdict='%s', conviction=%d, target=%.2f, price=%.2f}",
//            getCompanyName(),
//            getTickerSymbol(),
//            getInvestmentVerdict(),
//            getConvictionLevel() != null ? getConvictionLevel() : 0,
//            getTargetPrice12m() != null ? getTargetPrice12m() : 0.0,
//            getCurrentStockPrice() != null ? getCurrentStockPrice() : 0.0
//        );
//    }
//    
//    /**
//     * Enhanced detailed summary with correct data retrieval
//     */
//    @JsonIgnore
//    public String getDetailedSummary() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("=== STOCK ANALYSIS SUMMARY ===\n");
//        sb.append(String.format("Company: %s (%s)\n", getCompanyName(), getTickerSymbol()));
//        sb.append(String.format("Sector: %s\n", getSectorName()));
//        sb.append(String.format("Current Price: ₹%.2f\n", getCurrentStockPrice() != null ? getCurrentStockPrice() : 0.0));
//        sb.append(String.format("Market Cap: ₹%.0f Cr\n", getMarketCapValue() != null ? getMarketCapValue() : 0.0));
//        sb.append(String.format("\nVERDICT: %s (Conviction: %d%%)\n", 
//            getInvestmentVerdict(), 
//            getConvictionLevel() != null ? getConvictionLevel() : 0));
//        sb.append(String.format("Target Price: ₹%.2f\n", getTargetPrice12m() != null ? getTargetPrice12m() : 0.0));
//        sb.append(String.format("Entry Price: ₹%.2f\n", getEntryPrice() != null ? getEntryPrice() : 0.0));
//        sb.append(String.format("Stop Loss: ₹%.2f\n", getStopLoss() != null ? getStopLoss() : 0.0));
//        sb.append(String.format("\nValuation: P/E %.2fx | Revenue CAGR: %.1f%% | Profit CAGR: %.1f%%\n", 
//            getPeRatio() != null ? getPeRatio() : 0.0,
//            getRevenueCagr() != null ? getRevenueCagr() : 0.0,
//            getProfitCagr() != null ? getProfitCagr() : 0.0));
//        sb.append(String.format("Leverage: Net Debt/EBITDA %.2fx | Credit Rating: %s\n", 
//            getNetDebtToEbitda() != null ? getNetDebtToEbitda() : 0.0,
//            getCreditRating() != null ? getCreditRating() : "N/A"));
//        sb.append(String.format("Technical: %s (%s)\n", 
//            getTechnicalTrend() != null ? getTechnicalTrend() : "N/A", 
//            getTechnicalRating() != null ? getTechnicalRating() : "N/A"));
//        sb.append(String.format("Analyst Consensus: %s\n", getAnalystRating() != null ? getAnalystRating() : "N/A"));
//        sb.append(String.format("Latest Year Revenue: ₹%.0f Cr | Profit: ₹%.0f Cr | EBITDA: ₹%.0f Cr\n",
//            getLatestYearRevenue() != null ? getLatestYearRevenue() : 0.0,
//            getLatestYearProfit() != null ? getLatestYearProfit() : 0.0,
//            getLatestYearEbitda() != null ? getLatestYearEbitda() : 0.0));
//        
//        return sb.toString();
//    }
//    
//    /**
//     * Convert to JSON string (requires ObjectMapper)
//     * @return JSON string representation
//     */
//    public String toJson() {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
//        } catch (Exception e) {
//            return "{\"error\": \"Failed to serialize: " + e.getMessage() + "\"}";
//        }
//    }
//}



package com.stockMarketAI.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;

public class StockAnalysisResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("company_name")
    private String company_name;
    
    @JsonProperty("ticker")
    private String ticker;
    
    @JsonProperty("sector")
    private String sector;
    
    @JsonProperty("company_position")
    private String company_position;
    
    @JsonProperty("data_source")
    private String data_source;
    
    @JsonProperty("analysis_date")
    private String analysis_date;
    
    @JsonProperty("stock_price")
    private JsonNode stock_price;
    
    @JsonProperty("market_cap")
    private JsonNode market_cap;
    
    @JsonProperty("shares_outstanding")
    private JsonNode shares_outstanding;
    
    @JsonProperty("financial_metrics")
    private JsonNode financial_metrics;
    
    @JsonProperty("valuation")
    private JsonNode valuation;
    
    @JsonProperty("competitor_comparison")
    private JsonNode competitor_comparison;
    
    @JsonProperty("peer_median_pe")
    private Double peer_median_pe;
    
    @JsonProperty("this_stock_relative_valuation")
    private String this_stock_relative_valuation;
    
    @JsonProperty("technical")
    private JsonNode technical;
    
    @JsonProperty("recent_developments")
    private JsonNode recent_developments;
    
    @JsonProperty("data_staleness_warning")
    private String data_staleness_warning;
    
    @JsonProperty("analyst_consensus")
    private JsonNode analyst_consensus;
    
    @JsonProperty("fair_value")
    private JsonNode fair_value;
    
    @JsonProperty("scenarios")
    private JsonNode scenarios;
    
    @JsonProperty("investment_decision")
    private JsonNode investment_decision;
    
    @JsonProperty("action_plan")
    private JsonNode action_plan;
    
    // ==================== CONSTRUCTORS ====================
    
    public StockAnalysisResponse() {
    }
    
    // ==================== GETTERS AND SETTERS ====================
    
    public String getCompany_name() {
        return company_name;
    }
    
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    
    public String getTicker() {
        return ticker;
    }
    
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    
    public String getSector() {
        return sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    public String getCompany_position() {
        return company_position;
    }
    
    public void setCompany_position(String company_position) {
        this.company_position = company_position;
    }
    
    public String getData_source() {
        return data_source;
    }
    
    public void setData_source(String data_source) {
        this.data_source = data_source;
    }
    
    public String getAnalysis_date() {
        return analysis_date;
    }
    
    public void setAnalysis_date(String analysis_date) {
        this.analysis_date = analysis_date;
    }
    
    public JsonNode getStock_price() {
        return stock_price;
    }
    
    public void setStock_price(JsonNode stock_price) {
        this.stock_price = stock_price;
    }
    
    public JsonNode getMarket_cap() {
        return market_cap;
    }
    
    public void setMarket_cap(JsonNode market_cap) {
        this.market_cap = market_cap;
    }
    
    public JsonNode getShares_outstanding() {
        return shares_outstanding;
    }
    
    public void setShares_outstanding(JsonNode shares_outstanding) {
        this.shares_outstanding = shares_outstanding;
    }
    
    public JsonNode getFinancial_metrics() {
        return financial_metrics;
    }
    
    public void setFinancial_metrics(JsonNode financial_metrics) {
        this.financial_metrics = financial_metrics;
    }
    
    public JsonNode getValuation() {
        return valuation;
    }
    
    public void setValuation(JsonNode valuation) {
        this.valuation = valuation;
    }
    
    public JsonNode getCompetitor_comparison() {
        return competitor_comparison;
    }
    
    public void setCompetitor_comparison(JsonNode competitor_comparison) {
        this.competitor_comparison = competitor_comparison;
    }
    
    public Double getPeer_median_pe() {
        return peer_median_pe;
    }
    
    public void setPeer_median_pe(Double peer_median_pe) {
        this.peer_median_pe = peer_median_pe;
    }
    
    public String getThis_stock_relative_valuation() {
        return this_stock_relative_valuation;
    }
    
    public void setThis_stock_relative_valuation(String this_stock_relative_valuation) {
        this.this_stock_relative_valuation = this_stock_relative_valuation;
    }
    
    public JsonNode getTechnical() {
        return technical;
    }
    
    public void setTechnical(JsonNode technical) {
        this.technical = technical;
    }
    
    public JsonNode getRecent_developments() {
        return recent_developments;
    }
    
    public void setRecent_developments(JsonNode recent_developments) {
        this.recent_developments = recent_developments;
    }
    
    public String getData_staleness_warning() {
        return data_staleness_warning;
    }
    
    public void setData_staleness_warning(String data_staleness_warning) {
        this.data_staleness_warning = data_staleness_warning;
    }
    
    public JsonNode getAnalyst_consensus() {
        return analyst_consensus;
    }
    
    public void setAnalyst_consensus(JsonNode analyst_consensus) {
        this.analyst_consensus = analyst_consensus;
    }
    
    public JsonNode getFair_value() {
        return fair_value;
    }
    
    public void setFair_value(JsonNode fair_value) {
        this.fair_value = fair_value;
    }
    
    public JsonNode getScenarios() {
        return scenarios;
    }
    
    public void setScenarios(JsonNode scenarios) {
        this.scenarios = scenarios;
    }
    
    public JsonNode getInvestment_decision() {
        return investment_decision;
    }
    
    public void setInvestment_decision(JsonNode investment_decision) {
        this.investment_decision = investment_decision;
    }
    
    public JsonNode getAction_plan() {
        return action_plan;
    }
    
    public void setAction_plan(JsonNode action_plan) {
        this.action_plan = action_plan;
    }
    
    @Override
    public String toString() {
        return "StockAnalysisResponse{" +
                "company_name='" + company_name + '\'' +
                ", ticker='" + ticker + '\'' +
                ", sector='" + sector + '\'' +
                ", analysis_date='" + analysis_date + '\'' +
                '}';
    }
}
