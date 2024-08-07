package ru.fathutdinova.auctionengine.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) ->
                        authorize
//                                .requestMatchers("/auction/create").hasRole("AUCTIONEER")
//
//                                .requestMatchers("/auction/update").hasRole("ADMIN")
//                                .requestMatchers("/user/update").hasRole("ADMIN")
//                                .requestMatchers("/auctionLot/update").hasRole("ADMIN")
//                                .requestMatchers("/auction/delete").hasRole("ADMIN")
//                                .requestMatchers("/auctionLot/delete").hasRole("ADMIN")
//                                .requestMatchers("/user/delete").hasRole("ADMIN")
//
//                                .requestMatchers("/auctionLot/create").hasRole("USER")
                                .anyRequest().permitAll()

//                                .requestMatchers("/user/**").hasRole("USER")

//                                .anyRequest().hasRole("USER")

                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
