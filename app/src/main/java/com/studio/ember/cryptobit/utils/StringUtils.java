package com.studio.ember.cryptobit.utils;

import java.util.Locale;

public class StringUtils {

    private static final String MONEY_FORMAT = "%1$,.2f";   // format of type 1,000,000.00

    /**
     * Returns a string with a formatted float
     * @param number to be formatted
     * @return the formatted float
     */
    public static String formatFloat(double number){
        return String.format(Locale.getDefault(),MONEY_FORMAT, number);
    }
}
