package com.studio.ember.cryptobit.model;

public class Currency {
    private double price;
    private double volume_24h;
    private double market_cap;
    private double percent_change_1h;
    private double percent_change_24h;
    private double percent_change_7d;

    public double getPrice() {
        return price;
    }

    public double getVolume_24h() {
        return volume_24h;
    }

    public double getMarket_cap() {
        return market_cap;
    }

    public double getPercent_change_1h() {
        return percent_change_1h;
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }

    public double getPercent_change_7d() {
        return percent_change_7d;
    }
}
