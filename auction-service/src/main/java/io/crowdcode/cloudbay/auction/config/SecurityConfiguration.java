package io.crowdcode.cloudbay.auction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    @Order(1)
    public SecurityFilterChain privateSecurityFilterChain(HttpSecurity http) throws Exception {
        var scf =  http
                .securityMatcher("/user/**","/login/**", "/logout", "/oauth2/**")
                .authorizeHttpRequests(authorizeConfig -> {
                    authorizeConfig.requestMatchers("/user/private").authenticated();
//                            .hasRole("user");
                    authorizeConfig.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                .build();
        return scf;
    }
    @Bean
    @Order(2)
    public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception {
        var scf = http.securityMatcher("/api/**","/login/**", "/logout", "/oauth2/**").authorizeHttpRequests(authorizeConfig ->{
                authorizeConfig.requestMatchers("/api/private").authenticated();
//                .hasRole("admin");
                authorizeConfig.requestMatchers("/api/user").authenticated();
             })
            .formLogin(Customizer.withDefaults())
            .oauth2Login(Customizer.withDefaults())
            .build();
        return scf;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("user")
                        .password("{noop}password")
                        .authorities("ROLE_user", "ROLE_admin")
                        .build()
        );
    }

    }
