package com.careerdevs.Expressian.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired private CustomerRepository repository;

    @GetMapping
    public @ResponseBody List<Customer> getRepository() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Customer getOneCustomer(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public @ResponseBody Customer createCustomer(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }

    @PutMapping("/{id}")
    public @ResponseBody Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updates){
        Customer customer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(updates.getFirstName() != null) customer.setFirstName(updates.getFirstName());
        if(updates.getLastName() != null) customer.setLastName(updates.getLastName());

        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCustomer(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
