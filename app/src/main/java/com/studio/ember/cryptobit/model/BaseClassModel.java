package com.studio.ember.cryptobit.model;

import com.google.gson.GsonBuilder;

public class BaseClassModel {
    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
