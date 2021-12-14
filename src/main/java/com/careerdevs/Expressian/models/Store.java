package com.careerdevs.Expressian.models;

import com.careerdevs.Expressian.models.Customer;
import com.careerdevs.Expressian.models.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Store {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Set<Customer> customers;

    @ManyToMany
    @JoinTable(
            name = "vehicle_store",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    @JsonIgnoreProperties("store")
    private List<Vehicle> vehicles;

    private String name;
    private String location;

    public Store(){}

    public Store(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
