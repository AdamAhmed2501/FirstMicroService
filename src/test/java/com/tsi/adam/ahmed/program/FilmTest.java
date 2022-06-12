package com.tsi.adam.ahmed.program;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import com.tsi.adam.ahmed.program.Film;

import java.time.Duration;
import java.time.Year;

public class FilmTest {

    Film testFilm = new Film("Title", "Description", Year.of(2022), Duration.ofDays(0),
            0.0, Duration.ofHours(0), 0.0, 0, "Special_Features");
    Film testFilm2 = new Film();

    @Test
    public void testFilm(){
        Assertions.assertEquals(0, testFilm.getFilm_id(), "Unable to get film ID");
        Assertions.assertEquals("Title", testFilm.getTitle(), "Unable to get film title");
        Assertions.assertEquals("Description", testFilm.getDescription(), "Unable to get film description");
        Assertions.assertEquals(Year.of(2022), testFilm.getRelease_year(), "Unable to get film year");
        Assertions.assertEquals(0, testFilm.getLanguage_id(), "Unable to get film Language ID");
        Assertions.assertEquals(0, testFilm.getOriginal_Language_id(), "Unable to get film Original Language ID");
        Assertions.assertEquals(Duration.ofDays(0), testFilm.getRental_duration(), "Unable to get film rental duration");
        Assertions.assertEquals(0, testFilm.getRental_rate(), "Unable to get film rental rate");
        Assertions.assertEquals(Duration.ofHours(0), testFilm.getLength(), "Unable to get film length");
        Assertions.assertEquals(0.0, testFilm.getReplacement_cost(), "Unable to get film replacement cost");
        Assertions.assertEquals(0, testFilm.getRating(), "Unable to get film rating");
        Assertions.assertEquals("Special_Features", testFilm.getSpecial_features(), "Unable to get film special features");


        testFilm2.setTitle("testTitle");
        Assertions.assertEquals("testTitle", testFilm2.getTitle(), "Unable to set film Title");
        testFilm2.setDescription("testDescription");
        Assertions.assertEquals("testDescription", testFilm2.getDescription(), "Unable to set film description");
        testFilm2.setRelease_year(Year.of(2020));
        Assertions.assertEquals(Year.of(2020), testFilm2.getRelease_year(), "Unable to set film release year");
        testFilm2.setRental_duration(Duration.ofDays(1));
        Assertions.assertEquals(Duration.ofDays(1), testFilm2.getRental_duration(), "Unable to set film rental duration");
        testFilm2.setRental_rate(0.1);
        Assertions.assertEquals(0.1, testFilm2.getRental_rate(), "Unable to set film rental rate");
        testFilm2.setLength(Duration.ofHours(1));
        Assertions.assertEquals(Duration.ofHours(1), testFilm2.getLength(), "Unable to set film length");
        testFilm2.setReplacement_cost(0.1);
        Assertions.assertEquals(0.1, testFilm2.getReplacement_cost(), "Unable to set film replacement cost");
        testFilm2.setRating(1);
        Assertions.assertEquals(1, testFilm2.getRating(), "Unable to set film rating");
        testFilm2.setSpecial_features("testSfeatures");
        Assertions.assertEquals("testSfeatures", testFilm2.getSpecial_features(), "Unable to set film special features");
    }



}
