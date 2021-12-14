package com.careerdevs.Expressian.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;


    @OneToMany
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private List<Rental> rentals;

    @ManyToOne
    @JoinTable(
            name = "vehicle_store",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    @JsonIgnoreProperties("vehicles")
    private Store store;

    private String make;
    private String model;

    public Vehicle(){}

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
