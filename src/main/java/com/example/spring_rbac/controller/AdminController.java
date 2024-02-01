package com.example.spring_rbac.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/testRole")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String get(){
        return "Get:: user";
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String post(){
        return "Post:: admin";
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(){
        return "Delete:: admin";
    }
}
