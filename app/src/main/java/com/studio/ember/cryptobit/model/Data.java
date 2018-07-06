package com.studio.ember.cryptobit.model;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Data extends BaseClassModel{
    private ArrayList<Coin> data;
    private Metadata metadata;

    public ArrayList<Coin> getData() {
        return data;
    }
}
