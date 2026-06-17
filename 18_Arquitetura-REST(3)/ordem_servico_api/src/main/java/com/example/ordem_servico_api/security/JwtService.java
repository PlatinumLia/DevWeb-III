package com.example.ordem_servico_api.security;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    private JwtEncoder encoder;

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 525600L;

        String roles = authentication
            .getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors
                .joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("spring-security-jwt")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(authentication.getName())
            .claim("scope", roles)
            .build();

        return encoder.encode(
            JwtEncoderParameters.from(claims))
            .getTokenValue();
    }
}
