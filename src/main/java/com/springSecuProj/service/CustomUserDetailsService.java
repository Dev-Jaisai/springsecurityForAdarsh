package com.springSecuProj.service;

import com.springSecuProj.entity.User;
import com.springSecuProj.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> byUsername = userRepo.findByUsername(username);
        //db entity object username pass city
        //User  class Object 3 wrap username and password authrorites
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            System.out.println(user.getPassword());
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities(Collections.emptyList())
                    .build();
        } else {
            return null;
        }
    }

}
