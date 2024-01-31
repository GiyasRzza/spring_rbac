package com.example.spring_rbac.controller;

import com.example.spring_rbac.dao.RoleDao;
import com.example.spring_rbac.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("role")
public class RoleController {
    private RoleRepository roleRepository;

    @PostMapping
        public RoleDao createRole(@RequestBody RoleDao roleDao){
            return roleRepository.save(roleDao);
        }
}
