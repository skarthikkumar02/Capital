package com.country.api;

import java.util.List;

/**
 * Pojo for Country Service's response
 */
public class CountryDetails {

    private List<String> capital;

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }
}
