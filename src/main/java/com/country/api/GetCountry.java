package com.country.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface GetCountry {

    @GET("v3.1/alpha/{code}")
    Call<List<CountryDetails>> getCountryDetailsFromCode(@Path("code") String code);

    @GET("v3.1/name/{fullName}")
    Call<List<CountryDetails>> getCountryDetailsFromName(@Path("fullName") String fullName,
                                                         @Query("fullText") boolean isFullText);

}
