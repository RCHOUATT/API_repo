package com.ticket.API;

import com.ticket.API.Enum.Roles;
import com.ticket.API.Module.Admin;
import com.ticket.API.Module.Utilisateurs;
import com.ticket.API.Repository.User_repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication (exclude ={ SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(User_repository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			Optional<Utilisateurs> utilisateurs = userRepository.findByEmail("Admin@admin.com");
			if (utilisateurs.isEmpty()) {
				System.out.println("Hello1");
				Admin admin = new Admin();
				admin.setEmail("Admin@admin.com");
				System.out.println("Hello2");
				admin.setNom("Admin@admin.com");
				System.out.println("Hello3");
				admin.setPassword(passwordEncoder.encode("Admin@admin.com"));
				System.out.println("Hello4");
				admin.setRole(Roles.ADMIN);
				System.out.println("Hello5");
				userRepository.save(admin);
			}
		};
	}

}
