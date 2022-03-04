package com.devsimple.hruser.config;

import com.devsimple.hruser.model.Role;
import com.devsimple.hruser.model.User;
import com.devsimple.hruser.repository.RoleRepository;
import com.devsimple.hruser.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Role roleAdmin = new Role(1l, "ROLE_ADMIN");
        Role roleOperator = new Role(2l, "ROLE_OPERATOR");

        roleRepository.saveAll(Arrays.asList(roleAdmin, roleOperator));

        User user1 = new User(null, "Antonio Sousa", "antonio@gmail.com", passwordEncoder.encode("123456"));
        User user2 = new User(null, "Rigoni Emilio", "rigoni@gmail.com", passwordEncoder.encode("123456"));
        User user3 = new User(null, "Calleri Silva", "calleri@gmail.com", passwordEncoder.encode("123456"));

        user1.getRoles().addAll(Arrays.asList(roleAdmin));
        user2.getRoles().addAll(Arrays.asList(roleOperator));
        user3.getRoles().addAll(Arrays.asList(roleOperator));

        userRepository.saveAll(Arrays.asList(user1, user2, user3));



    }
}
