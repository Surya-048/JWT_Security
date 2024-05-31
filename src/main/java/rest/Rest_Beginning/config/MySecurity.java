package rest.Rest_Beginning.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//public class MySecurity{
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails normalUser = User.withUsername("Surya")
//                .password(passwordEncoder().encode("password"))
//                .roles("NORMAL").build();
//
//        UserDetails adminUser = User.withUsername("Udit")
//                .password(passwordEncoder().encode("password"))
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(normalUser,adminUser);
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
////        http.csrf().disable().authorizeHttpRequests((authz)->authz.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
//        http.csrf().disable().authorizeHttpRequests()
//                .anyRequest()
//                .authenticated().and().httpBasic();
//        return http.build();
//    }
//}
