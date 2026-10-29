package gt.edu.url.edunova_spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filtros(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(reglas -> reglas
                .requestMatchers("/login", "/style.css", "/error").permitAll()
                .requestMatchers("/", "/login", "/capacitaciones", "/style.css", "/error").permitAll()
                .requestMatchers("/participantes/nuevo", "/participantes/*/editar").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/participantes/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/participantes", true))
            .logout(logout -> logout
                .logoutSuccessUrl("/login?salio"))
            .exceptionHandling(errores -> errores
                .accessDeniedPage("/acceso-denegado"));

        return http.build();
    }
}