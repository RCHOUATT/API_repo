package com.ticket.API.SecurityConfig;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private UserDetailImpl userDetail;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.userDetailsService(userDetail);
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry->{
                    registry
                            .requestMatchers("/user/**").hasRole("ADMIN")
                            .requestMatchers("/notif/**").hasRole("ADMIN")
                            .requestMatchers("/BDCon/createBdCon", "BDCon/deleteBDCon/", "BDCon/deleteBDCon/", "/ticket/Ouvrir_ticket/**", "/reponse/**").hasAnyRole("FORMATEUR", "ADMIN")
                            .requestMatchers("/BDCon/AfficherBDCon/","/BDCon/AfficherBDCons", "/ticket/Afficher_Ticket").hasAnyRole("FORMATEUR", "APPRENANT", "ADMIN")
                            .requestMatchers("/ticket/createTicket", "/ticket/delete/**", "/ticket/updateTicket/**", "/ticket/Trier_ticket", "/reponse/AfficherReponse").hasAnyRole("APPRENANT", "ADMIN")
                            .anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetail);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
