package com.MicroservicesProject.controllers;

import com.MicroservicesProject.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<Customer> (List.of(
            new Customer(1, "yamil", "ymsl", "123"),
            new Customer(2, "juan", "juanrz", "hola"),
            new Customer(3, "carlos", "carlitos", "qwer"),
            new Customer(4, "alberto", "albertgz", "asdf")
    ));


    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        for (Customer v: customers) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    @PostMapping("/customer")
    public List<Customer> addCustomer(@RequestBody Customer c) {
        customers.add(c);
        return customers;
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer c) {
        for (Customer v: customers) {
            if (v.getId() == c.getId()) {
                v.setName(c.getName());
                v.setPassword(c.getPassword());
                return v;
            }
        }
        return null;
    }


}
