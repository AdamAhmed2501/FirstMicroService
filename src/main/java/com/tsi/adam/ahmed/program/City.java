package com.tsi.adam.ahmed.program;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
@Table(name ="city")

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    private int country_id;

    //Attributes
    private String city;
    public City(String city) {
        this.city = city;
    }

    //Empty Constructor
    public City(){}

    public int getCity_id(){
        return city_id;
    }

    public void setCity_id(int city_id){
        this.city_id = city_id;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry_id(){ return country_id; }

    public void setCountry_id(int country_id){
        this.country_id = country_id;
    }

}
