package com.studio.ember.cryptobit.webservice;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class serves as a singleton for providing an instance of the retrofit client.
 *
 * The singleton is accessed via getService method, and returns a static object of Retrofit
 */
public class CryptoCurrencyService {

    private static Retrofit retrofit;

    private CryptoCurrencyService() {
    }

    /**
     * Returns an instance of the retrofit client
     * @return
     */
    public static Retrofit getService() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(WSConstants.API_ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }
        return retrofit;
    }

}
