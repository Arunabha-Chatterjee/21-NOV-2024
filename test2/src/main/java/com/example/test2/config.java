package com.example.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class config{
    @Bean
    public SecurityFilterChain securirityfilterchain(HttpSecurity http) throws Exception{
        return http
                .csrf(customize ->customize.disable())
                .authorizeHttpRequests(request -> request
                                .requestMatchers("login").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails Karan = User
                .withDefaultPasswordEncoder()
                .username("Karan")
                .password("123")
                .roles("Users")
                .build();

        return new InMemoryUserDetailsManager(Karan);
    }
}
