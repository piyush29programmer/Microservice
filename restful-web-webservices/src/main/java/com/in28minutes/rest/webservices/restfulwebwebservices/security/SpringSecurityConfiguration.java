package com.in28minutes.rest.webservices.restfulwebwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

//        #1) All request should be authenticated.
//#2) if request is not auth , a web page thrown
//#3) CSRF -> POST , PUT
        http.authorizeHttpRequests(
                auth->auth.anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf().disable();

        return http.build();
    }
}
