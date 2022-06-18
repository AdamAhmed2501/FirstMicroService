package com.tsi.adam.ahmed.program;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private int store_id;
    private int address_id;



    //Attributes
    private String first_name;
    private String last_name;
    private String email;
    private boolean active;
    private LocalDate create_date;



    public Customer(String first_name, String last_name, String email, boolean active, LocalDate create_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.active = active;
        this.create_date = create_date;
    }

    //Empty Constructor
    public Customer(){
    }

    public int getCustomer_id(){
        return customer_id;
    }

    public void setCustomer_id(int customer_id){
        this.customer_id = customer_id;
    }

    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name=last_name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public LocalDate getCreate_date(){return create_date;}

    public void setCreate_date(LocalDate create_date){
        this.create_date = create_date;
    }

}
