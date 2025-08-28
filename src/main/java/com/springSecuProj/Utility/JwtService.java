package com.springSecuProj.Utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {


    private final String jwtKey = "jasdshj;isdgbgiusngdaklfjlakfnlafnalknfajsidgnjsiadasdai";
    private final long expirationTime = 24 * 60 * 60 * 1000;//24 hour
    private final Key secreateKey = Keys.hmacShaKeyFor(jwtKey.getBytes());

    public String generateJwtToken(UserDetails userDetails) {


        //jwt token header payload and secret key
        String username = userDetails.getUsername();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secreateKey)
                .compact();
//set username  expiry token secrete key
    }

    //validate token
}
