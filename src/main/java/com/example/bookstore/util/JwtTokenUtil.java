package com.k8s.springboot.ticket.util;


import com.k8s.springboot.ticket.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 120000;

    private String secret = "YXNk";

    public String getEmailFromToken(String token) {
        return (String) getMapFromIoJsonwebtokenClaims(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()).get("sub");
    }

    public String generateToken(UserDto userLoginDto) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userLoginDto.getEmail());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private Map<String, Object> getMapFromIoJsonwebtokenClaims(Claims claims) {
        Map<String, Object> expectedMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            expectedMap.put(entry.getKey(), entry.getValue());
        }
        return expectedMap;
    }
}
