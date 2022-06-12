package com.tsi.adam.ahmed.program;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
@Table(name ="country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;

    //Attributes
    private String country;

    public Country(String country) {
        this.country = country;
    }

    //Empty Constructor
    public Country(){}

    public int getCountry_id(){
        return country_id;
    }

    public void setCountry_id(int country_id){
        this.country_id = country_id;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
