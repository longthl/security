package com.example.security.config;

import com.example.security.Repository.UserInfoRpository;
import com.example.security.Service.Impl.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final UserInfoRpository repository;
    @Bean
    public UserDetailsService userDetailsService(){
//
        return new UserInfoService(repository);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/customer/hello","/user/new").permitAll() // với endpoint /hello thì sẽ được cho qua
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/customer/all").hasAuthority("ROLE_ADMIN")// với endpoint /hello thì sẽ được cho qua
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/customer/**").authenticated() // với endpoint /customer/** sẽ yêu cầu authenticate
                .and().formLogin() // trả về page login nếu chưa authenticate
                .and().build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//@Bean
//    public PasswordEncoder passwordEncoder(){
//    return new BCryptPasswordEncoder();
//}
}
