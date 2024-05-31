package rest.Rest_Beginning.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import rest.Rest_Beginning.dao.RegisteredUsersRepo;
import rest.Rest_Beginning.dto.CustomUserDetails;
import rest.Rest_Beginning.exception.UsernameNotFoundException;

@Configuration
public class ApplicationConfiguration {
    private final RegisteredUsersRepo registeredUsersRepo;
    @Autowired
    private ModelMapper modelMapper;

    public ApplicationConfiguration(RegisteredUsersRepo registeredUsersRepo){
        this.registeredUsersRepo=registeredUsersRepo;
    }
    @Bean
    UserDetailsService userDetailsService() throws  UsernameNotFoundException{
        return username -> this.modelMapper.map( registeredUsersRepo.findByEmail(username),CustomUserDetails.class);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

   @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}
