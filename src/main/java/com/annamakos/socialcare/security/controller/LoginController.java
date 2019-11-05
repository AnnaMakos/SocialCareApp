package com.annamakos.socialcare.security.controller;
import com.annamakos.socialcare.security.configuration.JwtProvider;
import com.annamakos.socialcare.security.message.request.Login;
import com.annamakos.socialcare.security.message.response.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    JwtProvider jwtProvider;
    AuthenticationManager manager;

    public LoginController(JwtProvider jwtProvider, AuthenticationManager manager){
        this.jwtProvider = jwtProvider;
        this.manager = manager;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity authenticateUser(@RequestBody Login login) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(),
                        login.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        return ResponseEntity.ok(new Token(token));
    }
}
