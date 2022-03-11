package com.country;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetCapitalTest {

    @Test
    public void testCapitalByCode() {
        GetCapitalUtils getCapitalUtils = new GetCapitalUtils();
        List<String> capital = new ArrayList<>();
        capital.add("New Delhi");
        Assert.assertEquals(getCapitalUtils.getCapital("in"), capital);
    }

    @Test
    public void testCapitalByName() {
        GetCapitalUtils getCapitalUtils = new GetCapitalUtils();
        List<String> capital = new ArrayList<>();
        capital.add("Washington, D.C.");
        Assert.assertEquals(getCapitalUtils.getCapital("United States"), capital);
    }

    @Test
    public void testCountryNotFound() {
        GetCapitalUtils getCapitalUtils = new GetCapitalUtils();
        List<String> capital = new ArrayList<>();
        capital.add(GetCapitalUtils.COUNTRY_NOT_FOUND);
        Assert.assertEquals(getCapitalUtils.getCapital("United States12333"), capital);
    }
}
