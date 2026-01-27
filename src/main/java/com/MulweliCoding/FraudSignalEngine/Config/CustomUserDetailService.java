package com.MulweliCoding.FraudSignalEngine.Config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.MulweliCoding.FraudSignalEngine.Model.UserAuthentication;
import com.MulweliCoding.FraudSignalEngine.Repository.UserAuthRepository;

public class CustomUserDetailService implements UserDetailsService{
    private final UserAuthRepository userAuthReop;

    public CustomUserDetailService(UserAuthRepository userAuthRepo){
        this.userAuthReop = userAuthRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserAuthentication userAuth = userAuthReop.findByUsername(username)
                                      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return User.builder()
                .username(userAuth.getUsername())
                .password(userAuth.getPasswordHash())
                .roles(userAuth.getRole())
                .disabled(!userAuth.getIsEnabled())
                .build();
    }
    
}
