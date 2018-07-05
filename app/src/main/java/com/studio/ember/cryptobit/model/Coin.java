package com.studio.ember.cryptobit.model;

import android.support.annotation.Nullable;

import java.util.Map;

public class Coin extends BaseModel{

    private int id;
    private String name;
    private String symbol;
    private String website_slug;
    private int rank;
    private int circulating_supply;
    private int total_supply;

    @Nullable
    private int max_supply;

    private Map<String, Map<String, Currency>> quotes;
    private int last_updated;

    public Coin() {

    }


    @Override
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

    public int getCirculating_supply() {
        return circulating_supply;
    }

    public int getTotal_supply() {
        return total_supply;
    }

    @Nullable
    public int getMax_supply() {
        return max_supply;
    }

    public Map<String, Map<String, Currency>> getQuotes() {
        return quotes;
    }

    public int getLast_updated() {
        return last_updated;
    }
}
