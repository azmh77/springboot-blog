package com.rhpm.testapp.modules.config;

import com.rhpm.testapp.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecutiryConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,UserService userService,@Lazy PasswordEncoder passwordEncoder) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    /*@Bean(name = "passwordEncoder")
    public PasswordEncoder BCPasswordEncoder(){
        return new BCryptPasswordEncoder(11);
    }*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/", "GET")).permitAll()
                        .requestMatchers("/css/**" , "").permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/users", "")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/category","")).hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/Login")
                        .usernameParameter("email")
                        //.successHandler()
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/Login")
                        .permitAll()
                )
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
}

