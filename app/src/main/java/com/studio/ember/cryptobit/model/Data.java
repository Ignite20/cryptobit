package com.studio.ember.cryptobit.model;

import java.util.ArrayList;

public class Data extends BaseClassModel{
    private ArrayList<Coin> data;
    private Metadata metadata;

    public ArrayList<Coin> getData() {
        return data;
    }
}
