package com.springSecuProj.controller;

import com.springSecuProj.dto.RegistrationDto;
import com.springSecuProj.entity.User;
import com.springSecuProj.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDto registrationDto) {

        User user = new User();//dto to entity
        user.setUsername(registrationDto.getUsername());
        String encode = passwordEncoder.encode(registrationDto.getPassword());
        user.setPassword(encode);
        userRepo.save(user);
        return ResponseEntity.ok("User Registered Successfully");

    }
}
