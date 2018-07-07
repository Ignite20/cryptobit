package com.studio.ember.cryptobit.utils;

import java.util.Locale;

public class StringUtils {
    private static final String MONEY_FORMAT = "%1$,.2f";

    public static String formatFloat(double number){
        return String.format(Locale.getDefault(),MONEY_FORMAT, number);
    }
}
