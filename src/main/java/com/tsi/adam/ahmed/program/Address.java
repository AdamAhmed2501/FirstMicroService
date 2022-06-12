package com.tsi.adam.ahmed.program;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
@Table(name ="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    private int city_id;

    //Attributes
    private String address;
    private String address2;
    private String district;
    private String postal_code;
    private double phone;
    private String location;

    public Address(String address, String address2, String district, String postal_code, double phone, String location) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postal_code = postal_code;
        this.phone = phone;
        this.location = location;
    }

    //Empty Constructor

    public Address() {
    }

    public int getAddress_id(){
        return address_id;
    }

    public void setAddress_id(int address_id){this.address_id = address_id;}

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2(){
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict(){
        return district;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public int getCity_id(){
        return city_id;
    }

    public void setCity_id(int city_id){this.city_id = city_id;}

    public String getPostal_code(){
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public double getPhone(){return phone;}

    public void setPhone(double phone){this.phone = phone;}

    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
