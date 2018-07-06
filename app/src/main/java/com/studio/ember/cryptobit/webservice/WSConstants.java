package com.studio.ember.cryptobit.webservice;

public interface WSConstants {
    // Server Endpoint
    String API_ENDPOINT = "https://api.coinmarketcap.com/v2/";

    String DELIMITER = "/";

    // region API calls
    String TICKER = "ticker";
    String TICKER_ARRAY_SORT_RANK = TICKER+"?convert=EUR&sort=rank&structure=array";

    // endregion

}
