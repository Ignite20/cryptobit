package com.studio.ember.cryptobit.model;

import java.io.Serializable;
import java.util.Map;

public class Coin extends BaseClassModel implements Serializable{

    private int id;
    private String name;
    private String symbol;
    private String website_slug;
    private int rank;
    private double circulating_supply;
    private double total_supply;
    private double max_supply;
    private Map<String, Currency> quotes;
    private int last_updated;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getWebsite_slug() {
        return website_slug;
    }

    public int getRank() {
        return rank;
    }

    public double getCirculating_supply() {
        return circulating_supply;
    }

    public double getTotal_supply() {
        return total_supply;
    }

    public double getMax_supply() {
        return max_supply;
    }

    public Map<String, Currency> getQuotes() {
        return quotes;
    }

    public int getLast_updated() {
        return last_updated;
    }


}
