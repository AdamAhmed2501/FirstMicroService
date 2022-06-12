package com.tsi.adam.ahmed.program;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
@Table(name ="film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private int language_id;
    private int original_language_id;


    //Attributes
    private String title;
    private String description;
    private java.time.Year release_year;
    private java.time.Duration rental_duration;
    private double rental_rate;
    private java.time.Duration length;
    private double replacement_cost;
    private int rating;
    private String special_features;


    public Film(String title, String description, java.time.Year release_year, java.time.Duration rental_duration,
                double rental_rate, java.time.Duration length, double replacement_cost, int rating,
                String special_features) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this. rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
    }

    //Empty Constructor
    public Film(){
    }

    public int getFilm_id(){
        return film_id;
    }

    public void setFilm_id(int film_id){
        this.film_id = film_id;
    }


    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public java.time.Year getRelease_year() { return release_year; }

    public void setRelease_year(java.time.Year release_year) {this.release_year = release_year;}


    public int getLanguage_id() { return language_id; }

    public void setLanguage_id (int language_id) {this.language_id = language_id;}


    public int getOriginal_Language_id() { return original_language_id; }

    public void setOriginal_Language_id (int original_language_id) {this.original_language_id = original_language_id;}


    public java.time.Duration getRental_duration() { return rental_duration; }

    public void setRental_duration (java.time.Duration rental_duration) {this.rental_duration = rental_duration;}


    public double getRental_rate() { return rental_rate; }

    public void setRental_rate (double rental_rate) {this.rental_rate = rental_rate;}


    public java.time.Duration getLength() { return length; }

    public void setLength (java.time.Duration length) {this.length = length;}


    public double getReplacement_cost() { return replacement_cost; }

    public void setReplacement_cost (double replacement_cost) {this.replacement_cost = replacement_cost;}


    public int getRating() { return rating; }

    public void setRating (int rating) {this.rating = rating;}


    public String getSpecial_features(){
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

}
