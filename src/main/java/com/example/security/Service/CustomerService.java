package com.example.security.Service;


import org.springframework.security.core.userdetails.UserDetails;

public interface CustomerService {
    UserDetails loadUserByname(String name);
}
