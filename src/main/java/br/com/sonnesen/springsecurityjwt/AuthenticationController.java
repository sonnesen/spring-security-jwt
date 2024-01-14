package br.com.sonnesen.springsecurityjwt;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
  
  private final AuthenticationService authenticationService;

  @PostMapping("/authenticate")
  public String authenticate(Authentication authentication) {
    return this.authenticationService.authenticate(authentication);
  }

}
