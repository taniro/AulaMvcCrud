package tads.eaj.ufrn.aulamvccrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/cadastrarPage").authenticated();
                    auth.anyRequest().permitAll();
                })
                .formLogin()
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .and()
                .build();
    }

}
