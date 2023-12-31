package com.example.security.controller;

import com.example.security.model.Costomer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/customer")
public class CostomerController {
    final private List<Costomer> customers = List.of(
            Costomer.builder().id("001").name("Customer 1").email("c1@gmail.com").build(),
            Costomer.builder().id("002").name("Customer 2").email("c2@gmail.com").build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello is exception");
    }
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Costomer>> getCustomerList(){
        List<Costomer> customers=this.customers;
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Costomer> getCustomerList(@PathVariable("id") String id) {
        List<Costomer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();
        return ResponseEntity.ok(customers.get(0));
    }
}
