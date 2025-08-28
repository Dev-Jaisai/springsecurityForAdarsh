package com.springSecuProj.controller;

import com.springSecuProj.Utility.JwtService;
import com.springSecuProj.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticationController")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDto  loginDto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        boolean authenticated = authenticate.isAuthenticated();

        UserDetails userDetails = (UserDetails) authenticate.getPrincipal();

        if (authenticated){
            String token = jwtService.generateJwtToken(userDetails);

            return token;
        }
       return "authentication failed";
      }
    @GetMapping("/hi")
    public String loginUser(){
        return "Hi";
    }

}
