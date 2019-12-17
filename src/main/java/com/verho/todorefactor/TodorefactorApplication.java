package com.verho.todorefactor;

import com.verho.todorefactor.model.Status;
import com.verho.todorefactor.model.Todo;
import com.verho.todorefactor.model.User;
import com.verho.todorefactor.repository.TodoRepository;
import com.verho.todorefactor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.Collections;

@SpringBootApplication
public class TodorefactorApplication {

    @Autowired
    UserRepository userRepository;

    @Qualifier("db")
    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodorefactorApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {

            todoRepository.saveAndFlush(Todo.builder().status(Status.ACTIVE).title("test").build());

            userRepository.saveAndFlush(
                    User.builder()
                            .username("admin")
                            .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"))
                            .roles(Collections.singletonList("ROLE_ADMIN"))
                            .build());
            userRepository.saveAndFlush(
                    User.builder()
                            .username("user")
                            .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user"))
                            .roles(Collections.singletonList("ROLE_USER"))
                            .build());
        };
    }
}
