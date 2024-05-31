package rest.Rest_Beginning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rest.Rest_Beginning.dao.RegisteredUsersRepo;
import rest.Rest_Beginning.dto.RegisterLoginUserDto;
import rest.Rest_Beginning.exception.Generic_Exception;
import rest.Rest_Beginning.exception.UsernameNotFoundException;
import rest.Rest_Beginning.model.RegisteredUsers;

@Service
public class AuthenticationService {

    @Autowired
    private UserDetailsService userDetailsService;

    private final RegisteredUsersRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(
            RegisteredUsersRepo userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder

    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public RegisteredUsers signup(RegisterLoginUserDto input) {
        UserDetails userDetail = this.userDetailsService.loadUserByUsername(input.getEmail());

        if( userDetail!=null && userDetail.getUsername().equals(input.getEmail())){
            throw new UsernameNotFoundException("User "+input.getEmail()+" Already Exists , Login Please");
        }
        RegisteredUsers user = new RegisteredUsers();
        user.setRole(input.getRole());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public RegisteredUsers authenticate(RegisterLoginUserDto input) throws UsernameNotFoundException, BadCredentialsException {
        if (!userRepository.findByEmail(input.getEmail()).isPresent()) {
            throw  new UsernameNotFoundException("No user Available");
        } else {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getEmail(),
                            input.getPassword()
                    )
            );

            return userRepository.findByEmail(input.getEmail()).get();
//                    .orElseThrow(() -> new UsernameNotFoundException("No User Availablea"));
        }
    }
}
