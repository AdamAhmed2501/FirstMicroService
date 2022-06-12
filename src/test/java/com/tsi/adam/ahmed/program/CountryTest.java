package com.tsi.adam.ahmed.program;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import com.tsi.adam.ahmed.program.Country;
public class CountryTest {

    Country testCountry = new Country("country");
    Country testCountry2 = new Country();

    @Test
    public void testCountry(){
        Assertions.assertEquals(0, testCountry.getCountry_id(), "Incorrect country ID");
        Assertions.assertEquals("country", testCountry.getCountry(), "Incorrect country");

        testCountry2.setCountry("testcountry");
        Assertions.assertEquals("testcountry", testCountry2.getCountry(), "Incorrect country");

    }

}
