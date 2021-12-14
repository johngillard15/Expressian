package com.careerdevs.Expressian.repositories;

import com.careerdevs.Expressian.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {}