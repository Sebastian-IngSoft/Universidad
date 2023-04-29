package com.example.proyectorisar2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SprintSecurityConfig {

    /*
    @Bean
    public static BCryptPasswordEncoder encriptarPassword(){

        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
    }
     */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/LoginS").defaultSuccessUrl("/SystemRisar/",true).permitAll()
            .and().logout().permitAll();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web)-> web.ignoring().antMatchers("/CSS/**","/JS/**","/img/**");
    }
     
    @Bean
    public InMemoryUserDetailsManager configureAuthentication(){
        List<UserDetails> listaUsuarios = new ArrayList<>();
        List<GrantedAuthority> rolesAdministradores = new ArrayList<>();
        List<GrantedAuthority> rolesUsuarios = new ArrayList<>();

        rolesAdministradores.add(new SimpleGrantedAuthority("Admin"));
        rolesUsuarios.add(new SimpleGrantedAuthority("User"));

        listaUsuarios.add(new User("Admin", "{noop}admin", rolesAdministradores));
        listaUsuarios.add(new User("Miriam", "{noop}12345", rolesAdministradores));
        listaUsuarios.add(new User("Juan", "{noop}12345", rolesAdministradores));
        listaUsuarios.add(new User("test", "{noop}test", rolesAdministradores));

        return new InMemoryUserDetailsManager(listaUsuarios);
    }
    
}
