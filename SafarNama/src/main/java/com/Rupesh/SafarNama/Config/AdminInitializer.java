package com.Rupesh.SafarNama.Config;

import com.Rupesh.SafarNama.Entity.User;
import com.Rupesh.SafarNama.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(User.builder().username("admin")
                        .email("info@safarnamaevents.in")
                        .password(encoder.encode("S@farnama#!2024"))
                        .role(Role.ADMIN)
                        .build());
            }
            ;
        };
    }
}