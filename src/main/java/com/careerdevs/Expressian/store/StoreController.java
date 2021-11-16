package com.careerdevs.Expressian.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/Store")
public class StoreController {
    @Autowired private StoreRepository repository;

    @GetMapping
    public @ResponseBody List<Store> getRepository() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Store getOneStore(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public @ResponseBody Store createStore(@RequestBody Store newVehicle){
        return repository.save(newVehicle);
    }

    @PutMapping("/{id}")
    public @ResponseBody Store updateStore(@PathVariable Long id, @RequestBody Store updates){
        Store store = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(updates.getName() != null) store.setName(updates.getName());
        if(updates.getLocation() != null) store.setLocation(updates.getLocation());

        return repository.save(store);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyStore(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
