package com.studio.ember.cryptobit.webservice;

public interface WSConstants {
    // Server Endpoint
    String API_ENDPOINT = "https://api.coinmarketcap.com/v2/";

    // region API calls
    String TICKER = "ticker/";
    String TICKER_ARRAY_SORT_RANK = TICKER+"?convert=EUR&sort=rank&structure=array";
    String TICKER_CONVERT = TICKER+"{id}?structure=array";
    // endregion

}
