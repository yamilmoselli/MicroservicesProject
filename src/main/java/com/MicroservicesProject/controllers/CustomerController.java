package com.MicroservicesProject.controllers;

import com.MicroservicesProject.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Customer> getCustomers() {
        return customers;
    }


}
