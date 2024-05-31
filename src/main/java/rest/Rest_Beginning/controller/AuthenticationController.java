package rest.Rest_Beginning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rest.Rest_Beginning.dto.LoginResponse;
import rest.Rest_Beginning.dto.RegisterLoginUserDto;
import rest.Rest_Beginning.model.RegisteredUsers;
import rest.Rest_Beginning.service.AuthenticationService;
import rest.Rest_Beginning.service.JwtService;

@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @Autowired
    private UserDetailsService userDetailsService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")

    public ResponseEntity<RegisteredUsers> register(@RequestBody RegisterLoginUserDto registerUserDto) {

        RegisteredUsers registeredUsers = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUsers);
    }

    @PostMapping("/login")

    public ResponseEntity<LoginResponse> authenticate(@RequestBody RegisterLoginUserDto registerLoginUserDto) {

        RegisteredUsers authenticatedUser = authenticationService.authenticate(registerLoginUserDto);

        String jwtToken = jwtService.generateToken(this.userDetailsService.loadUserByUsername(registerLoginUserDto.getEmail()));

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
