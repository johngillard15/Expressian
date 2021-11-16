package com.careerdevs.Expressian.store;

import com.careerdevs.Expressian.customer.Customer;
import com.careerdevs.Expressian.rental.Rental;
import com.careerdevs.Expressian.vehicle.Vehicle;

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
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
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
