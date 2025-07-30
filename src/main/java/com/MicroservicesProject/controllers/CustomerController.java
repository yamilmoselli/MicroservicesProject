package com.MicroservicesProject.controllers;

import com.MicroservicesProject.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private List<Customer> customers = new ArrayList<Customer> (List.of(
            new Customer(1, "yamil", "ymsl", "123"),
            new Customer(2, "juan", "juanrz", "hola"),
            new Customer(3, "carlos", "carlitos", "qwer"),
            new Customer(4, "alberto", "albertgz", "asdf")
    ));


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getCustomer(@PathVariable String username) {
        for (Customer v: customers) {
            if (v.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(v);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer username not found: " + username);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer c) {
        customers.add(c);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully: " + c.getUsername());
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer c) {
        for (Customer v: customers) {
            if (v.getUsername().equalsIgnoreCase(c.getUsername())) {
                v.setName(c.getName());
                v.setPassword(c.getPassword());
                return ResponseEntity.ok(v);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer username not found: " + c.getUsername());
    }

    @PatchMapping("/{}id")
    public ResponseEntity<?> patchCustomer(@RequestBody Customer c) {
        for (Customer v: customers) {
            if (v.getId() == c.getId()) {

                if (c.getName() != null) {
                    v.setName(c.getName());
                }
                if (c.getPassword() != null) {
                    v.setPassword(c.getPassword());
                }

                return ResponseEntity.ok("Customer modified successfully: " + v.getUsername());

            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer username not found: " + c.getUsername());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        for (Customer v: customers) {
            if (v.getId() == id) {
                customers.remove(v);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
    }
    
}
