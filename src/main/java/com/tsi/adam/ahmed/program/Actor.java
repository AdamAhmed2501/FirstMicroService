package com.tsi.adam.ahmed.program;

import net.minidev.json.annotate.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    //Attributes
    private String first_name;
    private String last_name;

    public Actor(String firstName, String lastName) {
        this.first_name = firstName;
        this.last_name = lastName;
    }

    //Empty Constructor
    public Actor(){
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id){
        this.actor_id = actor_id;
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

}
