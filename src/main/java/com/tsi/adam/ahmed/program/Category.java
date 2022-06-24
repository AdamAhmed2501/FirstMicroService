package com.tsi.adam.ahmed.program;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Attributes
    private int category_id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    //Empty Constructor
    public Category(){
    }

    public int getCategory_id(){
        return category_id;
    }

    public void setCategory_id(int category_id){
        this.category_id = category_id;
    }

    public String get_name(){
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }


}
