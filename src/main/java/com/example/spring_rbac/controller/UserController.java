package com.example.spring_rbac.controller;

import com.example.spring_rbac.dao.RoleDao;
import com.example.spring_rbac.dao.UserDao;
import com.example.spring_rbac.dto.LoginDto;
import com.example.spring_rbac.dto.RegisterDto;
import com.example.spring_rbac.repository.RoleRepository;
import com.example.spring_rbac.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class UserController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if (userRepository.existsByUserName(registerDto.getUserName())) {
            return new ResponseEntity<>("User is Taken!", HttpStatus.BAD_REQUEST);
        }
        else {
            UserDao userDao = new UserDao();
            userDao.setUserName(registerDto.getUserName());
            userDao.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            RoleDao roleDao = roleRepository.findByRoleName("USER");
            userDao.setRole(Collections.singletonList(roleDao));
            userRepository.save(userDao);
            return new ResponseEntity<>("User Register Success!",HttpStatus.ACCEPTED);
        }
    }
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUserName(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return  new ResponseEntity<>("User signed success!!",HttpStatus.OK);
    }
}
