package com.tsi.adam.ahmed.program;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import com.tsi.adam.ahmed.program.City;
public class CityTest {

    City testCity = new City("city");
    City testCity2 = new City();

    @Test
    public void testCity(){
        Assertions.assertEquals(0, testCity.getCity_id(), "Incorrect city ID");
        Assertions.assertEquals("city", testCity.getCity(), "Incorrect city");
        Assertions.assertEquals(0, testCity.getCountry_id(), "Incorrect country id");

        testCity2.setCity("test_city");
        Assertions.assertEquals("test_city", testCity2.getCity(), "Incorrect city");
    }
}
