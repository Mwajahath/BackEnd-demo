package com.test.test.Config;

import com.test.test.Entity.Role;
import com.test.test.Enum.ERole;
import com.test.test.Repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName(ERole.ROLE_ADMIN);
                roleRepository.save(adminRole);
            }

            if (roleRepository.findByName(ERole.ROLE_STUDENT).isEmpty()) {
                Role studentRole = new Role();
                studentRole.setName(ERole.ROLE_STUDENT);
                roleRepository.save(studentRole);
            }
        };
    }
}

