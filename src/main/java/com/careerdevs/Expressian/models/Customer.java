package com.careerdevs.Expressian.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private List<Rental> rentals;

    @ManyToMany
    @JoinTable(
            name = "customer_store",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    @JsonIgnoreProperties("customers")
    private List<Store> stores;

    private String firstName;
    private String lastName;

    public Customer(){}

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
