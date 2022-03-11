package com.country.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final String HOST = "https://restcountries.com/";

    private static OkHttpClient getClient() {
       return new OkHttpClient.Builder()
         //       .addInterceptor()
            .build();
    }
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(HOST)
                .client(getClient())
                .build();
    }

    /**
     * api service class to get country info
     * @return  Country API service
     */
    public static GetCountry getCountryService() {
        return getRetrofit().create(GetCountry.class);
    }
}
