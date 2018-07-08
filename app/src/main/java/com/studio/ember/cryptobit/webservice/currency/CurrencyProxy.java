package com.studio.ember.cryptobit.webservice.currency;

import android.util.Log;

import com.studio.ember.cryptobit.model.Data;
import com.studio.ember.cryptobit.webservice.CryptoCurrencyService;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Proxy Business Layer for the API calls
 */
public class CurrencyProxy{

    Retrofit service;
    ICurrencyProxy proxy;

    public CurrencyProxy() {
        service = CryptoCurrencyService.getService();
        proxy = service.create(ICurrencyProxy.class);

    }

    /**
     * Method to get the list of all the cryptocurrencies from the API
     * @return A detailed list of cryptocurrencies
     * @throws IOException
     */
    public Data getCurrencies() throws IOException {
        Data mData;
        Response<Data> response = proxy.getListByRank().execute();
        if(response.isSuccessful()) {
            mData = response.body();
            Log.d("currency", mData.toString());
            return mData;
        }
        else{
            return null;
        }
    }

    /**
     * Method to get a specific info of a crypto coin from the API
     * @param idCoin the id of the crypto coin
     * @param marketCoin the string of the market coin (USD, EUR, etc)
     * @return the detailed info a the crypto coin and the associated market coin
     * @throws IOException
     */
    public Data getMarketCoin(int idCoin, String marketCoin) throws IOException {
        Data mData;
        Response<Data> response = proxy.getCurrency(idCoin, marketCoin).execute();

        if(response.isSuccessful()) {
            mData = response.body();
            Log.d("currency", mData.toString());
            return mData;
        }
        else{
            return null;
        }
    }


}
