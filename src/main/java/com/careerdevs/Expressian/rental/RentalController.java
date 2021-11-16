package com.careerdevs.Expressian.rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("api/rentals")
public class RentalController {
    @Autowired private RentalRepository repository;

    @GetMapping("/{id}")
    public @ResponseBody Rental getOneRental(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public @ResponseBody Rental createRental(@RequestBody Rental newRental){
        return repository.save(newRental);
    }

    @PutMapping("/{id}")
    public @ResponseBody Rental updateRental(@PathVariable Long id, @RequestBody Rental updates){
        Rental rental = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(updates.getCustomer() != null) rental.setCustomer(updates.getCustomer());
        if(updates.getVehicle() != null) rental.setVehicle(updates.getVehicle());

        return repository.save(rental);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyRental(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
