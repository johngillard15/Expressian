package com.careerdevs.Expressian.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired private VehicleRepository repository;

    @GetMapping
    public @ResponseBody List<Vehicle> getRepository() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Vehicle getOneVehicle(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public @ResponseBody Vehicle createVehicle(@RequestBody Vehicle newVehicle){
        return repository.save(newVehicle);
    }

    @PutMapping("/{id}")
    public @ResponseBody Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updates){
        Vehicle vehicle = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(updates.getMake() != null) vehicle.setMake(updates.getMake());
        if(updates.getModel() != null) vehicle.setModel(updates.getModel());

        return repository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyVehicle(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
