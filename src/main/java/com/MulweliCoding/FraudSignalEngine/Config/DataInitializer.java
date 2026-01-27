package com.MulweliCoding.FraudSignalEngine.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.MulweliCoding.FraudSignalEngine.Repository.UserAuthRepository;
import com.MulweliCoding.FraudSignalEngine.Repository.UserRepository;
import com.MulweliCoding.FraudSignalEngine.Model.*;
import com.MulweliCoding.FraudSignalEngine.Repository.*;

@Configuration
public class DataInitializer {

    private final UserAuthRepository userAuthRepository;

    DataInitializer(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }
    @Bean
    CommandLineRunner initUsers(
        UserRepository userRepo,
        UserAuthRepository authRepo,
        PasswordEncoder encoder
    ) {
        return args -> {

            if (userRepo.count() == 0) {
                // Admin
                User admin = new User(
                    "Admin_User",
                    "admin@fraud.local",
                    "0000000000",
                    "SYSTEM"
                );
                User savedAdmin = userRepo.save(admin);

                UserAuthentication adminAuth = new UserAuthentication();
                adminAuth.setUserId(savedAdmin.getUserId());
                adminAuth.setUsername(savedAdmin.getEmail());
                adminAuth.setPasswordHash(encoder.encode("Admin1234"));
                adminAuth.setRole("ADMIN");
                adminAuth.setIsEnabled(true);

                authRepo.save(adminAuth);

                // Service
                User service = new User(
                    "Fraud_Engine",
                    "service@fraud.local",
                    "N/A",
                    "INTERNAL"
                );
                User savedService = userRepo.save(service);

                UserAuthentication serviceAuth = new UserAuthentication();
                serviceAuth.setUserId(savedService.getUserId());
                serviceAuth.setUsername(savedService.getEmail());
                serviceAuth.setPasswordHash(encoder.encode("service1234"));
                serviceAuth.setRole("SERVICE");
                serviceAuth.setIsEnabled(true);

                authRepo.save(serviceAuth);
            }
        };
    }
}
