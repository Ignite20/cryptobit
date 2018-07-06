package com.studio.ember.cryptobit.webservice.currency;

import android.os.AsyncTask;
import android.util.Log;

import com.studio.ember.cryptobit.model.Data;
import com.studio.ember.cryptobit.webservice.CryptoCurrencyService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

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



}
