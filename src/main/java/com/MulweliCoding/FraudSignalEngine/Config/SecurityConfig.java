package com.MulweliCoding.FraudSignalEngine.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import com.MulweliCoding.FraudSignalEngine.Repository.UserAuthRepository;
import com.MulweliCoding.FraudSignalEngine.Config.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public UserDetailsService UserDetailService(UserAuthRepository userAuthRepo){
        return new CustomUserDetailService(userAuthRepo);
    }

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception{
        http 
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/v1/users").hasRole("ADMIN")
        .requestMatchers("/api/v1/fraud-engine").hasRole("SERVICE")
        .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
