package com.example.spring_rbac.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    private CustomUserDetailsService customUserDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.csrf().disable().authorizeRequests().
                requestMatchers("/auth/**").permitAll().
              requestMatchers("/role").hasRole("USER")
                .and().httpBasic();
    return security.build();
    }

//    @Bean
//    public UserDetailsService user(){
//        UserDetails admin  = User.builder().
//                username("admin").password("password").
//                roles("ADMIN").build();
//        UserDetails user  = User.builder().
//                username("user").password("password").
//                roles("USER").build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
            return  configuration.getAuthenticationManager();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
