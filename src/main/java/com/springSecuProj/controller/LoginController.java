package com.springSecuProj.controller;

import com.springSecuProj.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticationController")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDto  loginDto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        boolean authenticated = authenticate.isAuthenticated();
        if (authenticated){
            return "User Validated";
        }
       return "authentication failed";
    }
    @GetMapping("/hi")
    public String loginUser(){
        return "Hi";
    }

}
