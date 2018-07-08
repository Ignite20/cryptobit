package com.studio.ember.cryptobit.webservice.currency;

import com.studio.ember.cryptobit.model.Data;
import com.studio.ember.cryptobit.webservice.WSConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Proxy Interface to store the API calls
 */
public interface ICurrencyProxy {

    /**
     * GET call on cryptoCurrency API that returns the list of crypto currencies
     * @return The list of cryptocurrencies sorted by rank
     */
    @GET(WSConstants.TICKER_ARRAY_SORT_RANK)
    Call<Data> getListByRank();

    /**
     * GET call on cryptoCurrency API that returns a specific cryptocoin and its associated market coin
     * @param coinId
     * @param marketCoin
     * @return
     */
    @GET(WSConstants.TICKER_CONVERT)
    Call<Data> getCurrency(@Path("id") int coinId, @Query("convert") String marketCoin);
}
