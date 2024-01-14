package br.com.sonnesen.springsecurityjwt;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {
  
  private final JwtEncoder encoder;

  public String generateToken(Authentication authentication) {
    Instant now = Instant.now();
    Instant expireAt = now.plusSeconds(3_600L);

    String scopes = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(" "));

    JwtClaimsSet claims = JwtClaimsSet.builder()
        .issuer("spring-security-jwt")
        .issuedAt(now)
        .expiresAt(expireAt)
        .subject(authentication.getName())
        .claim("scope", scopes)
        .build();

    return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }

}
