package com.example.blooddonet.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthntictionService {


    public UserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            // User is not authenticated
            throw new UsernameNotFoundException("User Not found");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
            // Get user information


        } else {
            throw new UsernameNotFoundException("User Not found");

        }
    }
}


