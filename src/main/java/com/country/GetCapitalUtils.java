package com.country;

import com.country.api.ApiService;
import com.country.api.CountryDetails;
import retrofit2.Response;

import java.util.Collections;
import java.util.List;

import static java.net.HttpURLConnection.*;

public class GetCapitalUtils {
    public static String COUNTRY_NOT_FOUND = "Country not found";
    public static String COUNTRY_RETRIEVAL_ERROR = "Country retrieval error";

    /**
     *  Get the capital for the given inputs.
     *  inputs is first treated as country code, if a 404 is received, search will be made with full country name
     *
     * @param fullNameOrCode country code or full name of the country, country code takes precedence
     * @return Capital list of the given country, On error return error message accordingly
     */
    public List<String> getCapital(String fullNameOrCode) {
        try {
            Response<List<CountryDetails>> response = ApiService.getCountryService().getCountryDetailsFromCode(fullNameOrCode).execute();
            if(response.code() == HTTP_BAD_REQUEST) {
                response = ApiService.getCountryService().getCountryDetailsFromName(fullNameOrCode, true).execute();
                if (response.code() == HTTP_NOT_FOUND) {
                    return Collections.singletonList(COUNTRY_NOT_FOUND);
                }
            }

            if (response.code() == HTTP_OK) {
                if(response.body() == null)
                    return Collections.singletonList(COUNTRY_RETRIEVAL_ERROR);
                return response.body().get(0).getCapital();
            }
            return Collections.singletonList(COUNTRY_RETRIEVAL_ERROR);

        } catch (Exception e) {
            return Collections.singletonList(COUNTRY_RETRIEVAL_ERROR);
        }
    }
}
