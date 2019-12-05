package com.verho.todorefactor;

import com.verho.todorefactor.model.User;
import com.verho.todorefactor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodorefactorApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodorefactorApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            List<String> roles = new ArrayList<>();
            roles.add("ADMIN");
            roles.add("USER");
            userRepository.saveAndFlush(
                    User.builder()
                            .username("admin")
                            .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"))
                            .roles(roles)
                            .build());
        };
    }
}
