package com.careerdevs.Expressian.repositories;

import com.careerdevs.Expressian.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}