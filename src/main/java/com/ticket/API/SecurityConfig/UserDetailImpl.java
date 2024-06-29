package com.ticket.API.SecurityConfig;

import com.ticket.API.Module.Utilisateurs;
import com.ticket.API.Repository.User_repository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailImpl implements UserDetailsService {
    private User_repository user_repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("hello");
        Optional<Utilisateurs> utilisateurs = user_repository.findByEmail(email);
        if (utilisateurs.isPresent()){
            System.out.println("hello1");
            System.out.println(utilisateurs.get().getEmail());
            System.out.println(utilisateurs.get().getPassword());
            System.out.println(utilisateurs.get().getRole());
        }

        return User.
                withUsername(utilisateurs.get().getEmail()).
                password(utilisateurs.get().getPassword()).
                roles(String.valueOf(utilisateurs.get().getRole())).
                build();
    }
}