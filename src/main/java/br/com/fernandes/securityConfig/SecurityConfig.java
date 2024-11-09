package br.com.fernandes.securityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> 
                authorize
                    .requestMatchers("/user/**").authenticated() // Protege o endpoint /user
                    .anyRequest().permitAll()  // Permite acesso aos demais endpoints
            )
            .httpBasic() // Configura autenticação básica
            .and()
            .csrf().disable(); // Desabilita CSRF para testes no Postman

        return http.build();
    }
}